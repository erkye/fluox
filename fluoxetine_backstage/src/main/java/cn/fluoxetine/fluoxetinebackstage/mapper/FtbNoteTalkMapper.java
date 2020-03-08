package cn.fluoxetine.fluoxetinebackstage.mapper;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbNoteTalk;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbNoteTalkExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FtbNoteTalkMapper {
    int countByExample(FtbNoteTalkExample example);

    int deleteByExample(FtbNoteTalkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FtbNoteTalk record);

    int insertSelective(FtbNoteTalk record);

    List<FtbNoteTalk> selectByExample(FtbNoteTalkExample example);

    FtbNoteTalk selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FtbNoteTalk record, @Param("example") FtbNoteTalkExample example);

    int updateByExample(@Param("record") FtbNoteTalk record, @Param("example") FtbNoteTalkExample example);

    int updateByPrimaryKeySelective(FtbNoteTalk record);

    int updateByPrimaryKey(FtbNoteTalk record);
}