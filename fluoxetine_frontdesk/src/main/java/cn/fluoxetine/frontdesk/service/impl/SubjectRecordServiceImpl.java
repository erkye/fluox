package cn.fluoxetine.frontdesk.service.impl;

import cn.fluoxetine.frontdesk.dao.FtbSubjectRecordMapper;
import cn.fluoxetine.frontdesk.pojo.FtbSubjectRecord;
import cn.fluoxetine.frontdesk.service.SubjectRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author 11699
 * @date 2020/2/16 - 13:18
 */
@Service
@Transactional
public class SubjectRecordServiceImpl implements SubjectRecordService {

    @Autowired
    private FtbSubjectRecordMapper subjectRecordMapper;

    @Override
    public void add(FtbSubjectRecord record) {
        record.setTime(new Date());

        //测试用户的名称暂时设置为匿名
        record.setUsername("匿名");
        subjectRecordMapper.insert(record);
    }
}
