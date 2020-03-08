package cn.fluoxetine.frontdesk.dao;

import cn.fluoxetine.frontdesk.pojo.FtbSubjectQuestion;
import cn.fluoxetine.frontdesk.pojo.FtbSubjectQuestionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FtbSubjectQuestionMapper {
    int countByExample(FtbSubjectQuestionExample example);

    int deleteByExample(FtbSubjectQuestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FtbSubjectQuestion record);

    int insertSelective(FtbSubjectQuestion record);

    List<FtbSubjectQuestion> selectByExample(FtbSubjectQuestionExample example);

    FtbSubjectQuestion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FtbSubjectQuestion record, @Param("example") FtbSubjectQuestionExample example);

    int updateByExample(@Param("record") FtbSubjectQuestion record, @Param("example") FtbSubjectQuestionExample example);

    int updateByPrimaryKeySelective(FtbSubjectQuestion record);

    int updateByPrimaryKey(FtbSubjectQuestion record);
}