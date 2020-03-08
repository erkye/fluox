package cn.fluoxetine.frontdesk.service.impl;

import cn.fluoxetine.frontdesk.dao.FtbUserMapper;
import cn.fluoxetine.frontdesk.pojo.FtbUser;
import cn.fluoxetine.frontdesk.pojo.FtbUserExample;
import cn.fluoxetine.frontdesk.service.UserService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Queue;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 11699
 * @date 2020/2/19 - 16:46
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private FtbUserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;


    @Override
    public void addUser(FtbUser user) {
        user.setSex(1);
        user.setUserType(0);
        user.setUserRank(0);
        user.setRegdate(new Date());
        user.setStatus(1);


        userMapper.insert(user);

    }

    @Override
    public void sendCode(String phone) {
        //生成验证码
        String smscode = (long) (Math.random() * 1000000) + "";
        System.out.println("用户注册验证码为："+smscode);

        //保存到redis中
        redisTemplate.boundHashOps("smscode").put(phone, smscode);

        Map<String,String> map = new HashMap<>();
        map.put("mobile", phone);
        map.put("sign_name", "Fluoxetine");
        map.put("template_code", "SMS_183195219");
        Map param = new HashMap();
        param.put("code", smscode);
        map.put("param", JSON.toJSONString(param));

        //发送到activemq
        jmsMessagingTemplate.convertAndSend(queue, map);
        System.out.println("验证码发送成功！");

    }

    @Override
    public boolean isHavePhone(String phone) {
        FtbUserExample example = new FtbUserExample();
        FtbUserExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone.replaceAll(" ", ""));
        List<FtbUser> users = userMapper.selectByExample(example);
        if (users!=null&&users.size()>0){
            return true;
        }

        return false;
    }

    @Override
    public boolean isHaveUsername(String username) {
        FtbUserExample example = new FtbUserExample();
        FtbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username.replaceAll(" ", ""));
        List<FtbUser> users = userMapper.selectByExample(example);
        if (users!=null&&users.size()>0){
            return true;
        }
        return false;
    }

    @Override
    public FtbUser findByPhone(String phone) {
        FtbUserExample example = new FtbUserExample();
        FtbUserExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone);
        List<FtbUser> users = userMapper.selectByExample(example);
        if (users!=null&&users.size()>0){
            return users.get(0);
        }

        return null;
    }

    @Override
    public void update(FtbUser user, String newPassword) {
        FtbUser ftbUser = findByPhone(user.getPhone());
        if (ftbUser!=null){
            ftbUser.setPassword(newPassword);
            userMapper.updateByPrimaryKey(ftbUser);
        }
    }

    @Override
    public void updateUser(FtbUser user) {
        userMapper.updateByPrimaryKey(user);
    }
}
