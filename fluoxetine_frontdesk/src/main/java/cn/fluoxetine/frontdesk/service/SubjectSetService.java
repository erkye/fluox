package cn.fluoxetine.frontdesk.service;

import cn.fluoxetine.frontdesk.pojo.FtbSubjectSet;

import java.util.List;

/**
 * @author 11699
 * @date 2020/2/15 - 20:18
 *
 * 题目分类
 */
public interface SubjectSetService {

    public List<FtbSubjectSet> findAll();
}
