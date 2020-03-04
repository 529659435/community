/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: QuestionService
 * Author:   cj
 * Date:     2020-1-12 23:15
 * Description: 查询问题列表类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pjf.pjf.service;

import com.pjf.pjf.dto.PaginationDTO;
import com.pjf.pjf.dto.QuestionDTO;
import com.pjf.pjf.exception.CustomizeErrrorCode;
import com.pjf.pjf.exception.CustomizeException;
import com.pjf.pjf.mapper.QuestionMapper;
import com.pjf.pjf.mapper.UserMapper;
import com.pjf.pjf.model.Question;
import com.pjf.pjf.model.QuestionExample;
import com.pjf.pjf.model.User;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈查询问题列表类〉
 *
 * @author cj
 * @create 2020-1-12
 * @since 1.0.0
 */
@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;


    public PaginationDTO list(Integer page, Integer size) {
        QuestionExample example = new QuestionExample();
        example.createCriteria().andStatusEqualTo("0");
        Integer totalCount = Math.toIntExact(questionMapper.countByExample(example));
        PaginationDTO pagintionDTO = new PaginationDTO();
        pagintionDTO.setPagination(totalCount, page, size);

        //防止小于分页情况
        if (page < 1) {
            page = 1;
        }
        if (page > pagintionDTO.getTotalPage()) {
            page = pagintionDTO.getTotalPage();
        }

        //size*(page-1)
        Integer offset = size * (page - 1);
        List<Question> questions = questionMapper.selectByExampleWithBLOBsWithRowbounds(example, new RowBounds(offset, size));

        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            //question类拷贝到questionDTO
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
            //判断对象为空
         /*   if (!StringUtils.isEmpty(user)){

            }*/

        }
        pagintionDTO.setQuestions(questionDTOList);
        return pagintionDTO;
    }

    public PaginationDTO list(Integer userId, Integer page, Integer size) {

        QuestionExample example = new QuestionExample();
        example.createCriteria().andCreatorEqualTo(userId).andStatusEqualTo("0");
        Integer totalCount = Math.toIntExact(questionMapper.countByExample(example));
        PaginationDTO pagintionDTO = new PaginationDTO();
        pagintionDTO.setPagination(totalCount, page, size);

        //防止小于分页情况
        if (page < 1) {
            page = 1;
        }
        if (page > pagintionDTO.getTotalPage()) {
            page = pagintionDTO.getTotalPage();
        }

        //size*(page-1)
        Integer offset = size * (page - 1);
        List<Question> questions = questionMapper.selectByExampleWithBLOBsWithRowbounds(example, new RowBounds(offset, size));


        List<QuestionDTO> questionDTOList = new ArrayList<>();


        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            //question类拷贝到questionDTO
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }

        pagintionDTO.setQuestions(questionDTOList);

        return pagintionDTO;
    }


    public QuestionDTO getById(Integer id) {
        Question question = questionMapper.selectByPrimaryKey(id);
        if (question == null) {
            throw new CustomizeException(CustomizeErrrorCode.QUESTION_NOT_FOUND);
        }
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        User user = userMapper.selectByPrimaryKey(question.getCreator());
        questionDTO.setUser(user);
        return questionDTO;
    }

    public void getDelById(Integer id) {
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria().andIdEqualTo(id);
        Question dbquestion = new Question();
        dbquestion.setStatus("1");
        questionMapper.updateByExampleSelective(dbquestion, questionExample);
    }

    public void createOrUpdate(Question question) {
        if (question.getId() == null) {
            //创建
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            questionMapper.insertSelective(question);
        } else {
            //更新
            QuestionExample questionExample = new QuestionExample();
            questionExample.createCriteria().andIdEqualTo(question.getId());
            question.setGmtModified(System.currentTimeMillis());
            int updated = questionMapper.updateByExampleSelective(question, questionExample);
            if (updated != 1) {
                throw new CustomizeException(CustomizeErrrorCode.QUESTION_NOT_FOUND);
            }
        }
    }
}
