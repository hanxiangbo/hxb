package com.hxb.usercenter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

//扫描mybatis那些包里面的接口
@MapperScan("com.hxb")
@SpringBootApplication
@Slf4j
public class UserCenterApplication {

    public static void main(String[] args) {
        log.debug("项目启动了");
        SpringApplication.run(UserCenterApplication.class, args);
    }

}
