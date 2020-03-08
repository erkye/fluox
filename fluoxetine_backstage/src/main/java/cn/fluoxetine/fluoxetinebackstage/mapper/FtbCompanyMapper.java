package cn.fluoxetine.fluoxetinebackstage.mapper;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbCompany;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbCompanyExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FtbCompanyMapper {
    int countByExample(FtbCompanyExample example);

    int deleteByExample(FtbCompanyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FtbCompany record);

    int insertSelective(FtbCompany record);

    List<FtbCompany> selectByExample(FtbCompanyExample example);

    FtbCompany selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FtbCompany record, @Param("example") FtbCompanyExample example);

    int updateByExample(@Param("record") FtbCompany record, @Param("example") FtbCompanyExample example);

    int updateByPrimaryKeySelective(FtbCompany record);

    int updateByPrimaryKey(FtbCompany record);
}