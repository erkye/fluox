package cn.fluoxetine.fluoxetinebackstage.service.impl;

import cn.fluoxetine.fluoxetinebackstage.mapper.FtbConnectUsMapper;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbConnectUs;
import cn.fluoxetine.fluoxetinebackstage.pojo.FtbConnectUsExample;
import cn.fluoxetine.fluoxetinebackstage.pojo.PageResult;
import cn.fluoxetine.fluoxetinebackstage.service.ConnectUsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 11699
 * @date 2020/2/12 - 13:21
 */
@Service
@Transactional
public class ConnectUsServiceImpl implements ConnectUsService {

    @Autowired
    private FtbConnectUsMapper connectUsMapper;


    @Override
    public PageResult search(FtbConnectUs connectUs, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        FtbConnectUsExample example = new FtbConnectUsExample();
        if (connectUs!=null){
            FtbConnectUsExample.Criteria criteria = example.createCriteria();
            if (connectUs.getName()!=null && connectUs.getName().length()>0){
                criteria.andNameLike("%"+connectUs.getName()+"%");
            }
        }

        Page<FtbConnectUs> page = (Page<FtbConnectUs>) connectUsMapper.selectByExample(example);

        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void updateStatus(Integer[] ids, Integer status) {
        for (Integer id : ids) {
            FtbConnectUs connectUs = connectUsMapper.selectByPrimaryKey(id);
            //如果是改为已读的
            if (status == 1){
                //判断是不是已处理了
                if (connectUs.getStatus() == 0){
                    //不是已处理和已读改为已读
                    connectUs.setStatus(status);
                    connectUsMapper.updateByPrimaryKey(connectUs);
                }
            }else{
                connectUs.setStatus(status);
                connectUsMapper.updateByPrimaryKey(connectUs);
            }


        }
    }

    @Override
    public FtbConnectUs findOne(Integer id) {
        return connectUsMapper.selectByPrimaryKey(id);
    }
}
