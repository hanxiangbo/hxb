package com.hxb.usercenter.dao.bonus;

import com.hxb.usercenter.domain.entity.bonus.BonusEventLog;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface BonusEventLogMapper extends Mapper<BonusEventLog> {
}