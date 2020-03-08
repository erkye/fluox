package cn.fluoxetine.fluoxetinebackstage.service;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbSubjectQuestion;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;

/**
 * @author 11699
 * @date 2020/2/9 - 16:54
 */
public interface SubjectQuestionService {

    /**
     * 模糊查询+分页+查询
     * @param subjectQuestion
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult search(FtbSubjectQuestion subjectQuestion,int pageNum,int pageSize);

    /**
     * 添加
     * @param subjectQuestion
     */
    public void add(FtbSubjectQuestion subjectQuestion);

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
    public FtbSubjectQuestion findOne(Integer id);

    /**
     * 修改
     * @param subjectQuestion
     */
    public void update(FtbSubjectQuestion subjectQuestion);
}
