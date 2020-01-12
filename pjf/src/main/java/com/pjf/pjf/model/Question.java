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

import lombok.Data;


/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author cj
 * @create 2020-1-10
 * @since 1.0.0
 */
@Data
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

}
