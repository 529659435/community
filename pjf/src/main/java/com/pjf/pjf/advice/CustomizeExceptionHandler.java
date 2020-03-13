/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CustomizeExceptionHandler
 * Author:   cj
 * Date:     2020-3-3 21:54
 * Description: 异常处理类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pjf.pjf.advice;

import com.alibaba.fastjson.JSON;
import com.pjf.pjf.dto.ResultDTO;
import com.pjf.pjf.exception.CustomizeErrrorCode;
import com.pjf.pjf.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 〈一句话功能简述〉<br>
 * 〈异常处理返回类类〉
 *
 * @author cj
 * @create 2020-3-3
 * @since 1.0.0
 */
@ControllerAdvice
public class CustomizeExceptionHandler {


    //通用异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    ModelAndView handle(HttpServletRequest request, Model model, Throwable e, HttpServletResponse response) {
        String contenType = request.getContentType();
        if ("application/json".equals(contenType)) {
            ResultDTO resultDTO;
            //返回JSON
            if (e instanceof CustomizeException) {
                resultDTO = ResultDTO.errorOf((CustomizeException) e);
            } else {
                resultDTO = ResultDTO.errorOf(CustomizeErrrorCode.SYS_ERROR);
            }

            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            try {
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDTO));
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return null;
        } else {
            //错误页面跳转
            if (e instanceof CustomizeException) {
                model.addAttribute("message", e.getMessage());
            } else {
                model.addAttribute("message", CustomizeErrrorCode.SYS_ERROR);
            }

            return new ModelAndView("error");
        }

    }
}
