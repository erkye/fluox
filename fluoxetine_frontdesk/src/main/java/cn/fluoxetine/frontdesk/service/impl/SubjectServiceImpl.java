package cn.fluoxetine.frontdesk.service.impl;

import cn.fluoxetine.frontdesk.dao.FtbSubjectQuestionMapper;
import cn.fluoxetine.frontdesk.pojo.FtbSubjectQuestion;
import cn.fluoxetine.frontdesk.pojo.FtbSubjectQuestionExample;
import cn.fluoxetine.frontdesk.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 11699
 * @date 2020/2/16 - 11:53
 */
@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private FtbSubjectQuestionMapper subjectQuestionMapper;



    @Override
    public List<FtbSubjectQuestion> findBySetId(Integer subjectId) {
        FtbSubjectQuestionExample example = new FtbSubjectQuestionExample();
        FtbSubjectQuestionExample.Criteria criteria = example.createCriteria();
        criteria.andSubjectIdEqualTo(subjectId);

        return subjectQuestionMapper.selectByExample(example);
    }
}
