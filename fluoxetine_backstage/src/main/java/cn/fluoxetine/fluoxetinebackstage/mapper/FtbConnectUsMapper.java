package cn.fluoxetine.fluoxetinebackstage.mapper;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbConnectUs;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbConnectUsExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FtbConnectUsMapper {
    int countByExample(FtbConnectUsExample example);

    int deleteByExample(FtbConnectUsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FtbConnectUs record);

    int insertSelective(FtbConnectUs record);

    List<FtbConnectUs> selectByExample(FtbConnectUsExample example);

    FtbConnectUs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FtbConnectUs record, @Param("example") FtbConnectUsExample example);

    int updateByExample(@Param("record") FtbConnectUs record, @Param("example") FtbConnectUsExample example);

    int updateByPrimaryKeySelective(FtbConnectUs record);

    int updateByPrimaryKey(FtbConnectUs record);
}