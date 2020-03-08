package cn.fluoxetine.fluoxetinebackstage.mapper;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbUser;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FtbUserMapper {
    int countByExample(FtbUserExample example);

    int deleteByExample(FtbUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FtbUser record);

    int insertSelective(FtbUser record);

    List<FtbUser> selectByExample(FtbUserExample example);

    FtbUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FtbUser record, @Param("example") FtbUserExample example);

    int updateByExample(@Param("record") FtbUser record, @Param("example") FtbUserExample example);

    int updateByPrimaryKeySelective(FtbUser record);

    int updateByPrimaryKey(FtbUser record);
}