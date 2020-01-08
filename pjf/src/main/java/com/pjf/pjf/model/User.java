/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: User
 * Author:   cj
 * Date:     2020-1-7 23:56
 * Description: 用户表信息
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pjf.pjf.model;

import com.pjf.pjf.mapper.UserMapper;

import java.util.Objects;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户表信息〉
 *
 * @author cj
 * @create 2020-1-7
 * @since 1.0.0
 */
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                name.equals(user.name) &&
                accountId.equals(user.accountId) &&
                token.equals(user.token) &&
                gmtCreate.equals(user.gmtCreate) &&
                gmtModified.equals(user.gmtModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, accountId, token, gmtCreate, gmtModified);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountId='" + accountId + '\'' +
                ", token='" + token + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }
}
