package cn.fluoxetine.fluoxetinebackstage.service.impl;

import cn.fluoxetine.fluoxetinebackstage.mapper.FtbNoteMapper;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbNote;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbNoteExample;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;
import cn.fluoxetine.fluoxetinebackstage.service.NoteService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 11699
 * @date 2020/2/10 - 15:30
 */
@Service
@Transactional
public class NoteServiceImpl implements NoteService {

    @Autowired
    private FtbNoteMapper noteMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public PageResult search(FtbNote note, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        FtbNoteExample example = new FtbNoteExample();

        if(note!=null){
            FtbNoteExample.Criteria criteria = example.createCriteria();
            if (note.getRecomm()!=null){
                criteria.andRecommEqualTo(note.getRecomm());
            }
            if (note.getTypeId()!=null){
                criteria.andTypeIdEqualTo(note.getTypeId());
            }
            if (note.getTitle()!=null&&note.getTitle().length()>0){
                criteria.andTitleLike("%"+note.getTitle()+"%");
            }

        }

        Page<FtbNote> page = (Page<FtbNote>) noteMapper.selectByExample(example);

        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void updateStatus(Integer[] ids, Integer status) {

        if (status!=null) {
            for (Integer id : ids) {
                FtbNote note = noteMapper.selectByPrimaryKey(id);
                note.setStatus(status);
                noteMapper.updateByPrimaryKey(note);

                //更新缓存
                if (note.getStatus() == 1 && note.getRecomm() == 1){
                    //更为可用 并且为推荐帖 添加
                    stringRedisTemplate.boundHashOps("recommnotelist").put(note.getId().toString(), JSON.toJSONString(note));
                    System.out.println("recommnotelist 缓存更新已添加");
                }
                if (note.getStatus() == 0 || note.getStatus() == 2){
                    //删除  或者  封贴  删除索引
                    stringRedisTemplate.boundHashOps("recommnotelist").delete(note.getId().toString());
                    System.out.println("recommnotelist 缓存更新已删除");

                }
            }
        }

    }

    @Override
    public void updateRecomm(Integer[] ids, Integer recomm) {
        if (recomm != null) {
            for (Integer id : ids) {
                FtbNote note = noteMapper.selectByPrimaryKey(id);
                note.setRecomm(recomm);
                noteMapper.updateByPrimaryKey(note);

                //更新索引
                if (note.getRecomm() == 1 && note.getStatus() == 1){
                    //为推荐并且状态为可用
                    stringRedisTemplate.boundHashOps("recommnotelist").put(note.getId().toString(), JSON.toJSONString(note));
                    System.out.println("recommnotelist 缓存更新已添加");
                }
                if (note.getRecomm() == 0){
                    //不推荐
                    stringRedisTemplate.boundHashOps("recommnotelist").delete(note.getId().toString());
                    System.out.println("recommnotelist 缓存更新已删除");

                }
            }

        }
    }

    @Override
    public FtbNote findOne(Integer id) {
        return noteMapper.selectByPrimaryKey(id);
    }
}
