package com.hxb.usercenter.rocketmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created with IDEA
 *
 * @author:hxb
 * @Date: 2019/12/20 13:45
 * @Description:
 */
public interface MySink {

    String MY_INPUT = "my-input";

    @Input(MY_INPUT)
    SubscribableChannel input();
}
