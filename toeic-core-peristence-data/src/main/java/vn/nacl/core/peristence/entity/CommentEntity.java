package vn.nacl.core.peristence.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @Column(name = "content")
    private String content;

    @Column(name = "createdate")
    private Timestamp createdate;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "listenguidelineid")
    private ListenGuideLineEntity listenGuideLineEntity;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ListenGuideLineEntity getListenGuideLine() {
        return listenGuideLineEntity;
    }

    public void setListenGuideLine(ListenGuideLineEntity listenGuideLineEntity) {
        this.listenGuideLineEntity = listenGuideLineEntity;
    }
}
