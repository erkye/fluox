package cn.fluoxetine.fluoxetinebackstage.service;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbNote;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;

/**
 * @author 11699
 * @date 2020/2/10 - 15:29
 */
public interface NoteService {

    public PageResult search(FtbNote note,int pageNum,int pageSize);

    /**
     * 修改状态
     * @param ids
     * @param status
     */
    public void updateStatus(Integer[] ids,Integer status);


    /**
     * 修改推荐状态
     * @param ids
     * @param recomm
     */
    public void updateRecomm(Integer[] ids,Integer recomm);

    /**
     * 查找
     * @param id
     * @return
     */
    public FtbNote findOne(Integer id);

}
