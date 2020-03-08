package cn.fluoxetine.fluoxetinebackstage.service;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbNoteTalk;

import java.util.List;

/**
 * @author 11699
 * @date 2020/2/11 - 12:41
 */
public interface NoteTalkService {

    /**
     * 根据帖子id查找评论
     * @param noteId
     * @return
     */
    public List<FtbNoteTalk> findByNoteId(Integer noteId);

    /**
     * 删除评论
     * @param id
     */
    public void delete(Integer id);
}
