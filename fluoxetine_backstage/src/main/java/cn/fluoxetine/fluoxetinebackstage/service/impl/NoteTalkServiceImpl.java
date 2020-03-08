package cn.fluoxetine.fluoxetinebackstage.service.impl;

import cn.fluoxetine.fluoxetinebackstage.mapper.FtbNoteTalkMapper;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbNoteTalk;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbNoteTalkExample;
import cn.fluoxetine.fluoxetinebackstage.service.NoteTalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 11699
 * @date 2020/2/11 - 12:44
 */
@Service
@Transactional
public class NoteTalkServiceImpl implements NoteTalkService {

    @Autowired
    private FtbNoteTalkMapper noteTalkMapper;

    @Override
    public List<FtbNoteTalk> findByNoteId(Integer noteId) {

        if (noteId!=null){

            FtbNoteTalkExample example = new FtbNoteTalkExample();
            FtbNoteTalkExample.Criteria criteria = example.createCriteria();
            criteria.andNodeIdEqualTo(noteId);
            criteria.andStatusEqualTo(1);

            return noteTalkMapper.selectByExample(example);
        }

        return null;
    }

    @Override
    public void delete(Integer id) {
        FtbNoteTalk noteTalk = noteTalkMapper.selectByPrimaryKey(id);
        noteTalk.setStatus(0);
        noteTalkMapper.updateByPrimaryKey(noteTalk);
    }
}
