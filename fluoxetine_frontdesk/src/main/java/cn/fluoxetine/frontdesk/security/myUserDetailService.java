package cn.fluoxetine.frontdesk.security;

import cn.fluoxetine.frontdesk.dao.FtbUserMapper;
import cn.fluoxetine.frontdesk.pojo.FtbUser;
import cn.fluoxetine.frontdesk.pojo.FtbUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 11699
 * @date 2020/2/19 - 15:46
 */
@Component
public class myUserDetailService implements UserDetailsService {

    @Autowired
    private FtbUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        //构建角色列表
        List<GrantedAuthority> grantAuths = new ArrayList();
        grantAuths.add(new SimpleGrantedAuthority("ROLE_USER"));


        FtbUserExample example = new FtbUserExample();
        FtbUserExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone);
        criteria.andStatusEqualTo(1);
        List<FtbUser> users = userMapper.selectByExample(example);
        if (users!=null && users.size()!=0){
            FtbUser user = users.get(0);
            return new User(phone, user.getPassword(),grantAuths);
        }
        return null;
    }
}
