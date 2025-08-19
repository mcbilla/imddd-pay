package com.mcb.imddd.pay.domain.service;

import com.mcb.imddd.pay.domain.model.aggregate.DirectAggre;

public interface DirectService {
    void sendToBank(DirectAggre directAggre);

    void handleBankCallback(String message);
}
