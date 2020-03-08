package cn.fluoxetine.fluoxetinebackstage.pojo;

import java.io.Serializable;

public class FtbNoteType implements Serializable {
    private Integer id;

    private String type;

    private Integer userVisual;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getUserVisual() {
        return userVisual;
    }

    public void setUserVisual(Integer userVisual) {
        this.userVisual = userVisual;
    }
}