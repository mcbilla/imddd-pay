package com.mcb.imddd.pay.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;

@FeignClient(name = "imddd-direct")
public interface DirectClient {
    @GetMapping("/direct/sendToBank")
    void sendToBank(String payAccountNo, String revAccountNo, String payNo, BigDecimal amount);
}
