package cn.fluoxetine.fluoxetinebackstage.service;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbUser;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;

import java.util.Map;

/**
 * @author 11699
 * @date 2020/2/12 - 10:33
 */
public interface UserService {

    /**
     * 查找
     * @param user
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult search(FtbUser user,int pageNum,int pageSize);

    /**
     * 修改状态
     * @param ids
     * @param status
     */
    public void updateStatus(Integer[] ids,Integer status);

    /**
     * 查找
     * @param id
     * @return
     */
    public FtbUser findOne(Integer id);

    /**
     * 更新
     * @param user
     */
    public void update(FtbUser user);

    /**
     * 获取用户总数
     * @return
     */
    public Map<String,String> getUserNum(Integer userType);
}
