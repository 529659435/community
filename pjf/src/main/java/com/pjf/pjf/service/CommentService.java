/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: CommentService
 * Author:   cj
 * Date:     2020-3-10 19:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pjf.pjf.service;

import com.pjf.pjf.dto.CommentDTO;
import com.pjf.pjf.enums.CommentTypeEnum;
import com.pjf.pjf.exception.CustomizeErrrorCode;
import com.pjf.pjf.exception.CustomizeException;
import com.pjf.pjf.mapper.CommentMapper;
import com.pjf.pjf.mapper.QuestionExtMapper;
import com.pjf.pjf.mapper.QuestionMapper;
import com.pjf.pjf.mapper.UserMapper;
import com.pjf.pjf.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author cj
 * @create 2020-3-10
 * @since 1.0.0
 */
@Service
public class CommentService {


    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionExtMapper questionExtMapper;

    @Autowired
    private UserMapper userMapper;

    //事务注解
    @Transactional
    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizeException(CustomizeErrrorCode.TARGET_PARAM_NOT_FOUND);
        }

        if (comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())) {
            throw new CustomizeException(CustomizeErrrorCode.TYPE_PARAM_WRONG);
        }


        if (comment.getType().equals(CommentTypeEnum.COMMENT.getType())) {
            //回复评论
            Comment dbComent = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (dbComent == null) {
                throw new CustomizeException(CustomizeErrrorCode.COMMENT_NOT_FOUND);
            }
            commentMapper.insert(comment);
        } else {
            //回复问题
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            if (question == null) {
                throw new CustomizeException(CustomizeErrrorCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insert(comment);
            question.setCommentCount(1);
            questionExtMapper.incCommentCount(question);
        }
    }


    public List<CommentDTO> listByQuestionId(Long id) {

        CommentExample example = new CommentExample();
        example.createCriteria()
                .andParentIdEqualTo(id)
                .andTypeEqualTo(CommentTypeEnum.COMMENT.getType());


        List<Comment> comments = commentMapper.selectByExample(example);

        // jdk1.8语法
        if (comments.size() == 0) {
            return new ArrayList<>();
        }

        // 获取去重的评论人
        Set<Long> commentors = comments.stream().map(comment -> comment.getCommentator())
                .collect(Collectors.toSet());

        List userIds = new ArrayList();
        userIds.addAll(commentors);

        // 获取评论人并转换为 Map
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdIn(userIds);
        List<User> users = userMapper.selectByExample(userExample);
        Map<Long, User> userMap = users.stream().collect(Collectors.toMap(user -> user.getId(), user -> user));


        // 转换 comment 为 commentDTO
        List<CommentDTO> commentDTOS = comments.stream().map(comment ->
        {
            CommentDTO commentDTO = new CommentDTO();
            BeanUtils.copyProperties(comment, commentDTO);
            commentDTO.setUser(userMap.get(comment.getCommentator()));
            return commentDTO;
        }).collect(Collectors.toList());

        return commentDTOS;


    }


}


