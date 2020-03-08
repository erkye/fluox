package cn.fluoxetine.frontdesk.dao;

import cn.fluoxetine.frontdesk.pojo.FtbLink;
import cn.fluoxetine.frontdesk.pojo.FtbLinkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FtbLinkMapper {
    int countByExample(FtbLinkExample example);

    int deleteByExample(FtbLinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FtbLink record);

    int insertSelective(FtbLink record);

    List<FtbLink> selectByExample(FtbLinkExample example);

    FtbLink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FtbLink record, @Param("example") FtbLinkExample example);

    int updateByExample(@Param("record") FtbLink record, @Param("example") FtbLinkExample example);

    int updateByPrimaryKeySelective(FtbLink record);

    int updateByPrimaryKey(FtbLink record);
}