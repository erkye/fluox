package cn.fluoxetine.frontdesk.controller;

import cn.fluoxetine.frontdesk.pojo.FtbUser;
import cn.fluoxetine.frontdesk.pojo.Result;
import cn.fluoxetine.frontdesk.service.UserService;
import cn.fluoxetine.frontdesk.util.PhoneFormatCheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 11699
 * @date 2020/2/19 - 17:08
 *
 *
 * 用户登录有关的配置
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/sendCode")
    public Result sendCode(String phone){
        if (PhoneFormatCheckUtils.isPhoneLegal(phone)){
            //手机号码格式正确
            if (!userService.isHavePhone(phone)){
                //该号码没有注册
                try {
                    userService.sendCode(phone);
                    return new Result(true, "已发送验证码!");
                } catch (Exception e) {
                    e.printStackTrace();
                    return new Result(false, "手机验证码发送异常，请稍后重试！");
                }

            }else{
                //该号码已经注册
                return new Result(false, "手机号码已经注册！");
            }

        }else{
            //手机号码格式不正确
            return new Result(false, "手机号码格式不规范！");
        }
    }


    @RequestMapping("/regUser")
    public Result regUser(@RequestBody FtbUser user, String code){
        if (user!=null&&user.getUsername()!=null){

            if (!userService.isHaveUsername(user.getUsername().replaceAll(" ", ""))){
                //验证验证码
                String smscode = (String) redisTemplate.boundHashOps("smscode").get(user.getPhone());
                if (smscode!=null&&smscode.equals(code)){

                    try {
                        //密码加密
                        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                        user.setPassword(encoder.encode(user.getPassword()));

                        userService.addUser(user);
                        //成功后删除验证码
                        redisTemplate.boundHashOps("smscode").delete(user.getPhone());
                        return new Result(true, "注册成功!");
                    } catch (Exception e) {
                        e.printStackTrace();
                        return new Result(false, "注册失败！请稍后再试！");
                    }

                }else {
                    return new Result(false, "注册失败！验证码错误！");
                }


            }else{
                return new Result(false, "该用户名称已经被使用，换一个试试吧!");
            }

        }else {
            return new Result(false, "注册失败！请稍后再试！");
        }
    }


    /**
     * 找回密码发送验证码
     * @param phone
     * @return
     */
    @RequestMapping("/fpwsendcode")
    public Result fpwSendCode(String phone){

        if (PhoneFormatCheckUtils.isPhoneLegal(phone)){
            FtbUser user = userService.findByPhone(phone);
            if (user != null){
                try {
                    userService.sendCode(phone);
                    return new Result(true, "验证码发送成功！");

                } catch (Exception e) {
                    e.printStackTrace();

                    return new Result(false, "验证码发送失败！请稍后再试!");
                }


            }else{
                return new Result(false, "手机号码未注册!");
            }


        }else{
           return new Result(false, "手机号码格式有误！");
        }

    }

    @RequestMapping("/findUserByPhone")
    public FtbUser findUserByPhone(String phone,String code){
        //返回的user
        FtbUser user1 = new FtbUser();

        String smscode = (String) redisTemplate.boundHashOps("smscode").get(phone);
        if (smscode!=null&&smscode.length()>0&&smscode.equals(code)){
            FtbUser user = userService.findByPhone(phone);

            if (user!=null){
                //清除其他信息
                user1.setId(user.getId());
                user1.setUsername(user.getUsername());
            }
        }

        return user1;
    }


    @RequestMapping("/updateuser")
    public Result updateUser(@RequestBody FtbUser user,String code){
        if (user!=null){
            if (user.getPhone()!=null){
                String smscode = (String) redisTemplate.boundHashOps("smscode").get(user.getPhone());
                if (smscode!=null&&smscode.length()>0&&smscode.equals(code)){
                    //加密
                    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                    String newPassword = encoder.encode(user.getPassword());

                    try {
                        userService.update(user,newPassword);

                        //删除redis中的中的key
                        redisTemplate.boundHashOps("smscode").delete(user.getPhone());

                        return new Result(true, "密码修改成功！");
                    } catch (Exception e) {
                        e.printStackTrace();
                        return new Result(false, "密码修改失败,请稍后重试!");
                    }
                }else {
                    return new Result(false, "验证码错误！");
                }
            }
        }
        return new Result(false, "密码修改失败！请稍后重试!");

    }

}
