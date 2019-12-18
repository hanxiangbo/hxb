/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserCenterFeignConfiguration
 * Author:   admin
 * Date:     2019/12/14 15:33
 * Description: feign日志级别
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxb.contentcenter.configuration;

import feign.Logger;
import org.springframework.context.annotation.Bean;


/**
 * 〈一句话功能简述〉<br> 
 * 〈feign日志级别〉
 *
 * @author admin
 * @create 2019/12/14
 * @since 1.0.0
 */
public class UserCenterFeignConfiguration {

    @Bean
    public Logger.Level levrl(){
        return Logger.Level.FULL;
    }

}
