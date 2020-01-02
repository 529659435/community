/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: HelloController
 * Author:   cj
 * Date:     2020-1-1 21:29
 * Description: 测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pjf.pjf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试〉
 *
 * @author cj
 * @create 2020-1-1
 * @since 1.0.0
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    public  String hello(@RequestParam(name = "name")String name, Model model){

           model.addAttribute("name",name);
        return  "hello";

    }
}
