/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: UserService
 * Author:   admin
 * Date:     2019/12/10 21:51
 * Description: 用户接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hxb.usercenter.service;

import com.hxb.usercenter.dao.user.UserMapper;
import com.hxb.usercenter.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户接口〉
 *
 * @author admin
 * @create 2019/12/10
 * @since 1.0.0
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

}
