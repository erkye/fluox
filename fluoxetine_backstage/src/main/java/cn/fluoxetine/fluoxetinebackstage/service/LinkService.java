package cn.fluoxetine.fluoxetinebackstage.service;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbLink;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;

/**
 * @author 11699
 * @date 2020/2/11 - 17:11
 */
public interface LinkService {

    /**
     * 查找
     * @param link
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult search(FtbLink link,int pageNum,int pageSize);

    /**
     * 增加
     * @param link
     */
    public void add(FtbLink link);

    /**
     * 删除
     * @param ids
     */
    public void delete(Integer[] ids);

    /**
     * 查找
     * @param id
     * @return
     */
    public FtbLink findOne(Integer id);

    /**
     * 更新
     * @param link
     */
    public void update(FtbLink link);
}
