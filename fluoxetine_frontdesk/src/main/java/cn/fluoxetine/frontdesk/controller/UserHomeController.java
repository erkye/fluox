package cn.fluoxetine.frontdesk.controller;

import cn.fluoxetine.frontdesk.pojo.FtbUser;
import cn.fluoxetine.frontdesk.pojo.PageResult;
import cn.fluoxetine.frontdesk.pojo.Result;
import cn.fluoxetine.frontdesk.service.NoteService;
import cn.fluoxetine.frontdesk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 11699
 * @date 2020/2/22 - 16:03
 * 用户中心有关请求
 */

@RestController
@RequestMapping("/userhome")
public class UserHomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private NoteService noteService;


    @RequestMapping("/getuser")
    public FtbUser getuser(){
        //获取当前登录手机号码
        String phone = SecurityContextHolder.getContext().getAuthentication().getName();
        //获取登录的用户
        FtbUser user = userService.findByPhone(phone);
        user.setPassword(null);
        return user;
    }

    @RequestMapping("/updateuser")
    public Result updateUser(@RequestBody FtbUser user){
        String phone = SecurityContextHolder.getContext().getAuthentication().getName();
        FtbUser ftbUser = userService.findByPhone(phone);

        if (ftbUser!=null&&ftbUser.getId().equals(user.getId())){
            try {
                //传入对象里面没有密码
                ftbUser.setSex(user.getSex());
                ftbUser.setIntrod(user.getIntrod());
                userService.updateUser(ftbUser);
                return new Result(true, "修改成功！");
            } catch (Exception e) {
                e.printStackTrace();
                return new Result(false, "修改失败！");
            }
        }

        return new Result(false, "修改失败！");

    }


    @RequestMapping("/findNote")
    public PageResult findNote(Integer page,Integer size){
        String phone = SecurityContextHolder.getContext().getAuthentication().getName();
        FtbUser user = userService.findByPhone(phone);
        return noteService.findOneByUsername(user.getUsername(),page,size);
    }

    @RequestMapping("/deleteNote")
    public Result deleteNote(Integer id){

        String phone = SecurityContextHolder.getContext().getAuthentication().getName();
        FtbUser user = userService.findByPhone(phone);
        try {
            noteService.deleteNoteById(id, user.getUsername());
            return new Result(true, "删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败!");
        }


    }



}
