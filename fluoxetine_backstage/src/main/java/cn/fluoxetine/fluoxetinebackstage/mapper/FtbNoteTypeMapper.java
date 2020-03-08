package cn.fluoxetine.fluoxetinebackstage.mapper;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbNoteType;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbNoteTypeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FtbNoteTypeMapper {
    int countByExample(FtbNoteTypeExample example);

    int deleteByExample(FtbNoteTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FtbNoteType record);

    int insertSelective(FtbNoteType record);

    List<FtbNoteType> selectByExample(FtbNoteTypeExample example);

    FtbNoteType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FtbNoteType record, @Param("example") FtbNoteTypeExample example);

    int updateByExample(@Param("record") FtbNoteType record, @Param("example") FtbNoteTypeExample example);

    int updateByPrimaryKeySelective(FtbNoteType record);

    int updateByPrimaryKey(FtbNoteType record);
}