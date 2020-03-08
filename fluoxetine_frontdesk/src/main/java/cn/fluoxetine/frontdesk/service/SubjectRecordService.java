package cn.fluoxetine.frontdesk.service;

import cn.fluoxetine.frontdesk.pojo.FtbSubjectRecord;

/**
 * @author 11699
 * @date 2020/2/16 - 13:17
 *
 * 测试记录
 *
 */
public interface SubjectRecordService {

    /**
     * 用户做题提交
     * @param record
     */
    public void add(FtbSubjectRecord record);
}
