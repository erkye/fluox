package cn.fluoxetine.fluoxetinebackstage.controller;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbCompany;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;
import cn.fluoxetine.fluoxetinebackstage.pojo.Result;
import cn.fluoxetine.fluoxetinebackstage.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 11699
 * @date 2020/2/11 - 15:28
 */
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;


    @RequestMapping("/search")
    public PageResult search(@RequestBody FtbCompany company,int page,int size){
        return companyService.search(company, page, size);
    }

    @RequestMapping("/add")
    public Result add(@RequestBody FtbCompany company){
        try {
            companyService.add(company);

            return new Result(true, "添加成功！");
        } catch (Exception e) {
            e.printStackTrace();

            return new Result(false, "添加失败！");
        }
    }

    @RequestMapping("/findOne")
    public FtbCompany findOne(Integer id){
        return companyService.findOne(id);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody FtbCompany company){
        try {
            companyService.update(company);

            return new Result(true, "修改成功！");
        } catch (Exception e) {
            e.printStackTrace();

            return new Result(false, "修改失败！");
        }
    }

    @RequestMapping("/delete")
    public Result delete(Integer[] ids){
        try {
            companyService.delete(ids);

            return new Result(true, "删除成功！");
        } catch (Exception e) {
            e.printStackTrace();

            return new Result(false, "删除失败！");
        }
    }
}
