package cn.fluoxetine.fluoxetinebackstage.mapper;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbSubjectRecord;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbSubjectRecordExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FtbSubjectRecordMapper {
    int countByExample(FtbSubjectRecordExample example);

    int deleteByExample(FtbSubjectRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FtbSubjectRecord record);

    int insertSelective(FtbSubjectRecord record);

    List<FtbSubjectRecord> selectByExample(FtbSubjectRecordExample example);

    FtbSubjectRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FtbSubjectRecord record, @Param("example") FtbSubjectRecordExample example);

    int updateByExample(@Param("record") FtbSubjectRecord record, @Param("example") FtbSubjectRecordExample example);

    int updateByPrimaryKeySelective(FtbSubjectRecord record);

    int updateByPrimaryKey(FtbSubjectRecord record);
}