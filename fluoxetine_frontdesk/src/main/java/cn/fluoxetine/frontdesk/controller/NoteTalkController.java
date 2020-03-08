package cn.fluoxetine.frontdesk.controller;

import cn.fluoxetine.frontdesk.pojo.*;
import cn.fluoxetine.frontdesk.service.NoteTalkService;
import cn.fluoxetine.frontdesk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 11699
 * @date 2020/2/19 - 14:32
 */

@RestController
@RequestMapping("/notetalk")
public class NoteTalkController {

    @Autowired
    private NoteTalkService noteTalkService;

    @Autowired
    private UserService userService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody FtbNoteTalk noteTalk,int page,int size){
        return noteTalkService.search(noteTalk, page, size);
    }

    @RequestMapping("/add")
    public Result add(String content,Integer nodeId){
        FtbNoteTalk noteTalk = new FtbNoteTalk();
        noteTalk.setContent(content);
        noteTalk.setNodeId(nodeId);

        String phone = SecurityContextHolder.getContext().getAuthentication().getName();
        if (phone != null){
            FtbUser user = userService.findByPhone(phone);
            if (user!= null){
                noteTalk.setUsername(user.getUsername());
                try {
                    noteTalkService.addNoteTalk(noteTalk);
                    return new Result(true, "评论成功！");
                } catch (Exception e) {
                    e.printStackTrace();
                    return new Result(false, "评论失败！");
                }
            }
        }

        return new Result(false, "评论失败！");
    }
}
