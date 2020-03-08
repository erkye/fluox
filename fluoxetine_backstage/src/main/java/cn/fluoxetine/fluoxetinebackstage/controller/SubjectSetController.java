package cn.fluoxetine.fluoxetinebackstage.controller;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbSubjectSet;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;
import cn.fluoxetine.fluoxetinebackstage.pojo.Result;
import cn.fluoxetine.fluoxetinebackstage.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 11699
 * @date 2020/2/9 - 10:23
 */

@RestController
@RequestMapping("/subjectSet")
public class SubjectSetController {


    @Autowired
    private SubjectService subjectService;

    /**
     * 查找所有的题目集
     * @return
     */
    @RequestMapping("/findAll")
    public List<FtbSubjectSet> findAll(){
        return subjectService.findAll();
    }


    /**
     * 模糊查询+分页+查询
     * @param subjectSet
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody FtbSubjectSet subjectSet,int page,int size){
        return subjectService.search(subjectSet,page,size);
    }

    /**
     * 新增
     * @param subjectSet
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody FtbSubjectSet subjectSet){
        try {
            subjectService.addOne(subjectSet);

            return new Result(true,"添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加失败!");
        }
    }

    /**
     * 查找
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public FtbSubjectSet findOne(Integer id){
        return subjectService.findOne(id);
    }

    /**
     * 修改
     * @param subjectSet
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody FtbSubjectSet subjectSet){
        try {
            subjectService.update(subjectSet);

            return new Result(true,"修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败！");
        }
    }


    @RequestMapping("/delete")
    public Result delete(Integer[] ids){
        try {
            subjectService.delete(ids);

            return new Result(true,"删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败！");
        }
    }
}
