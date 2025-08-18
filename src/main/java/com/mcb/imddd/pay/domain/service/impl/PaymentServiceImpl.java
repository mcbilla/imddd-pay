package com.mcb.imddd.pay.domain.service.impl;

import com.mcb.imddd.pay.domain.model.aggregate.PaymentAggre;
import com.mcb.imddd.pay.domain.repository.PaymentRepository;
import com.mcb.imddd.pay.domain.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void save(PaymentAggre paymentAggre) {
        paymentAggre.save();
    }

    @Override
    public PaymentAggre findById(Long id) {
        return paymentRepository.findById(id);
    }
}
