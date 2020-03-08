package cn.fluoxetine.frontdesk.service;

import cn.fluoxetine.frontdesk.pojo.FtbUser;

/**
 * @author 11699
 * @date 2020/2/19 - 16:45
 */
public interface UserService {

    /**
     * 注册
     * @param user
     */
    public void addUser(FtbUser user);


    /**
     * 发送验证码
     * @param phone
     */
    public void sendCode(String phone);

    /**
     * 查看手机号码是否已经注册
     * @param phone
     * @return
     */
    public boolean isHavePhone(String phone);

    /**
     * 查看用户名是否被占用
     * @param username
     * @return
     */
    public boolean isHaveUsername(String username);


    /**
     * 根据手机号码查找已经注册的用户
     * @param phone
     * @return
     */
    public FtbUser findByPhone(String phone);

    /**
     * 修改密码
     * @param user
     * @param newPassword
     */
    public void update(FtbUser user,String newPassword);

    /**
     * 修改资料
     * @param user
     */
    public void updateUser(FtbUser user);
}
