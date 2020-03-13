/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: QuestionDTO
 * Author:   cj
 * Date:     2020-1-12 23:18
 * Description: 问题列表传输类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pjf.pjf.dto;

import com.pjf.pjf.model.User;
import lombok.Data;

/**
 * 〈一句话功能简述〉<br> 
 * 〈问题列表传输类〉
 *
 * @author cj
 * @create 2020-1-12
 * @since 1.0.0
 */
@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
