package cn.fluoxetine.fluoxetinebackstage.service.impl;

import cn.fluoxetine.fluoxetinebackstage.mapper.FtbNoteTypeMapper;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbNoteType;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbNoteTypeExample;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;
import cn.fluoxetine.fluoxetinebackstage.service.NoteTypeService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 11699
 * @date 2020/2/10 - 13:10
 */
@Service
@Transactional
public class NoteTypeServiceImpl implements NoteTypeService {

    @Autowired
    private FtbNoteTypeMapper noteTypeMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public PageResult search(FtbNoteType noteType, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        FtbNoteTypeExample example = new FtbNoteTypeExample();

        if(noteType!=null){
            FtbNoteTypeExample.Criteria criteria = example.createCriteria();
            if(noteType.getType()!=null&&noteType.getType().length()>0){
                criteria.andTypeLike("%"+noteType.getType()+"%");
            }
            if (noteType.getUserVisual()!=null){
                criteria.andUserVisualEqualTo(noteType.getUserVisual());
            }

        }
        Page<FtbNoteType> page = (Page<FtbNoteType>) noteTypeMapper.selectByExample(example);

        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void add(FtbNoteType noteType) throws Exception {
        FtbNoteTypeExample example = new FtbNoteTypeExample();
        FtbNoteTypeExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo(noteType.getType());
        List<FtbNoteType> list = noteTypeMapper.selectByExample(example);

        if (list!=null&&list.size()>0){
            throw new Exception();
        }
        noteTypeMapper.insert(noteType);

        if (noteType.getUserVisual() == 1){

            //写入缓存
            FtbNoteType ftbNoteType = noteTypeMapper.selectByPrimaryKey(noteType.getId());
            stringRedisTemplate.boundHashOps("notetypelist").put(ftbNoteType.getId().toString(), JSON.toJSONString(ftbNoteType));
            System.out.println("notetypelist 缓存添加成功~~");
        }
    }

    @Override
    public FtbNoteType findOne(Integer id) {
        return noteTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(FtbNoteType noteType) {
        noteTypeMapper.updateByPrimaryKey(noteType);

        if (noteType.getUserVisual() == 1){
            //添加缓存
            stringRedisTemplate.boundHashOps("notetypelist").put(noteType.getId().toString(), JSON.toJSONString(noteType));

        }
        if (noteType.getUserVisual() == 0){
            //删除缓存
            stringRedisTemplate.boundHashOps("notetypelist").delete(noteType.getId().toString());
        }
        System.out.println("notetypelist 缓存更新成功");

    }

    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            noteTypeMapper.deleteByPrimaryKey(id);

            //删除缓存
            stringRedisTemplate.boundHashOps("notetypelist").delete(id.toString());
            System.out.println("notetypelist 删除成功~");
        }
    }

    @Override
    public List<FtbNoteType> findAll() {
        return noteTypeMapper.selectByExample(null);
    }
}
