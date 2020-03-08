package cn.fluoxetine.fluoxetinebackstage.controller;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbNoteType;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;
import cn.fluoxetine.fluoxetinebackstage.pojo.Result;
import cn.fluoxetine.fluoxetinebackstage.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 11699
 * @date 2020/2/10 - 13:17
 */
@RestController
@RequestMapping("/nodeType")
public class NoteTypeController {

    @Autowired
    private NoteTypeService noteTypeService;


    @RequestMapping("/search")
    public PageResult search(@RequestBody FtbNoteType noteType,int page,int size){
        return noteTypeService.search(noteType, page, size);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody FtbNoteType noteType){
        try {
            noteTypeService.add(noteType);

            return new Result(true, "增加成功！");
        } catch (Exception e) {
            e.printStackTrace();

            return new Result(false, "增加失败！");
        }
    }


    @RequestMapping("/findOne")
    public FtbNoteType findOne(Integer id){
        return noteTypeService.findOne(id);
    }


    @RequestMapping("/update")
    public Result update(@RequestBody FtbNoteType noteType){
        try {
            noteTypeService.update(noteType);

            return new Result(true, "修改成功！");
        } catch (Exception e) {
            e.printStackTrace();

            return new Result(false, "修改失败！");
        }
    }

    @RequestMapping("/delete")
    public Result delete(Integer[] ids){
        try {
            noteTypeService.delete(ids);

            return new Result(true, "删除成功！");
        } catch (Exception e) {
            e.printStackTrace();

            return new Result(false, "删除失败！");
        }
    }


    @RequestMapping("/findAll")
    public List<FtbNoteType> findAll(){
        return noteTypeService.findAll();
    }
}
