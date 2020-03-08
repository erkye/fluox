package cn.fluoxetine.frontdesk.service;

/**
 * @author 11699
 * @date 2020/2/15 - 15:00
 */

import cn.fluoxetine.frontdesk.pojo.FtbCompany;

import java.util.List;

/**
 * 合作厂商
 */
public interface CompanyService {

    public List<FtbCompany> findAll();
}
