package cn.fluoxetine.frontdesk.service.impl;

import cn.fluoxetine.frontdesk.dao.FtbConnectUsMapper;
import cn.fluoxetine.frontdesk.pojo.FtbConnectUs;
import cn.fluoxetine.frontdesk.service.ContentUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author 11699
 * @date 20/2/24 - 11:58
 */

@Service
@Transactional
public class ContentUsServiceImpl implements ContentUsService {

    @Autowired
    private FtbConnectUsMapper connectUsMapper;

    @Override
    public void add(FtbConnectUs connectUs) {
        connectUs.setTime(new Date());
        connectUs.setStatus(1);
        connectUsMapper.insert(connectUs);
    }
}
