package cn.fluoxetine.frontdesk.service.impl;

import cn.fluoxetine.frontdesk.dao.FtbSubjectSetMapper;
import cn.fluoxetine.frontdesk.pojo.FtbSubjectSet;
import cn.fluoxetine.frontdesk.pojo.FtbSubjectSetExample;
import cn.fluoxetine.frontdesk.service.SubjectSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 11699
 * @date 2020/2/15 - 20:19
 */
@Service
@Transactional
public class SubjectSetServiceImpl implements SubjectSetService {

    @Autowired
    private FtbSubjectSetMapper subjectSetMapper;

    @Override
    public List<FtbSubjectSet> findAll() {
        FtbSubjectSetExample example = new FtbSubjectSetExample();
        FtbSubjectSetExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(1);

        return subjectSetMapper.selectByExample(example);
    }
}
