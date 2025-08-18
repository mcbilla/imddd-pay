package com.mcb.imddd.pay.domain.service;

import com.mcb.imddd.pay.domain.model.aggregate.PaymentAggre;

public interface PaymentService {
    void save(PaymentAggre paymentAggre);

    PaymentAggre findById(Long id);
}
