package cn.fluoxetine.frontdesk.service.impl;

import cn.fluoxetine.frontdesk.dao.FtbNoteTypeMapper;
import cn.fluoxetine.frontdesk.pojo.FtbNoteType;
import cn.fluoxetine.frontdesk.pojo.FtbNoteTypeExample;
import cn.fluoxetine.frontdesk.service.NoteTypeService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author 11699
 * @date 2020/2/16 - 15:23
 */
@Service
@Transactional
public class NoteTypeServiceImpl implements NoteTypeService {

    @Autowired
    private FtbNoteTypeMapper noteTypeMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public List<FtbNoteType> findAll() {
        List<FtbNoteType> list = new ArrayList<>();

        Set<Object> keys = redisTemplate.boundHashOps("notetypelist").keys();
        if (keys!=null&&keys.size()>0){
            //有缓存
            for (Object key : keys) {

                String s = (String) redisTemplate.boundHashOps("notetypelist").get(key);
                FtbNoteType noteType = JSON.parseObject(s, FtbNoteType.class);
                list.add(noteType);
            }
        }else {
            //没有缓存
            FtbNoteTypeExample example = new FtbNoteTypeExample();
            FtbNoteTypeExample.Criteria criteria = example.createCriteria();
            //用户可见
            criteria.andUserVisualEqualTo(1);
            list = noteTypeMapper.selectByExample(example);

            if (list!=null&&list.size()>0){
                for (FtbNoteType noteType : list) {
                    redisTemplate.boundHashOps("notetypelist").put(noteType.getId().toString(), JSON.toJSONString(noteType));
                }
            }
        }


        return list;
    }
}
