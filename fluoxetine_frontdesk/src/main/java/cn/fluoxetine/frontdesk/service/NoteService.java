package cn.fluoxetine.frontdesk.service;

import cn.fluoxetine.frontdesk.pojo.FtbNote;
import cn.fluoxetine.frontdesk.pojo.PageResult;

import java.util.List;

/**
 * @author 11699
 * @date 2020/2/15 - 16:12
 */
public interface NoteService {

    /**
     * 查找推荐帖
     * @return
     */
    public List<FtbNote> findRecomm();


    /**
     * 发布帖子
     * @param note
     */
    public void add(FtbNote note);

    /**
     * 联合查询
     * @param note
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult search(FtbNote note,int pageNum,int pageSize);


    /**
     * 根据id查找
     * @param id
     * @return
     */
    public FtbNote findOneById(Integer id);

    /**
     * 根据用户名查找帖子
     * @param username
     * @return
     */
    public PageResult findOneByUsername(String username,Integer pageNum,Integer pageSize);


    /**
     * 删除帖子
     * @param id
     */
    public void deleteNoteById(Integer id,String username);


    /**
     * 修改帖子
     * @param note
     */
    public void updateNote(FtbNote note);


}
