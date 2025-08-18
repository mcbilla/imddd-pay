package com.mcb.imddd.pay.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mcb.imddd.pay.infrastructure.persistence.entity.PaymentPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper extends BaseMapper<PaymentPO> {
}
