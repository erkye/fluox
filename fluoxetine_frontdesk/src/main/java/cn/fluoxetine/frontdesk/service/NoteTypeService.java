package cn.fluoxetine.frontdesk.service;

import cn.fluoxetine.frontdesk.pojo.FtbNoteType;

import java.util.List;

/**
 * @author 11699
 * @date 2020/2/16 - 15:20
 *
 * 帖子分类
 */
public interface NoteTypeService {

    /**
     * 查找所有的帖子分类
     * @return
     */
    public List<FtbNoteType> findAll();
}
