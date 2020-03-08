package cn.fluoxetine.fluoxetinebackstage.service.impl;

import cn.fluoxetine.fluoxetinebackstage.mapper.FtbSubjectRecordMapper;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbSubjectRecord;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbSubjectRecordExample;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;
import cn.fluoxetine.fluoxetinebackstage.service.SubjectRecordService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 11699
 * @date 2020/2/10 - 11:23
 */
@Service
@Transactional
public class SubjectRecordServiceImpl implements SubjectRecordService {

    @Autowired
    private FtbSubjectRecordMapper subjectRecordMapper;

    @Override
    public PageResult search(FtbSubjectRecord subjectRecord, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        FtbSubjectRecordExample example = new FtbSubjectRecordExample();

        if(subjectRecord!=null){
            FtbSubjectRecordExample.Criteria criteria = example.createCriteria();
            if(subjectRecord.getUsername()!=null&&subjectRecord.getUsername().length()>0){
                criteria.andUsernameLike("%"+subjectRecord.getUsername()+"%");
            }
            if(subjectRecord.getSubjectId()!=null){
                criteria.andSubjectIdEqualTo(subjectRecord.getSubjectId());
            }

        }

        Page<FtbSubjectRecord> page = (Page<FtbSubjectRecord>) subjectRecordMapper.selectByExample(example);

        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public FtbSubjectRecord findOne(Integer id) {
        return subjectRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(Integer[] ids) {
        for (Integer id : ids) {
            subjectRecordMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public Map getRecordNum() {

        int i = subjectRecordMapper.countByExample(null);
        Map map = new HashMap();
        map.put("recordnum", Integer.toString(i));

        return map;
    }


}
