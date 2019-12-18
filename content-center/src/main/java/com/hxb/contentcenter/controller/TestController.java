/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestController
 * Author:   admin
 * Date:     2019/12/14 16:36
 * Description: 测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxb.contentcenter.controller;

import com.hxb.contentcenter.feignclinet.TestUserConterFeignClinet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈测试〉
 *
 * @author admin
 * @create 2019/12/14
 * @since 1.0.0
 */
@RestController
public class TestController {

    @Autowired
    private TestUserConterFeignClinet testUserConterFeignClinet;

    @GetMapping("baidu")
    private String baidu() {
        return testUserConterFeignClinet.index();
    }
}
