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
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Insert("INSERT INTO QUESTION(TITLE,DESCRIPTION,GMT_CREATE,GMT_MODIFIED,CREATOR,TAG)VALUES(#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void createQuestion(Question question);

    @Select("SELECT * FROM QUESTION limit #{offset},#{size}")
    List<Question> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(1) from question")
    Integer count();

}