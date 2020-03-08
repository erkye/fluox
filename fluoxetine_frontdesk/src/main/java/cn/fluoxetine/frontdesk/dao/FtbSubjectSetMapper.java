package cn.fluoxetine.frontdesk.dao;

import cn.fluoxetine.frontdesk.pojo.FtbSubjectSet;
import cn.fluoxetine.frontdesk.pojo.FtbSubjectSetExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FtbSubjectSetMapper {
    int countByExample(FtbSubjectSetExample example);

    int deleteByExample(FtbSubjectSetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FtbSubjectSet record);

    int insertSelective(FtbSubjectSet record);

    List<FtbSubjectSet> selectByExample(FtbSubjectSetExample example);

    FtbSubjectSet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FtbSubjectSet record, @Param("example") FtbSubjectSetExample example);

    int updateByExample(@Param("record") FtbSubjectSet record, @Param("example") FtbSubjectSetExample example);

    int updateByPrimaryKeySelective(FtbSubjectSet record);

    int updateByPrimaryKey(FtbSubjectSet record);
}