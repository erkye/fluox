package cn.fluoxetine.frontdesk.controller;

import cn.fluoxetine.frontdesk.pojo.FtbCompany;
import cn.fluoxetine.frontdesk.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 11699
 * @date 2020/2/15 - 15:24
 */

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping("/findAll")
    public List<FtbCompany> findAll(){
        return companyService.findAll();
    }
}
