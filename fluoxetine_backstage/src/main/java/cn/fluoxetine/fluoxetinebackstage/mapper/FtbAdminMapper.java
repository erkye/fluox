package cn.fluoxetine.fluoxetinebackstage.mapper;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbAdmin;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbAdminExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FtbAdminMapper {
    int countByExample(FtbAdminExample example);

    int deleteByExample(FtbAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FtbAdmin record);

    int insertSelective(FtbAdmin record);

    List<FtbAdmin> selectByExample(FtbAdminExample example);

    FtbAdmin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FtbAdmin record, @Param("example") FtbAdminExample example);

    int updateByExample(@Param("record") FtbAdmin record, @Param("example") FtbAdminExample example);

    int updateByPrimaryKeySelective(FtbAdmin record);

    int updateByPrimaryKey(FtbAdmin record);
}