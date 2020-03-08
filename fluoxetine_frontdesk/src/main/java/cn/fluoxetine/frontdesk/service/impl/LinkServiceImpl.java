package cn.fluoxetine.frontdesk.service.impl;

import cn.fluoxetine.frontdesk.dao.FtbLinkMapper;
import cn.fluoxetine.frontdesk.pojo.FtbLink;
import cn.fluoxetine.frontdesk.pojo.FtbLinkExample;
import cn.fluoxetine.frontdesk.service.LinkService;
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
 * @date 2020/2/15 - 15:42
 */
@Service
@Transactional
public class LinkServiceImpl implements LinkService {

    @Autowired
    private FtbLinkMapper linkMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Override
    public List<FtbLink> findAll() {
        List<FtbLink> list = new ArrayList<>();
        Set<Object> keys = redisTemplate.boundHashOps("linklist").keys();
        if (keys!=null&&keys.size()>0){
            //有缓存
            for (Object key : keys) {

                String s = (String) redisTemplate.boundHashOps("linklist").get(key);
                FtbLink link = JSON.parseObject(s, FtbLink.class);
                list.add(link);
            }

        }else {
            //没有缓存
            FtbLinkExample example = new FtbLinkExample();
            FtbLinkExample.Criteria criteria = example.createCriteria();
            criteria.andStatusEqualTo(1);
            list = linkMapper.selectByExample(example);
            //写入缓存
            if (list!=null&&list.size()>0){

                for (FtbLink link : list) {
                    redisTemplate.boundHashOps("linklist").put(link.getId().toString(), JSON.toJSONString(link));
                }
            }
        }


        return list;
    }
}
