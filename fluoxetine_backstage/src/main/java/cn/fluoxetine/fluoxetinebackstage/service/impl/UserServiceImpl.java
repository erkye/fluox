package cn.fluoxetine.fluoxetinebackstage.service.impl;

import cn.fluoxetine.fluoxetinebackstage.mapper.FtbUserMapper;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbUser;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbUserExample;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;
import cn.fluoxetine.fluoxetinebackstage.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 11699
 * @date 2020/2/12 - 10:34
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private FtbUserMapper userMapper;


    @Override
    public PageResult search(FtbUser user, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        FtbUserExample example = new FtbUserExample();
        if (user!=null){
            FtbUserExample.Criteria criteria = example.createCriteria();
            if (user.getUserType()!=null){
                criteria.andUserTypeEqualTo(user.getUserType());
            }
            if (user.getUsername()!=null && user.getUsername().length()>0){
                criteria.andUsernameLike("%"+user.getUsername()+"%");
            }
        }

        Page<FtbUser> page = (Page<FtbUser>) userMapper.selectByExample(example);

        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void updateStatus(Integer[] ids, Integer status) {
        for (Integer id : ids) {
            FtbUser user = userMapper.selectByPrimaryKey(id);
            user.setStatus(status);
            userMapper.updateByPrimaryKey(user);
        }
    }

    @Override
    public FtbUser findOne(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(FtbUser user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public Map<String, String> getUserNum(Integer userType) {
        Map<String,String> map = new HashMap<>();

        FtbUserExample example = new FtbUserExample();
        FtbUserExample.Criteria criteria = example.createCriteria();
        if (userType!=null){
            criteria.andUserTypeEqualTo(userType);
        }

        int i = userMapper.countByExample(example);
        map.put("usernum",Integer.toString(i));
        return map;
    }
}
