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

import com.pjf.pjf.enums.CommentTypeEnum;
import com.pjf.pjf.exception.CustomizeErrrorCode;
import com.pjf.pjf.exception.CustomizeException;
import com.pjf.pjf.mapper.CommentMapper;
import com.pjf.pjf.mapper.QuestionExtMapper;
import com.pjf.pjf.mapper.QuestionMapper;
import com.pjf.pjf.model.Comment;
import com.pjf.pjf.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
