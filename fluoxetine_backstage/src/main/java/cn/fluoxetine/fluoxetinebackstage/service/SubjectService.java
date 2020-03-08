package cn.fluoxetine.fluoxetinebackstage.service;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbSubjectSet;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;

import java.util.List;

/**
 * @author 11699
 * @date 2020/2/9 - 10:19
 * 
 * 测试题目管理部分
 */
public interface SubjectService {

    /**
     * 查找所有题目集
     * @return
     */
    public List<FtbSubjectSet> findAll();


    /**
     * 分页搜索查询
     * @param subjectSet 查询主体
     * @param pageNum 页数
     * @param pageSize 页面大小
     * @return
     */
    public PageResult search(FtbSubjectSet subjectSet,int pageNum,int pageSize);


    /**
     * 添加
     * @param subjectSet
     */
    public void addOne(FtbSubjectSet subjectSet);

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public FtbSubjectSet findOne(Integer id);

    /**
     * 更新
     * @param subjectSet
     */
    public void update(FtbSubjectSet subjectSet);

    /**
     * 删除
     * @param ids
     */
    public void delete(Integer[] ids) throws Exception;
}
