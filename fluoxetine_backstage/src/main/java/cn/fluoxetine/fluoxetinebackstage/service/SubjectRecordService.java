package cn.fluoxetine.fluoxetinebackstage.service;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbSubjectRecord;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;

import java.util.Map;

/**
 * @author 11699
 * @date 2020/2/10 - 11:20
 */
public interface SubjectRecordService {

    /**
     * 搜索+分页
     * @param subjectRecord
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult search(FtbSubjectRecord subjectRecord,int pageNum,int pageSize);

    /**
     * 查找
     * @param id
     * @return
     */
    public FtbSubjectRecord findOne(Integer id);

    /**
     * 删除
     * @param ids
     */
    public void delete(Integer[] ids);

    /**
     * 获取记录总数
     * @return
     */
    public Map getRecordNum();
}
