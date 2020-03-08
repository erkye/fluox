package cn.fluoxetine.frontdesk.controller;

import cn.fluoxetine.frontdesk.pojo.FtbSubjectRecord;
import cn.fluoxetine.frontdesk.pojo.Result;
import cn.fluoxetine.frontdesk.service.SubjectRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 11699
 * @date 2020/2/16 - 13:22
 */

@RestController
@RequestMapping("/subjectrecord")
public class SubjectRecordController {

    @Autowired
    private SubjectRecordService subjectRecordService;

    @RequestMapping("/add")
    public Result add(@RequestBody FtbSubjectRecord record){
        try {
            subjectRecordService.add(record);

            return new Result(true, "OK");
        } catch (Exception e) {
            e.printStackTrace();

            return new Result(false, "Error");
        }
    }

}
