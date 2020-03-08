package cn.fluoxetine.fluoxetinebackstage.service;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbCompany;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;

/**
 * @author 11699
 * @date 2020/2/11 - 15:00
 */
public interface CompanyService {

    /**
     * 搜索
     * @param company
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult search(FtbCompany company,int pageNum,int pageSize);

    /**
     * 查找
     * @param id
     * @return
     */
    public FtbCompany findOne(Integer id);

    /**
     * 新增
     * @param company
     */
    public void add(FtbCompany company);

    /**
     * 修改
     * @param company
     */
    public void update(FtbCompany company);

    /**
     * 删除
     * @param ids
     */
    public void delete(Integer[] ids);
}
