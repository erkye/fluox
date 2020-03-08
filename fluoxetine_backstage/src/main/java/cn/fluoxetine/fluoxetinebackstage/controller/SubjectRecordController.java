package cn.fluoxetine.fluoxetinebackstage.controller;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbSubjectRecord;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;
import cn.fluoxetine.fluoxetinebackstage.pojo.Result;
import cn.fluoxetine.fluoxetinebackstage.service.SubjectRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 11699
 * @date 2020/2/10 - 11:31
 */

@RestController
@RequestMapping("/subjectRecord")
public class SubjectRecordController {


    @Autowired
    private SubjectRecordService subjectRecordService;


    @RequestMapping("/search")
    public PageResult search(@RequestBody FtbSubjectRecord subjectRecord,int page,int size){
        return subjectRecordService.search(subjectRecord, page, size);
    }

    @RequestMapping("/findOne")
    public FtbSubjectRecord findOne(Integer id){
        return subjectRecordService.findOne(id);
    }

    @RequestMapping("/delete")
    public Result delete(Integer[] ids){
        try {
            subjectRecordService.delete(ids);

            return new Result(true, "删除成功！");
        } catch (Exception e) {
            e.printStackTrace();

            return new Result(false, "删除失败！");
        }
    }

    @RequestMapping("/recordnum")
    public Map getRecordNum(){
        return subjectRecordService.getRecordNum();
    }

}
