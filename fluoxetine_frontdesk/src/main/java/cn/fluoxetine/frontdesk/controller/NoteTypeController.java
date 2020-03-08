package cn.fluoxetine.frontdesk.controller;

import cn.fluoxetine.frontdesk.pojo.FtbNoteType;
import cn.fluoxetine.frontdesk.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 11699
 * @date 2020/2/16 - 15:37
 */

@RestController
@RequestMapping("/notetype")
public class NoteTypeController {

    @Autowired
    private NoteTypeService noteTypeService;

    @RequestMapping("/findAll")
    public List<FtbNoteType> findAll(){
        return noteTypeService.findAll();
    }
}
