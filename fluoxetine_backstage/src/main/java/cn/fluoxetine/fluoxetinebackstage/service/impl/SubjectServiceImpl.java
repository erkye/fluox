package cn.fluoxetine.fluoxetinebackstage.service.impl;

import cn.fluoxetine.fluoxetinebackstage.mapper.FtbSubjectQuestionMapper;
import cn.fluoxetine.fluoxetinebackstage.mapper.FtbSubjectRecordMapper;
import cn.fluoxetine.fluoxetinebackstage.mapper.FtbSubjectSetMapper;
import cn.fluoxetine.fluoxetinebackstage.pojo.*;
import cn.fluoxetine.fluoxetinebackstage.service.SubjectService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 11699
 * @date 2020/2/9 - 10:21
 */
@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {
    
    
    @Autowired
    private FtbSubjectSetMapper subjectSetMapper;

    @Autowired
    private FtbSubjectQuestionMapper subjectQuestionMapper;

    @Autowired
    private FtbSubjectRecordMapper subjectRecordMapper;
    
    
    
    @Override
    public List<FtbSubjectSet> findAll() {

        FtbSubjectSetExample example = new FtbSubjectSetExample();
        FtbSubjectSetExample.Criteria criteria =example.createCriteria();
        //状态为启用的
        criteria.andStatusEqualTo(1);
        return subjectSetMapper.selectByExample(example);
    }


    @Override
    public PageResult search(FtbSubjectSet subjectSet, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        FtbSubjectSetExample ftbSubjectSetExample = new FtbSubjectSetExample();
        FtbSubjectSetExample.Criteria criteria = ftbSubjectSetExample.createCriteria();

        if(null != subjectSet){
            if(null != subjectSet.getName() && subjectSet.getName().length()>0){
                criteria.andNameLike("%"+subjectSet.getName()+"%");
            }

        }

        Page<FtbSubjectSet> page = (Page<FtbSubjectSet>) subjectSetMapper.selectByExample(ftbSubjectSetExample);

        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public void addOne(FtbSubjectSet subjectSet) {
        subjectSetMapper.insert(subjectSet);
    }

    @Override
    public FtbSubjectSet findOne(Integer id) {
        return subjectSetMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(FtbSubjectSet subjectSet) {
        subjectSetMapper.updateByPrimaryKey(subjectSet);
    }

    @Override
    public void delete(Integer[] ids) throws Exception {
        for (Integer id : ids) {

            //检查问题详情表是否还有数据
            FtbSubjectQuestionExample example = new FtbSubjectQuestionExample();
            FtbSubjectQuestionExample.Criteria criteria = example.createCriteria();
            criteria.andSubjectIdEqualTo(id);
            List<FtbSubjectQuestion> questions = subjectQuestionMapper.selectByExample(example);
            if(questions!=null&&questions.size()>0){
                throw new Exception();
            }

            //检查测试记录表是否有数据
            FtbSubjectRecordExample example1 = new FtbSubjectRecordExample();
            FtbSubjectRecordExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andSubjectIdEqualTo(id);
            List<FtbSubjectRecord> records = subjectRecordMapper.selectByExample(example1);
            if(records!=null&&records.size()>0){
                throw new Exception();
            }


            subjectSetMapper.deleteByPrimaryKey(id);
        }
    }
}
