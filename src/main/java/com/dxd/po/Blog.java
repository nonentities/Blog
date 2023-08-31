package com.dxd.po;


import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="t_blog")
public class Blog {

    @javax.persistence.Id
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String content;
    private String firstPicturePath;
    private String flag;
    private Integer numberOfViews;
    //赞赏开启
    private boolean appreciateFlag;



    //版权申明
    private boolean copyrightFlag;
    //评论开启
    private boolean commentFlag;
    //发布
    private String publish;
    //是否推荐
    private boolean recommend;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @ManyToOne
    private Type type;
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags=new ArrayList<>();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments=new ArrayList<>();

    @Transient
    private String tagIds;

    private String description;
    public Blog() {
    }
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumberOfViews() {
        return numberOfViews;
    }

    public void setNumberOfViews(Integer numberOfViews) {
        this.numberOfViews = numberOfViews;
    }

    public boolean isAppreciateFlag() {
        return appreciateFlag;
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAppreciateFlag(boolean appreciateFlag) {
        this.appreciateFlag = appreciateFlag;
    }

    public boolean isCopyrightFlag() {
        return copyrightFlag;
    }

    public void setCopyrightFlag(boolean copyrightFlag) {
        this.copyrightFlag = copyrightFlag;
    }

    public boolean isCommentFlag() {
        return commentFlag;
    }

    public void setCommentFlag(boolean commentFlag) {
        this.commentFlag = commentFlag;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPicturePath() {
        return firstPicturePath;
    }

    public void setFirstPicturePath(String firstPicturePath) {
        this.firstPicturePath = firstPicturePath;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void init() {
        this.tagIds = tagsToIds(this.getTags());
    }

    //1,2,3
    private String tagsToIds(List<Tag> tags) {
        if (!tags.isEmpty()) {
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for (Tag tag : tags) {
                if (flag) {
                    ids.append(",");
                } else {
                    flag = true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        } else {
            return tagIds;
        }
    }
    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPicturePath='" + firstPicturePath + '\'' +
                ", flag='" + flag + '\'' +
                ", numberOfViews=" + numberOfViews +
                ", appreciateFlag=" + appreciateFlag +
                ", copyrightFlag=" + copyrightFlag +
                ", commentFlag=" + commentFlag +
                ", publish='" + publish + '\'' +
                ", recommend=" + recommend +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", type=" + type +
                ", tags=" + tags +
                ", user=" + user +
                ", comments=" + comments +
                ", tagIds='" + tagIds + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
