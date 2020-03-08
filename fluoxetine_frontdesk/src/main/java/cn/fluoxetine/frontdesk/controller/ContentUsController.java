package cn.fluoxetine.frontdesk.controller;

import cn.fluoxetine.frontdesk.pojo.FtbConnectUs;
import cn.fluoxetine.frontdesk.pojo.Result;
import cn.fluoxetine.frontdesk.service.ContentUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 11699
 * @date 20/2/24 - 12:02
 */
@RestController
@RequestMapping("/content")
public class ContentUsController {

    @Autowired
    private ContentUsService contentUsService;

    @RequestMapping("/add")
    public Result add(@RequestBody FtbConnectUs connectUs){
        try {
            contentUsService.add(connectUs);
            return new Result(true, "发送成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发送失败！");
        }
    }
}
