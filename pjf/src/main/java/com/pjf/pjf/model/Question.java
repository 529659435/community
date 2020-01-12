/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Question
 * Author:   cj
 * Date:     2020-1-10 1:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pjf.pjf.model;

import java.util.Objects;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author cj
 * @create 2020-1-10
 * @since 1.0.0
 */
public class Question {

    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmt_Create;
    private Long gmt_Modified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", tag='" + tag + '\'' +
                ", gmt_Create=" + gmt_Create +
                ", gmt_Modified=" + gmt_Modified +
                ", creator=" + creator +
                ", viewCount=" + viewCount +
                ", commentCount=" + commentCount +
                ", likeCount=" + likeCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id) &&
                Objects.equals(title, question.title) &&
                Objects.equals(description, question.description) &&
                Objects.equals(tag, question.tag) &&
                Objects.equals(gmt_Create, question.gmt_Create) &&
                Objects.equals(gmt_Modified, question.gmt_Modified) &&
                Objects.equals(creator, question.creator) &&
                Objects.equals(viewCount, question.viewCount) &&
                Objects.equals(commentCount, question.commentCount) &&
                Objects.equals(likeCount, question.likeCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, tag, gmt_Create, gmt_Modified, creator, viewCount, commentCount, likeCount);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Long getGmt_Create() {
        return gmt_Create;
    }

    public void setGmt_Create(Long gmt_Create) {
        this.gmt_Create = gmt_Create;
    }

    public Long getGmt_Modified() {
        return gmt_Modified;
    }

    public void setGmt_Modified(Long gmt_Modified) {
        this.gmt_Modified = gmt_Modified;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }
}
