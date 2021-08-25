package vn.nacl.core.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class ListenGuideLineDTO implements Serializable {
    private Integer listenguidelineId;
    private String title;
    private String image;
    private String content;
    private Timestamp createDate;
    private Timestamp modifieDate;
//    private List<CommentEntity> commentEntityList;

    public Integer getListenguidelineId() {
        return listenguidelineId;
    }

    public void setListenguidelineId(Integer listenguidelineId) {
        this.listenguidelineId = listenguidelineId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getModifieDate() {
        return modifieDate;
    }

    public void setModifieDate(Timestamp modifieDate) {
        this.modifieDate = modifieDate;
    }
}
