/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CustomizeException
 * Author:   cj
 * Date:     2020-3-3 22:07
 * Description: 自定义异常处理类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pjf.pjf.exception;

/**
 * 〈一句话功能简述〉<br>
 * 〈自定义异常处理类〉
 *
 * @author cj
 * @create 2020-3-3
 * @since 1.0.0
 */
public class CustomizeException extends RuntimeException {

    String message;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }


    public CustomizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
