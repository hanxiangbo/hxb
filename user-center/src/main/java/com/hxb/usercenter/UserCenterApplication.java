package com.hxb.usercenter;

import com.hxb.usercenter.rocketmq.MySink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import tk.mybatis.spring.annotation.MapperScan;


//扫描mybatis那些包里面的接口
@MapperScan("com.hxb.usercenter.dao")
@SpringBootApplication
@Slf4j
@EnableBinding({Sink.class, MySink.class})
public class UserCenterApplication {

    public static void main(String[] args) {
        log.debug("项目启动了");
        SpringApplication.run(UserCenterApplication.class, args);
    }

}
