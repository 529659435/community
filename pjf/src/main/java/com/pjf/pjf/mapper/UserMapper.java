/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: UserMapper
 * Author:   cj
 * Date:     2020-1-7 23:35
 * Description: 用户sql
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pjf.pjf.mapper;

import com.pjf.pjf.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户sql〉
 *
 * @author cj
 * @create 2020-1-7
 * @since 1.0.0
 */
@Mapper
@Repository
public interface UserMapper {

    @Insert("INSERT INTO USER(name,account_id,token,gmt_create,gmt_modified)values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void  insert(User user);
}
