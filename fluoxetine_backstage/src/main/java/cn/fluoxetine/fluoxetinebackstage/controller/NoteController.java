package cn.fluoxetine.fluoxetinebackstage.controller;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbNote;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbNoteTalk;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;
import cn.fluoxetine.fluoxetinebackstage.pojo.Result;
import cn.fluoxetine.fluoxetinebackstage.service.NoteService;
import cn.fluoxetine.fluoxetinebackstage.service.NoteTalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 11699
 * @date 2020/2/10 - 15:39
 */
@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteTalkService noteTalkService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody FtbNote note,int page,int size){
        return noteService.search(note, page, size);
    }

    @RequestMapping("/updateStatus")
    public Result updateStatus(Integer[] ids,Integer status){
        try {
            noteService.updateStatus(ids, status);

            return new Result(true, "状态修改成功！");
        } catch (Exception e) {
            e.printStackTrace();

            return new Result(false, "状态修改失败！");
        }
    }


    @RequestMapping("/updateRecomm")
    public Result updateRecomm(Integer[] ids,Integer status){
        try {
            noteService.updateRecomm(ids, status);

            return new Result(true, "修改成功！");
        } catch (Exception e) {
            e.printStackTrace();

            return new Result(false, "修改失败！");
        }
    }


    @RequestMapping("/findOne")
    public FtbNote findOne(Integer id){
        return noteService.findOne(id);
    }

    @RequestMapping("/findTalk")
    public List<FtbNoteTalk> findTalk(Integer noteId){
        return noteTalkService.findByNoteId(noteId);
    }

    @RequestMapping("/deleteTalk")
    public Result delete(Integer id){
        try {
            noteTalkService.delete(id);

            return new Result(true, "评论删除成功！");
        } catch (Exception e) {
            e.printStackTrace();

            return new Result(false, "评论删除失败！");
        }
    }
}
