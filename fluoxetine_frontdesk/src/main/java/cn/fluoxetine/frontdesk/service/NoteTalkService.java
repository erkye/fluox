package cn.fluoxetine.frontdesk.service;

import cn.fluoxetine.frontdesk.pojo.FtbNoteTalk;
import cn.fluoxetine.frontdesk.pojo.PageResult;

/**
 * @author 11699
 * @date 2020/2/19 - 14:23
 * 评论
 */
public interface NoteTalkService {

    /**
     * 分页查询全部的评论
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult search(FtbNoteTalk noteTalk, int pageNum, int pageSize);

    /**
     * 增加评论
     * @param noteTalk
     */
    public void addNoteTalk(FtbNoteTalk noteTalk);
}
