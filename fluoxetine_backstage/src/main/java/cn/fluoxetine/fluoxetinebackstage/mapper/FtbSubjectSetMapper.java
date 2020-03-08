package cn.fluoxetine.fluoxetinebackstage.mapper;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbSubjectSet;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbSubjectSetExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
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