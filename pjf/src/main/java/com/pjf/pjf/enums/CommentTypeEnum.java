/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CommentTypeEnum
 * Author:   cj
 * Date:     2020-3-10 19:51
 * Description: 返回消息枚举类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pjf.pjf.enums;

/**
 * 〈一句话功能简述〉<br>
 * 〈返回消息枚举类〉
 *
 * @author cj
 * @create 2020-3-10
 * @since 1.0.0
 */

public enum CommentTypeEnum {
    QUESTION(1),
    COMMENT(2);

    private Integer type;


    public Integer getType() {
        return type;
    }

    CommentTypeEnum(Integer type) {
        this.type = type;
    }


    public static boolean isExist(Integer type) {

        for (CommentTypeEnum value : CommentTypeEnum.values()) {
            if (value.getType().equals(type)) {
                return true;
            }
        }
        return false;
    }


}
