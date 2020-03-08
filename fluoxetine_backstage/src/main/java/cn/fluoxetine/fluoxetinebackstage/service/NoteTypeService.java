package cn.fluoxetine.fluoxetinebackstage.service;

import cn.fluoxetine.fluoxetinebackstage.pojo.FtbNoteType;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;

import java.util.List;

/**
 * @author 11699
 * @date 2020/2/10 - 13:09
 */
public interface NoteTypeService {

    public PageResult search(FtbNoteType noteType,int pageNum,int pageSize);

    public void add(FtbNoteType noteType) throws Exception;

    public FtbNoteType findOne(Integer id);

    public void update(FtbNoteType noteType);

    public void delete(Integer[] ids);

    public List<FtbNoteType> findAll();
}
