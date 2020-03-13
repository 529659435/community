/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ResultDTO
 * Author:   cj
 * Date:     2020-3-10 19:43
 * Description: 返回消息类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pjf.pjf.dto;

import com.pjf.pjf.exception.CustomizeErrrorCode;
import com.pjf.pjf.exception.CustomizeException;
import lombok.Data;

/**
 * 〈一句话功能简述〉<br>
 * 〈API返回消息类〉
 *
 * @author cj
 * @create 2020-3-10
 * @since 1.0.0
 */
@Data
public class ResultDTO {
    private Integer code;
    private String message;


    public static ResultDTO errorOf(Integer code, String message) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        return resultDTO;

    }

    public static ResultDTO errorOf(CustomizeErrrorCode errorCode) {
        return errorOf(errorCode.getCode(), errorCode.getMessage());
    }

    public static ResultDTO errorOf(CustomizeException e) {
        return errorOf(e.getCode(), e.getMessage());
    }

    public static ResultDTO okOf() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        return resultDTO;

    }


}
