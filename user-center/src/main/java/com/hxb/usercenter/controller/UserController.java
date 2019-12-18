/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserController
 * Author:   admin
 * Date:     2019/12/10 21:54
 * Description: 用户
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxb.usercenter.controller;

import com.hxb.usercenter.domain.entity.user.User;
import com.hxb.usercenter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户〉
 *
 * @author admin
 * @create 2019/12/10
 * @since 1.0.0
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id){
        log.info("====================");
        return userService.findById(id);
    }

    @GetMapping("query")
    public User query(User user){
        return user;
    }
}
