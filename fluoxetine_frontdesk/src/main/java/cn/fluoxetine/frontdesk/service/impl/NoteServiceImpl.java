package cn.fluoxetine.frontdesk.service.impl;

import cn.fluoxetine.frontdesk.dao.FtbNoteMapper;
import cn.fluoxetine.frontdesk.pojo.FtbNote;
import cn.fluoxetine.frontdesk.pojo.FtbNoteExample;
import cn.fluoxetine.frontdesk.pojo.PageResult;
import cn.fluoxetine.frontdesk.service.NoteService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author 11699
 * @date 2020/2/15 - 16:13
 */
@Service
@Transactional
public class NoteServiceImpl implements NoteService {

    @Autowired
    private FtbNoteMapper noteMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public List<FtbNote> findRecomm() {
        List<FtbNote> list = new ArrayList<>();
        Set<Object> keys = redisTemplate.boundHashOps("recommnotelist").keys();
        if (keys!=null&&keys.size()>0){
            System.out.println("有缓存");
            //有缓存
            for (Object key : keys) {
                String s = (String) redisTemplate.boundHashOps("recommnotelist").get(key);
                FtbNote note = JSON.parseObject(s, FtbNote.class);
                list.add(note);
            }

        }else {
            System.out.println("没有缓存");
            //没有缓存
            FtbNoteExample example = new FtbNoteExample();
            FtbNoteExample.Criteria criteria = example.createCriteria();
            criteria.andStatusEqualTo(1);
            criteria.andRecommEqualTo(1);
            list = noteMapper.selectByExample(example);
            //写入缓存
            if (list!=null&&list.size()>0){
                for (FtbNote note : list) {
                    redisTemplate.boundHashOps("recommnotelist").put(note.getId().toString(), JSON.toJSONString(note));
                }
            }
        }

        return list;
    }

    @Override
    public void add(FtbNote note) {

        note.setStatus(1);
        note.setRecomm(0);
        note.setTime(new Date());

        noteMapper.insert(note);

    }

    @Override
    public PageResult search(FtbNote note, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        FtbNoteExample example = new FtbNoteExample();
        FtbNoteExample.Criteria criteria = example.createCriteria();
        if (note != null){
            if (note.getTypeId()!=null){
                criteria.andTypeIdEqualTo(note.getTypeId());
            }
        }
        criteria.andStatusEqualTo(1);
        Page<FtbNote> page = (Page<FtbNote>) noteMapper.selectByExample(example);

        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public FtbNote findOneById(Integer id) {
        FtbNoteExample example = new FtbNoteExample();
        FtbNoteExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        criteria.andStatusEqualTo(1);
        List<FtbNote> ftbNotes = noteMapper.selectByExampleWithBLOBs(example);
        if (ftbNotes==null||ftbNotes.size()==0){
            return null;
        }
        return ftbNotes.get(0);
    }

    @Override
    public PageResult findOneByUsername(String username,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        FtbNoteExample example = new FtbNoteExample();
        FtbNoteExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andStatusEqualTo(1);
        Page<FtbNote> page = (Page<FtbNote>) noteMapper.selectByExample(example);

        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void deleteNoteById(Integer id,String username) {

        FtbNote note = noteMapper.selectByPrimaryKey(id);
        if (note !=null){
            if (note.getUsername().equals(username)){
                note.setStatus(0);
                noteMapper.updateByPrimaryKey(note);
            }
        }
    }

    @Override
    public void updateNote(FtbNote note) {

        noteMapper.updateByPrimaryKeyWithBLOBs(note);


        if (note.getRecomm()==1){
            //修改的是推荐帖子，清除推荐的缓存
            redisTemplate.delete("recommnotelist");
        }
    }


}
