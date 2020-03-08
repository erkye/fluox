package cn.fluoxetine.frontdesk.service;

import cn.fluoxetine.frontdesk.pojo.FtbSubjectQuestion;

import java.util.List;

/**
 * @author 11699
 * @date 2020/2/16 - 11:50
 *
 * 题目详细内容
 */
public interface SubjectService {

    /**
     * 根据题目集的id查找所有的题目
     * @param subjectId
     * @return
     */
    public List<FtbSubjectQuestion> findBySetId(Integer subjectId);
}
