package cn.fluoxetine.fluoxetinebackstage.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author 11699
 * @date 2020/1/15 - 16:02
 * 分页结果类
 */
public class PageResult implements Serializable {
    //总记录数
    private long total;
    //当前页的数据
    private List rows;

    public PageResult(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public List getRows() {
        return rows;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}