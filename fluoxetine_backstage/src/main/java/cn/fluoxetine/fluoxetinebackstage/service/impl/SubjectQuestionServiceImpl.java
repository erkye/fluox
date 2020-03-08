package cn.fluoxetine.fluoxetinebackstage.service.impl;

import cn.fluoxetine.fluoxetinebackstage.mapper.FtbSubjectQuestionMapper;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbSubjectQuestion;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbSubjectQuestionExample;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;
import cn.fluoxetine.fluoxetinebackstage.service.SubjectQuestionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 11699
 * @date 2020/2/9 - 16:56
 */
@Service
@Transactional
public class SubjectQuestionServiceImpl implements SubjectQuestionService {


    @Autowired
    private FtbSubjectQuestionMapper subjectQuestionMapper;

    @Override
    public PageResult search(FtbSubjectQuestion subjectQuestion, int pageNum, int pageSize) {

        PageHelper.startPage(pageNum,pageSize);

        FtbSubjectQuestionExample example = new FtbSubjectQuestionExample();

        if(subjectQuestion!=null){

            FtbSubjectQuestionExample.Criteria criteria = example.createCriteria();

            if(subjectQuestion.getQuestion()!=null && subjectQuestion.getQuestion().length()>0){
                criteria.andQuestionLike("%"+subjectQuestion.getQuestion()+"%");
            }
            if(subjectQuestion.getSubjectId()!=null){
                criteria.andSubjectIdEqualTo(subjectQuestion.getSubjectId());
            }

        }

        Page<FtbSubjectQuestion> page = (Page<FtbSubjectQuestion>) subjectQuestionMapper.selectByExample(example);

        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public void add(FtbSubjectQuestion subjectQuestion) {
        subjectQuestionMapper.insert(subjectQuestion);
    }

    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            subjectQuestionMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public FtbSubjectQuestion findOne(Integer id) {

        if(id!=null){
            return subjectQuestionMapper.selectByPrimaryKey(id);
        }
        return null;
    }

    @Override
    public void update(FtbSubjectQuestion subjectQuestion) {
        subjectQuestionMapper.updateByPrimaryKey(subjectQuestion);
    }
}
