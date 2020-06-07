/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: QuestionController
 * Author:   cj
 * Date:     2020-2-2 16:32
 * Description: 问题详情页
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pjf.pjf.controller;

import com.pjf.pjf.dto.CommentDTO;
import com.pjf.pjf.dto.QuestionDTO;
import com.pjf.pjf.enums.CommentTypeEnum;
import com.pjf.pjf.service.CommentService;
import com.pjf.pjf.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈问题详情页〉
 *
 * @author cj
 * @create 2020-2-2
 * @since 1.0.0
 */
@Controller
public class QuestionController {


    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id, Model model) {
        QuestionDTO questionDTO = questionService.getById(id);
        Long parentId = id;
       List<CommentDTO> comments = commentService.listByTargetId(parentId, CommentTypeEnum.QUESTION);
        //累加阅读数功能
        questionService.incView(id);
        model.addAttribute("comments",comments);
        model.addAttribute("question", questionDTO);
        return "question";
    }

    @GetMapping("/question/del/{id}")
    public String questionDel(@PathVariable(name = "id") Long id) {
        questionService.getDelById(id);

        return "redirect:/";
    }











}
