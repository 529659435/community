/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CommentCreateDTO
 * Author:   cj
 * Date:     2020-3-10 11:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pjf.pjf.dto;

import lombok.Data;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author cj
 * @create 2020-3-10
 * @since 1.0.0
 */
@Data
public class CommentCreateDTO {

    private Long parentId;
    private Integer types;
    private String  content;
}
