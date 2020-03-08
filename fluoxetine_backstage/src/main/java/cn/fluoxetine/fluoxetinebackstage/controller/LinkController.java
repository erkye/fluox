package cn.fluoxetine.fluoxetinebackstage.controller;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbLink;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;
import cn.fluoxetine.fluoxetinebackstage.pojo.Result;
import cn.fluoxetine.fluoxetinebackstage.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 11699
 * @date 2020/2/11 - 17:17
 */
@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody FtbLink link,int page,int size){
        return linkService.search(link, page, size);
    }


    @RequestMapping("/add")
    public Result add(@RequestBody FtbLink link){
        try {
            linkService.add(link);

            return new Result(true, "增加成功！");
        } catch (Exception e) {
            e.printStackTrace();

            return new Result(false, "增加失败！");
        }
    }


    @RequestMapping("/delete")
    public Result delete(Integer[] ids){
        try {
            linkService.delete(ids);

            return new Result(true, "删除成功！");
        } catch (Exception e) {
            e.printStackTrace();

            return new Result(false, "删除失败！");
        }
    }

    @RequestMapping("/findOne")
    public FtbLink findOne(Integer id){
        return linkService.findOne(id);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody FtbLink link){
        try {
            linkService.update(link);

            return new Result(true, "修改成功！");
        } catch (Exception e) {
            e.printStackTrace();

            return new Result(false, "修改失败！");
        }
    }
}
