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
import com.hxb.contentcenter.rocketmq.MySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
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
    @Autowired
    private Source source;
    @Autowired
    private MySource mySource;

    @GetMapping("baidu")
    private String baidu() {
        return testUserConterFeignClinet.index();
    }

    @GetMapping("/testStream")
    public String testStream() {
        boolean isSend = source.output()
                .send(
                        MessageBuilder
                                .withPayload("什么啊")
                                .build()
                );
        return "success";
    }

    @GetMapping("/testStream2")
    public String testStream2() {
        boolean isSend = mySource.output()
                .send(
                        MessageBuilder
                                .withPayload("什么啊")
                                .build()
                );
        return "success";
    }
}
