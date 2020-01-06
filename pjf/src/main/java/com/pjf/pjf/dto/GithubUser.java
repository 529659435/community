/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: GithubUser
 * Author:   cj
 * Date:     2020-1-3 1:03
 * Description: Git账号信息
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pjf.pjf.dto;

import java.util.Objects;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Git账号信息〉
 *
 * @author cj
 * @create 2020-1-3
 * @since 1.0.0
 */
public class GithubUser {
    private String name;
    private Long id;
    private String bio;

    @Override
    public String toString() {
        return "GithubUser{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", bio='" + bio + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GithubUser that = (GithubUser) o;
        return name.equals(that.name) &&
                id.equals(that.id) &&
                bio.equals(that.bio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, bio);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
