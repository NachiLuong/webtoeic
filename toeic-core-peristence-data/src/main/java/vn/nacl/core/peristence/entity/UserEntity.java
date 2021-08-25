package vn.nacl.core.peristence.entity;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "createdate")
    private Timestamp createdate;


    @ManyToOne
    @JoinColumn(name = "roleid")
    private RoleEntity role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<CommentEntity> commentEntityList;

    public List<CommentEntity> getCommentList() {
        return commentEntityList;
    }

    public void setCommentList(List<CommentEntity> commentEntityList) {
        this.commentEntityList = commentEntityList;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Timestamp getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }
    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}
