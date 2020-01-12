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

import lombok.Data;

import java.util.Objects;

/**
 * 〈一句话功能简述〉<br> 
 * 〈授权登入对象〉
 *
 * @author cj
 * @create 2020-1-3
 * @since 1.0.0
 */
@Data
public class AccessTokenDTO {

    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
    private String avatarUrl;

}

