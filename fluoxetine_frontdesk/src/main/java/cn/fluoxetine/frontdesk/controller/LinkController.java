package cn.fluoxetine.frontdesk.controller;

import cn.fluoxetine.frontdesk.pojo.FtbLink;
import cn.fluoxetine.frontdesk.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 11699
 * @date 2020/2/15 - 15:51
 */
@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @RequestMapping("/findAll")
    public List<FtbLink> findAll(){
        return linkService.findAll();
    }
}
