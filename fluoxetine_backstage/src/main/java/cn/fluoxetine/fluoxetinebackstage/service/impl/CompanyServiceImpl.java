package cn.fluoxetine.fluoxetinebackstage.service.impl;

import cn.fluoxetine.fluoxetinebackstage.mapper.FtbCompanyMapper;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbCompany;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbCompanyExample;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;
import cn.fluoxetine.fluoxetinebackstage.service.CompanyService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 11699
 * @date 2020/2/11 - 15:22
 */
@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private FtbCompanyMapper companyMapper;

  /*  @Autowired
    private RedisTemplate redisTemplate;*/

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public PageResult search(FtbCompany company, int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        FtbCompanyExample example = new FtbCompanyExample();
        if (company!=null){
            FtbCompanyExample.Criteria criteria = example.createCriteria();
            if (company.getCompanyname()!=null&&company.getCompanyname().length()>0){
                criteria.andCompanynameLike("%"+company.getCompanyname()+"%");
            }
        }

        Page<FtbCompany> page = (Page<FtbCompany>) companyMapper.selectByExample(example);

        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public FtbCompany findOne(Integer id) {
        return companyMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(FtbCompany company) {
        company.setStatus(1);
        companyMapper.insert(company);
        FtbCompany ftbCompany = companyMapper.selectByPrimaryKey(company.getId());
        System.out.println(ftbCompany.getId());

        //写入缓存
        //redisTemplate.boundListOps("companylist").rightPush(ftbCompany);
        //key：id(String) value(json)
        stringRedisTemplate.boundHashOps("companylist").put(ftbCompany.getId().toString(), JSON.toJSONString(ftbCompany));
        System.out.println("companylist 写入缓存~~~");
    }

    @Override
    public void update(FtbCompany company) {
        companyMapper.updateByPrimaryKey(company);

        if (company.getStatus() ==1){
            //更新缓存
            stringRedisTemplate.boundHashOps("companylist").put(company.getId().toString(), JSON.toJSONString(company));
        }
        if (company.getStatus() == 0){
            stringRedisTemplate.boundHashOps("companylist").delete(company.getId().toString());
        }
        System.out.println("companylist 缓存已经更新");
    }

    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            FtbCompany company = companyMapper.selectByPrimaryKey(id);
            company.setStatus(0);
            companyMapper.updateByPrimaryKey(company);

            //更改缓存
            stringRedisTemplate.boundHashOps("companylist").delete(id.toString());
            System.out.println("companylist 缓存已经更新~~");
        }
    }
}
