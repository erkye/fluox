package cn.fluoxetine.fluoxetinebackstage.controller;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbUser;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;
import cn.fluoxetine.fluoxetinebackstage.pojo.Result;
import cn.fluoxetine.fluoxetinebackstage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 11699
 * @date 2020/2/12 - 10:41
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody FtbUser user,int page,int size){
        return userService.search(user, page, size);
    }


    @RequestMapping("/updateStatus")
    public Result updateStatus(Integer[] ids,Integer status){
        try {
            userService.updateStatus(ids, status);

            return new Result(true, "状态修改成功！");
        } catch (Exception e) {
            e.printStackTrace();

            return new Result(false, "状态修改失败!");
        }
    }

    @RequestMapping("/findOne")
    public FtbUser findOne(Integer id){
        return userService.findOne(id);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody FtbUser user){
        try {
            userService.update(user);

            return new Result(true, "修改成功!");
        } catch (Exception e) {
            e.printStackTrace();

            return new Result(false, "修改失败!");
        }
    }

    @RequestMapping("/usernum")
    public Map getUserNum(Integer userType){
        return userService.getUserNum(userType);
    }
}
