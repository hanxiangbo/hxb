/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserController
 * Author:   admin
 * Date:     2019/12/10 21:54
 * Description: 用户
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxb.usercenter.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.hxb.usercenter.domain.dto.user.JwtTokenRespDTO;
import com.hxb.usercenter.domain.dto.user.LoginRespDTO;
import com.hxb.usercenter.domain.dto.user.UserLoginDTO;
import com.hxb.usercenter.domain.dto.user.UserRespDTO;
import com.hxb.usercenter.domain.entity.user.User;
import com.hxb.usercenter.service.UserService;
import com.hxb.usercenter.util.JwtOperator;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户〉
 *
 * @author admin
 * @create 2019/12/10
 * @since 1.0.0
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private WxMaService wxMaService;
    @Autowired
    private JwtOperator jwtOperator;

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {
        log.info("====================");
        return userService.findById(id);
    }

    @GetMapping("query")
    public User query(User user) {
        return user;
    }

    @PostMapping("/login")
    public LoginRespDTO login(@RequestBody UserLoginDTO userLoginDTO) throws WxErrorException {
        //微信小程序服务端校验是否已经登录的结果
        WxMaJscode2SessionResult sessionInfo = wxMaService.getUserService().getSessionInfo(userLoginDTO.getCode());
        //微信的openId，用户在微信这边的唯一标示
        String openid = sessionInfo.getOpenid();
        // 看用户是否注册，如果没有注册就（插入）
        // 如果已经注册
        User user = userService.login(userLoginDTO, openid);
        // 颁发token
        Map<String, Object> userInfo = new HashMap<>(3);
        userInfo.put("id", user.getId());
        userInfo.put("wxNickname", user.getWxNickname());
        userInfo.put("role", user.getRoles());

        String token = jwtOperator.generateToken(userInfo);

        log.info(
                "用户{}登录成功，生成的token = {}, 有效期到:{}",
                userLoginDTO.getWxNickname(),
                token,
                jwtOperator.getExpirationTime()
        );

        // 构建响应
        return LoginRespDTO.builder()
                .user(
                        UserRespDTO.builder()
                                .id(user.getId())
                                .avatarUrl(user.getAvatarUrl())
                                .bonus(user.getBonus())
                                .wxNickname(user.getWxNickname())
                                .build()
                )
                .token(
                        JwtTokenRespDTO.builder()
                                .expirationTime(jwtOperator.getExpirationTime().getTime())
                                .token(token)
                                .build()
                )
                .build();
    }
}
