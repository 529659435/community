/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CommentController
 * Author:   cj
 * Date:     2020-3-10 11:25
 * Description: 回复控制层
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pjf.pjf.controller;

import com.pjf.pjf.dto.CommentCreateDTO;
import com.pjf.pjf.dto.CommentDTO;
import com.pjf.pjf.dto.ResultDTO;
import com.pjf.pjf.enums.CommentTypeEnum;
import com.pjf.pjf.exception.CustomizeErrrorCode;
import com.pjf.pjf.model.Comment;
import com.pjf.pjf.model.User;
import com.pjf.pjf.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 〈一句话功能简述〉<br>
 * 〈回复控制层〉
 *
 * @author cj
 * @create 2020-3-10
 * @since 1.0.0
 */
@Controller
public class CommentController {


    @Autowired
    private CommentService commentService;

    //评论
    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO,
                       HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return ResultDTO.errorOf(CustomizeErrrorCode.NO_LOGIN);
        }
        Comment record = new Comment();
        record.setParentId(commentCreateDTO.getParentId());
        record.setContent(commentCreateDTO.getContent());
        record.setType(commentCreateDTO.getTypes());
        record.setGmtCreate(System.currentTimeMillis());
        record.setGmtModified(System.currentTimeMillis());
        record.setCommentator(user.getId());
        //Long类型的0
        record.setLikeCount(0L);
        record.setCommentCount(0);
        commentService.insert(record);

        return ResultDTO.okOf();
    }

    @ResponseBody
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public ResultDTO<List<CommentDTO>> comments(@PathVariable(name = "id")Long id) {
       List<CommentDTO> commentDTOS =  commentService.listByTargetId(id,CommentTypeEnum.COMMENT);
        return ResultDTO.okOf(commentDTOS);
    }

}
