package cn.fluoxetine.fluoxetinebackstage.mapper;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbNote;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbNoteExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FtbNoteMapper {
    int countByExample(FtbNoteExample example);

    int deleteByExample(FtbNoteExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FtbNote record);

    int insertSelective(FtbNote record);

    List<FtbNote> selectByExampleWithBLOBs(FtbNoteExample example);

    List<FtbNote> selectByExample(FtbNoteExample example);

    FtbNote selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FtbNote record, @Param("example") FtbNoteExample example);

    int updateByExampleWithBLOBs(@Param("record") FtbNote record, @Param("example") FtbNoteExample example);

    int updateByExample(@Param("record") FtbNote record, @Param("example") FtbNoteExample example);

    int updateByPrimaryKeySelective(FtbNote record);

    int updateByPrimaryKeyWithBLOBs(FtbNote record);

    int updateByPrimaryKey(FtbNote record);
}