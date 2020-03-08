package cn.fluoxetine.fluoxetinebackstage.config;

import cn.fluoxetine.fluoxetinebackstage.security.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author 11699
 * @date 2020/2/13 - 17:11
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService myUserDetailService;

    /**
     * 设置用户在内存
     * @param auth
     * @throws Exception
     */
    @Autowired
    protected void config(AuthenticationManagerBuilder auth) throws Exception{
        /*auth.inMemoryAuthentication()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN");*/
        //设置自定义的登录验证服务
        auth.userDetailsService(myUserDetailService);
    }

    /**
     * 登录处理
     * @param http
     * @throws Exception
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        //开启登录配置
        http.authorizeRequests()
                //表示错误页面放行
                .antMatchers("/login_error.html").permitAll()
                //表示其请求都需要验证
                .anyRequest().authenticated()
                .and()
                //设置登录界面
                .formLogin().loginPage("/login.html")
                //设置登录处理接口
                .loginProcessingUrl("/login")
                //设置登录请求携带参数名称
                .usernameParameter("username")
                .passwordParameter("password")
                //设置登录出错的回调函数
                .failureHandler((request, response, e) ->{
                    response.sendRedirect("/login_error.html");
                })
                //与登录有关请求全部放行
                .permitAll()
                .and()
                //开启登录注销
                .logout().logoutUrl("/logout")
                //设置注销回调函数
                .logoutSuccessHandler((request, response, authentication) -> {
                    response.sendRedirect("/login.html");
                })
                //与退出有关的请求全部放行
                .permitAll()
                .and()
                .httpBasic()
                .and()
                //关闭csrf跨域
                .csrf().disable();
    }

    /**
     * 设置忽略拦截
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception{
        //忽略静态资源
        web.ignoring().antMatchers("/assets/**");
    }
}
