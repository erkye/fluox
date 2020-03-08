package cn.fluoxetine.frontdesk.service;

import cn.fluoxetine.frontdesk.pojo.FtbConnectUs;

/**
 * @author 11699
 * @date 20/2/24 - 11:55
 */
public interface ContentUsService {

    /**
     * 用户点击联系我们
     * @param connectUs
     */
    public void add(FtbConnectUs connectUs);
}
