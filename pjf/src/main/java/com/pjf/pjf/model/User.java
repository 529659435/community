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

import lombok.Data;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户表信息〉
 *
 * @author cj
 * @create 2020-1-7
 * @since 1.0.0
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatar_url;
}
