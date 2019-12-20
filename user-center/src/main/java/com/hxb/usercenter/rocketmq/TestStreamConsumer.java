package com.hxb.usercenter.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

/**
 * Created with IDEA
 *
 * @author:hxb
 * @Date: 2019/12/20 13:16
 * @Description:
 */
@Slf4j
@Service
public class TestStreamConsumer {

    @StreamListener(Sink.INPUT)
    public void receive(String messageBody) {
        log.info("接受的显示是{}",messageBody);

    }

    @StreamListener(MySink.MY_INPUT)
    public void myReceive(String messageBody) {
        log.info("MySink接受的显示是{}",messageBody);

    }
}
