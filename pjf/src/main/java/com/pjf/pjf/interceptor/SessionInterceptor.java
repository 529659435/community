/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SessionInterceptord
 * Author:   cj
 * Date:     2020-1-29 23:21
 * Description: 拦截器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.pjf.pjf.interceptor;

import com.pjf.pjf.mapper.UserMapper;
import com.pjf.pjf.model.User;
import com.pjf.pjf.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈拦截器〉
 *
 * @author cj
 * @create 2020-1-29
 * @since 1.0.0
 */
@Service
public class SessionInterceptor implements HandlerInterceptor {

    @Autowired
    private UserMapper userMapper;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //方法：让用户持久在线
        Cookie[] cookies = request.getCookies();

        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    UserExample example = new UserExample();
                    example.createCriteria().andTokenEqualTo(token);
                    List<User> users = userMapper.selectByExample(example);
                    if (users.size() != 0) {
                        request.getSession().setAttribute("user", users.get(0));
                    }
                    break;
                }
            }
        }
        return true;
    }

}
