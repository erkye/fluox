package cn.fluoxetine.frontdesk.controller;

import cn.fluoxetine.frontdesk.pojo.FtbSubjectQuestion;
import cn.fluoxetine.frontdesk.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 11699
 * @date 2020/2/16 - 11:55
 */

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/findBySubjectId")
    public List<FtbSubjectQuestion> findBySubjectId(Integer subjectId){
        return subjectService.findBySetId(subjectId);
    }
}
