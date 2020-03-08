package cn.fluoxetine.frontdesk.pojo;

import java.io.Serializable;
import java.util.Date;

public class FtbNote implements Serializable {
    private Integer id;

    private String username;

    private String title;

    private Integer typeId;

    private String introd;

    private Date time;

    private String img;

    private Integer status;

    private Integer recomm;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getIntrod() {
        return introd;
    }

    public void setIntrod(String introd) {
        this.introd = introd == null ? null : introd.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRecomm() {
        return recomm;
    }

    public void setRecomm(Integer recomm) {
        this.recomm = recomm;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public String toString() {
        return "FtbNote{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", title='" + title + '\'' +
                ", typeId=" + typeId +
                ", introd='" + introd + '\'' +
                ", time=" + time +
                ", img='" + img + '\'' +
                ", status=" + status +
                ", recomm=" + recomm +
                ", content='" + content + '\'' +
                '}';
    }
}