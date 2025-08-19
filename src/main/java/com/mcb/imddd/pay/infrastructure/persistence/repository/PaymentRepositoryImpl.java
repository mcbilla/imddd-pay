package com.mcb.imddd.pay.infrastructure.persistence.repository;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mcb.imddd.pay.domain.factory.PaymentFactory;
import com.mcb.imddd.pay.domain.model.aggregate.PaymentAggre;
import com.mcb.imddd.pay.domain.model.entity.Payment;
import com.mcb.imddd.pay.domain.repository.PaymentRepository;
import com.mcb.imddd.pay.infrastructure.persistence.po.PaymentPO;
import com.mcb.imddd.pay.infrastructure.persistence.mapper.PaymentMapper;
import com.mcb.imddd.pay.infrastructure.util.PaymentConverter;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepositoryImpl extends ServiceImpl<PaymentMapper, PaymentPO> implements PaymentRepository, IService<PaymentPO> {

    @Override
    public int create(PaymentAggre paymentAggre) {
        PaymentPO paymentPO = PaymentFactory.getInstance().createPaymentPO(paymentAggre);
        return baseMapper.insert(paymentPO);
    }

    @Override
    public PaymentAggre findById(Long id) {
        PaymentPO paymentPO = baseMapper.selectById(id);
        Payment payment = PaymentConverter.poToEntity(paymentPO);
        return new PaymentAggre(paymentPO.getId(), paymentPO.getPayAccountId(), paymentPO.getRevAccountId(), payment);
    }
}
