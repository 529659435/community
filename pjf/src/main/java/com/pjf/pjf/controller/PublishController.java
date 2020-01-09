/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: PublishController
 * Author:   cj
 * Date:     2020-1-9 21:20
 * Description: 发起问题页
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pjf.pjf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 〈一句话功能简述〉<br> 
 * 〈发起问题页〉
 *
 * @author cj
 * @create 2020-1-9
 * @since 1.0.0
 */
@Controller
public class PublishController {

    @GetMapping("/publish")
    public String publish( ){
        return "publish";
    }
}
