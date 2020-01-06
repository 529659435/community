/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AccessTokenDTO
 * Author:   cj
 * Date:     2020-1-3 0:25
 * Description: 授权登入对象
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pjf.pjf.dto;

import java.util.Objects;

/**
 * 〈一句话功能简述〉<br> 
 * 〈授权登入对象〉
 *
 * @author cj
 * @create 2020-1-3
 * @since 1.0.0
 */
public class AccessTokenDTO {

    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessTokenDTO that = (AccessTokenDTO) o;
        return Objects.equals(client_id, that.client_id) &&
                Objects.equals(client_secret, that.client_secret) &&
                Objects.equals(code, that.code) &&
                Objects.equals(redirect_uri, that.redirect_uri) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client_id, client_secret, code, redirect_uri, state);
    }

    @Override
    public String toString() {
        return "AccessTokenDTO{" +
                "client_id='" + client_id + '\'' +
                ", client_secret='" + client_secret + '\'' +
                ", code='" + code + '\'' +
                ", redirect_uri='" + redirect_uri + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
