package com.hxb.usercenter.rocketmq;


import com.hxb.usercenter.dao.bonus.BonusEventLogMapper;
import com.hxb.usercenter.dao.user.UserMapper;
import com.hxb.usercenter.domain.dto.user.UserAddBonusMsgDTO;
import com.hxb.usercenter.domain.entity.bonus.BonusEventLog;
import com.hxb.usercenter.domain.entity.user.User;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created with IDEA
 *
 * @author:hxb
 * @Date: 2019/12/20 10:18
 * @Description:
 */
@Service
@RocketMQMessageListener(consumerGroup = "consumer-group", topic = "my-group")
public class AddBonusListener implements RocketMQListener<UserAddBonusMsgDTO> {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BonusEventLogMapper bonusEventLogMapper;

    @Override
    public void onMessage(UserAddBonusMsgDTO userAddBonseDTO) {
        Integer userId = userAddBonseDTO.getUserId();
        User user = userMapper.selectByPrimaryKey(userId);
        user.setBonus(user.getBonus() + userAddBonseDTO.getBonus());
        userMapper.updateByPrimaryKeySelective(user);

        bonusEventLogMapper.insert(
                BonusEventLog.builder()
                .userId(userId)
                .value(user.getBonus())
                .event("添加积分")
                .createTime(new Date())
                .build()
        );

    }
}
