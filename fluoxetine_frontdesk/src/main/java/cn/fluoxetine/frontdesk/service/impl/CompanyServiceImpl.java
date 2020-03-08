package cn.fluoxetine.frontdesk.service.impl;

import cn.fluoxetine.frontdesk.dao.FtbCompanyMapper;
import cn.fluoxetine.frontdesk.pojo.FtbCompany;
import cn.fluoxetine.frontdesk.pojo.FtbCompanyExample;
import cn.fluoxetine.frontdesk.service.CompanyService;
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
 * @date 2020/2/15 - 15:01
 */
@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private FtbCompanyMapper companyMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public List<FtbCompany> findAll() {

        List<FtbCompany> list = new ArrayList<>();

        Set<Object> keys = redisTemplate.boundHashOps("companylist").keys();
        if (keys!=null&&keys.size()>0){
            //当redis中有的时候
            for (Object key : keys) {
                String s = (String) redisTemplate.boundHashOps("companylist").get(key);
                FtbCompany ftbCompany = JSON.parseObject(s, FtbCompany.class);
                list.add(ftbCompany);
            }


        }else {
            //redis中没有的时候
            FtbCompanyExample example = new FtbCompanyExample();
            FtbCompanyExample.Criteria criteria = example.createCriteria();
            //状态为启用
            criteria.andStatusEqualTo(1);
            list = companyMapper.selectByExample(example);
            //写入redis
            if (list!=null&&list.size()>0){
                for (FtbCompany company : list) {

                    redisTemplate.boundHashOps("companylist").put(company.getId().toString(), JSON.toJSONString(company));

                }

            }
        }
        return list;

    }
}
