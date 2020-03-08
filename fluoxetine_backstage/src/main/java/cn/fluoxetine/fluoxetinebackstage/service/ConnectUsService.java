package cn.fluoxetine.fluoxetinebackstage.service;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbConnectUs;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;

/**
 * @author 11699
 * @date 2020/2/12 - 13:20
 */
public interface ConnectUsService {

    /**
     * 查找
     * @param connectUs
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult search(FtbConnectUs connectUs,int pageNum,int pageSize);

    /**
     * 更改状态
     * @param ids
     * @param status
     */
    public void updateStatus(Integer[] ids,Integer status);

    /**
     * 查找
     * @param id
     * @return
     */
    public FtbConnectUs findOne(Integer id);
}
