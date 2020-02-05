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
import org.apache.ibatis.annotations.*;
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

    @Select("SELECT * FROM QUESTION where status = '0'  ORDER BY GMT_CREATE DESC limit #{offset},#{size}")
    List<Question> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(1) from question where status = '0'")
    Integer count();

    @Select("SELECT * FROM QUESTION where status = '0' and creator =#{userId} ORDER BY GMT_CREATE DESC limit #{offset},#{size} ")
    List<Question> listByUserId(@Param(value = "userId") Integer userId, @Param(value = "offset") Integer offset, @Param(value = "size") Integer size);

    @Select("select count(1) from question where status = '0' and creator=#{userId}")
    Integer countByUserId(@Param(value = "userId") Integer userId);


    @Select("select * from question  where status = '0' and id = #{id}")
    Question getById(@Param(value = "id") Integer id);

    @Update("Update question  set status = '1' where id = #{id}")
    void getDelById(@Param(value = "id") Integer id);

    @Update("Update question  set TITLE = #{title},DESCRIPTION=#{description}, TAG=#{tag},GMT_MODIFIED=#{gmtModified} where id = #{id}")
    void update(Question question);

}
