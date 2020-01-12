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

import lombok.Data;


/**
 * 〈一句话功能简述〉<br> 
 * 〈Git账号信息〉
 *
 * @author cj
 * @create 2020-1-3
 * @since 1.0.0
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String  avatarUrl;
}
