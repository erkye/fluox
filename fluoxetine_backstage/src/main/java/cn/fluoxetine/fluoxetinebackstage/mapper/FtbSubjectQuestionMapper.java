package cn.fluoxetine.fluoxetinebackstage.mapper;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbSubjectQuestion;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbSubjectQuestionExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
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