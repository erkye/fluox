package cn.fluoxetine.frontdesk.controller;

import cn.fluoxetine.frontdesk.pojo.FtbSubjectSet;
import cn.fluoxetine.frontdesk.service.SubjectSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 11699
 * @date 2020/2/15 - 20:23
 */

@RestController
@RequestMapping("/subjectset")
public class SubjectSetController {

    @Autowired
    private SubjectSetService subjectSetService;

    @RequestMapping("/findAll")
    public List<FtbSubjectSet> findAll(){
        return subjectSetService.findAll();
    }
}
