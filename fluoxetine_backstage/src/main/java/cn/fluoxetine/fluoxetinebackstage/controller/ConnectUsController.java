package cn.fluoxetine.fluoxetinebackstage.controller;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbConnectUs;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;
import cn.fluoxetine.fluoxetinebackstage.pojo.Result;
import cn.fluoxetine.fluoxetinebackstage.service.ConnectUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 11699
 * @date 2020/2/12 - 13:26
 */
@RestController
@RequestMapping("/connectUs")
public class ConnectUsController {

    @Autowired
    private ConnectUsService connectUsService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody  FtbConnectUs connectUs, int page, int size){
        return connectUsService.search(connectUs, page, size);
    }

    @RequestMapping("/updateStatus")
    public Result updateStatus(Integer[] ids,Integer status){
        try {
            connectUsService.updateStatus(ids, status);

            return new Result(true, "修改状态成功！");
        } catch (Exception e) {
            e.printStackTrace();

            return new Result(false, "修改状态失败！");
        }
    }

    @RequestMapping("/findOne")
    public FtbConnectUs findOne(Integer id){
        return connectUsService.findOne(id);
    }
}
