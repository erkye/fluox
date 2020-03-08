package cn.fluoxetine.frontdesk.service.impl;

import cn.fluoxetine.frontdesk.dao.FtbNoteTalkMapper;
import cn.fluoxetine.frontdesk.pojo.FtbNoteTalk;
import cn.fluoxetine.frontdesk.pojo.FtbNoteTalkExample;
import cn.fluoxetine.frontdesk.pojo.PageResult;
import cn.fluoxetine.frontdesk.service.NoteTalkService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author 11699
 * @date 2020/2/19 - 14:25
 */
@Service
@Transactional
public class NoteTalkServiceImpl implements NoteTalkService {

    @Autowired
    private FtbNoteTalkMapper noteTalkMapper;


    @Override
    public PageResult search(FtbNoteTalk noteTalk, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        FtbNoteTalkExample example = new FtbNoteTalkExample();
        if (noteTalk!=null){
            FtbNoteTalkExample.Criteria criteria = example.createCriteria();
            if (noteTalk.getNodeId()!=null){
                //修复当没有传入帖子id时候，查询全部的bug
                criteria.andNodeIdEqualTo(noteTalk.getNodeId());
                criteria.andStatusEqualTo(1);

                Page<FtbNoteTalk> page = (Page<FtbNoteTalk>) noteTalkMapper.selectByExample(example);


                return new PageResult(page.getTotal(),page.getResult());
            }

        }


        return new PageResult(0, null);
    }

    @Override
    public void addNoteTalk(FtbNoteTalk noteTalk) {
        noteTalk.setTime(new Date());
        noteTalk.setStatus(1);

        noteTalkMapper.insert(noteTalk);
    }
}
