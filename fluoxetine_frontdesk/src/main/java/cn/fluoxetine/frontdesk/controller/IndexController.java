package cn.fluoxetine.frontdesk.controller;

import cn.fluoxetine.frontdesk.pojo.FtbNote;
import cn.fluoxetine.frontdesk.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 11699
 * @date 2020/2/15 - 16:24
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private NoteService noteService;

    @RequestMapping("/findRecommList")
    public List<FtbNote> findRecommList(){
        return noteService.findRecomm();
    }


}
