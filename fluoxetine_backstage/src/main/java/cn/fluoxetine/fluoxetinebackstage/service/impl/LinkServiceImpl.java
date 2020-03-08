package cn.fluoxetine.fluoxetinebackstage.service.impl;

import cn.fluoxetine.fluoxetinebackstage.mapper.FtbLinkMapper;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbLink;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbLinkExample;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;
import cn.fluoxetine.fluoxetinebackstage.service.LinkService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 11699
 * @date 2020/2/11 - 17:12
 */
@Service
@Transactional
public class LinkServiceImpl implements LinkService {

    @Autowired
    private FtbLinkMapper linkMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public PageResult search(FtbLink link, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        FtbLinkExample example = new FtbLinkExample();
        if (link!= null){
            FtbLinkExample.Criteria criteria = example.createCriteria();
            if (link.getLinkname()!=null&&link.getLinkname().length()>0){
                criteria.andLinknameLike("%"+link.getLinkname()+"%");
            }
        }
        Page<FtbLink> page = (Page<FtbLink>) linkMapper.selectByExample(example);

        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public void add(FtbLink link) {
        link.setStatus(1);
        linkMapper.insert(link);

        //写入缓存
        FtbLink ftbLink = linkMapper.selectByPrimaryKey(link.getId());
        stringRedisTemplate.boundHashOps("linklist").put(ftbLink.getId().toString(), JSON.toJSONString(ftbLink));
        System.out.println("linklist 缓存写入成功");
    }

    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            FtbLink link = linkMapper.selectByPrimaryKey(id);
            link.setStatus(0);
            linkMapper.updateByPrimaryKey(link);

            //删除缓存
            stringRedisTemplate.boundHashOps("linklist").delete(link.getId().toString());
            System.out.println("linklist 缓存 删除成功~~");
        }
    }

    @Override
    public FtbLink findOne(Integer id) {
        return linkMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(FtbLink link) {
        linkMapper.updateByPrimaryKey(link);

        if (link.getStatus() == 0){
            stringRedisTemplate.boundHashOps("linklist").delete(link.getId().toString());
        }
        if (link.getStatus() == 1){
            stringRedisTemplate.boundHashOps("linklist").put(link.getId().toString(), JSON.toJSONString(link));
        }
        System.out.println("linklist 缓存更新成功");
    }
}
