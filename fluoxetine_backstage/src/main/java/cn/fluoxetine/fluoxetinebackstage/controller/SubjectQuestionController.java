package cn.fluoxetine.fluoxetinebackstage.controller;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbSubjectQuestion;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;
import cn.fluoxetine.fluoxetinebackstage.pojo.Result;
import cn.fluoxetine.fluoxetinebackstage.service.SubjectQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 11699
 * @date 2020/2/9 - 17:05
 */
@RestController
@RequestMapping("/subjectQuestion")
public class SubjectQuestionController {

    @Autowired
    private SubjectQuestionService subjectQuestionService;


    @RequestMapping("/search")
    public PageResult search(@RequestBody FtbSubjectQuestion subjectQuestion,int page,int size){
        return subjectQuestionService.search(subjectQuestion,page,size);
    }


    @RequestMapping("/add")
    public Result add(@RequestBody FtbSubjectQuestion subjectQuestion){
        try {
            subjectQuestionService.add(subjectQuestion);

            return new Result(true,"添加题目成功！");
        } catch (Exception e) {
            e.printStackTrace();

            return new Result(false,"添加题目失败！");
        }
    }


    @RequestMapping("/delete")
    public Result delete(Integer[] ids){

        try {
            subjectQuestionService.delete(ids);

            return new Result(true,"删除成功！");
        } catch (Exception e) {
            e.printStackTrace();

            return new Result(false,"删除失败!");
        }
    }


    @RequestMapping("/findOne")
    public FtbSubjectQuestion findOne(Integer id){
        return subjectQuestionService.findOne(id);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody FtbSubjectQuestion subjectQuestion){
        try {
            subjectQuestionService.update(subjectQuestion);

            return new Result(true,"修改成功！");
        } catch (Exception e) {
            e.printStackTrace();

            return new Result(false,"修改失败！");
        }
    }
}
