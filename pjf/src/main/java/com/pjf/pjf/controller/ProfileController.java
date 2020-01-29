/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: ProfileController
 * Author:   cj
 * Date:     2020-1-19 22:18
 * Description: 个人中心
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pjf.pjf.controller;

import com.pjf.pjf.dto.PaginationDTO;
import com.pjf.pjf.mapper.UserMapper;
import com.pjf.pjf.model.User;
import com.pjf.pjf.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br>
 * 〈个人中心〉
 *
 * @author cj
 * @create 2020-1-19
 * @since 1.0.0
 */
@Controller
public class ProfileController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;


    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action,
                          HttpServletRequest request,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "5") Integer size,
                          Model model) {

        User user = null;
        //方法：让用户持久在线
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        if (user == null) {
            return "redirect:/";
        }

        if ("questions".equals(action)) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的问题");
        } else if ("replies".equals(action)) {
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "最新回复");
        }


        PaginationDTO paginationDTO = questionService.list(user.getId(), page, size);
        model.addAttribute("pagination", paginationDTO);
        return "profile";
    }
}
