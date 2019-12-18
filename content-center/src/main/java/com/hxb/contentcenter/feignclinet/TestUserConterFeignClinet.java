/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserConterFeignClinet
 * Author:   admin
 * Date:     2019/12/14 15:15
 * Description: 用户
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxb.contentcenter.feignclinet;

import com.hxb.contentcenter.domain.dto.user.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户〉
 *
 * @author admin
 * @create 2019/12/14
 * @since 1.0.0
 */
//@FeignClient(name="user-center",configuration = UserCenterFeignConfiguration.class)
@FeignClient(name = "baidu", url = "http://www.baidu.com")
public interface TestUserConterFeignClinet {

    @GetMapping("")
    String index();

}
