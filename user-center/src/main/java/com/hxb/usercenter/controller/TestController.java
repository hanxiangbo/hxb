/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestController
 * Author:   admin
 * Date:     2019/12/10 21:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxb.usercenter.controller;

import com.hxb.usercenter.dao.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 测试
 *
 * @author admin
 * @create 2019/12/10
 * @since 1.0.0
 */
@Controller
public class TestController {

    @Autowired
    private UserMapper userMapper;



}
