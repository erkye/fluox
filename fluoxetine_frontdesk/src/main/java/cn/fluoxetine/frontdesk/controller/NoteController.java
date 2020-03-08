package cn.fluoxetine.frontdesk.controller;

import cn.fluoxetine.frontdesk.pojo.FtbNote;
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
 * @date 2020/2/16 - 16:03
 */
@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public Result add(@RequestBody FtbNote note){
        try {
            String phone = SecurityContextHolder.getContext().getAuthentication().getName();
            FtbUser user = userService.findByPhone(phone);
            note.setUsername(user.getUsername());

            noteService.add(note);

            return new Result(true, "发布成功！");
        } catch (Exception e) {
            e.printStackTrace();

            return new Result(false, "发布失败！！");
        }
    }

    @RequestMapping("/search")
    public PageResult search(@RequestBody FtbNote note,int page,int size){
        return noteService.search(note, page, size);
    }

    @RequestMapping("/findOne")
    public FtbNote findById(Integer id){
        return noteService.findOneById(id);
    }


    @RequestMapping("/update")
    public Result update(@RequestBody FtbNote note){
        try {
            noteService.updateNote(note);
            return new Result(true, "修改成功！");

        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败！");
        }
    }
}
