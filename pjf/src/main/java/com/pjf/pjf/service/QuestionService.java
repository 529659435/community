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

import com.pjf.pjf.dto.QuestionDTO;
import com.pjf.pjf.mapper.QuestionMapper;
import com.pjf.pjf.mapper.UserMapper;
import com.pjf.pjf.model.Question;
import com.pjf.pjf.model.User;
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


    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            //question类拷贝到questionDTO
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
