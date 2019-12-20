package com.hxb.contentcenter.rocketmq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created with IDEA
 *
 * @author:hxb
 * @Date: 2019/12/20 13:30
 * @Description:
 */
public interface MySource {

    String MY_OUTPUT = "my-output";

    @Output(MY_OUTPUT)
    MessageChannel output();

}
