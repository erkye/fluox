package cn.fluoxetine.frontdesk.config;

import cn.fluoxetine.frontdesk.security.myUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author 11699
 * @date 2020/2/19 - 15:44
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private myUserDetailService myUserDetailService;



    @Bean(value = "myPasswordEncoder")
    public PasswordEncoder delegatingPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 设置用户在内存
     * @param auth
     * @throws Exception
     */
    @Autowired
    private PasswordEncoder  myPasswordEncoder;

    @Autowired
    protected void config(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(myUserDetailService).passwordEncoder(myPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        //开启登录配置
        http.authorizeRequests()
                //设置需要验证的请求
                .antMatchers("/home.html","/home-infor.html","/home-talk.html","/textedit.html","/userhome/**","/note/add","/note/update","/notetalk/add")
                .authenticated()
                //其他的请求放行
                .anyRequest().permitAll()
                .and()
                //登录有关配置
                .formLogin().loginPage("/login.html")
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                //登录失败处理
                .failureHandler((request, response, e) -> {
                    response.sendRedirect("/login_error.html");
                })
                //有关请求放行
                .permitAll()
                .and()
                //配置退出
                .logout().logoutUrl("/logout")
                .logoutSuccessHandler((request, response, authentication) -> {
                    response.sendRedirect("/index.html");
                })
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                //对iframe的请求放行
                .headers().frameOptions().disable();



    }

    /**
     * 设置忽略拦截
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception{
        //忽略静态资源
        web.ignoring().antMatchers("/css/**","/fonts/**","/images/**","/js/**","/plugins/**");
    }





}
