/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: QuestionMapper
 * Author:   cj
 * Date:     2020-1-10 1:35
 * Description: 发布内容
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pjf.pjf.mapper;

import com.pjf.pjf.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 〈一句话功能简述〉<br> 
 * 〈发布内容〉
 *
 * @author cj
 * @create 2020-1-10
 * @since 1.0.0
 */
@Mapper
@Repository
public interface QuestionMapper {

    @Insert("INSERT INTO QUESTION(TITLE,DESCRIPTION,GMT_CREATE,GMT_MODIFIED,CREATOR,TAG)VALUES(#{title},#{description},#{gmt_Create},#{gmt_Modified},#{creator},#{tag})")
     void createQuestion(Question question);
}
