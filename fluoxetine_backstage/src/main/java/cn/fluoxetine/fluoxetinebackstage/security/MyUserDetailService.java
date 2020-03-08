package cn.fluoxetine.fluoxetinebackstage.security;

import cn.fluoxetine.fluoxetinebackstage.mapper.FtbAdminMapper;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbAdmin;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbAdminExample;
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
 * @date 2020/2/13 - 18:44
 */
@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private FtbAdminMapper adminMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //构建角色列表
        List<GrantedAuthority> grantAuths=new ArrayList();
        grantAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));


        FtbAdminExample example = new FtbAdminExample();
        FtbAdminExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<FtbAdmin> admins = adminMapper.selectByExample(example);
        if (admins!=null && admins.size()!=0){
            FtbAdmin admin = admins.get(0);
            return new User(username, admin.getPassword(),grantAuths);
        }
        return null;
    }
}
