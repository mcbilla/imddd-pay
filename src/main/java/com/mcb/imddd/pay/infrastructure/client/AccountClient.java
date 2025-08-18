package com.mcb.imddd.pay.infrastructure.client;

import com.mcb.imddd.pay.domain.model.entity.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "imddd-account")
public interface AccountClient {

    @GetMapping("/account/findByAccountNo")
    Account findByAccountNo(String accountNo);

    @GetMapping("/account/findById")
    Account findById(Long id);
}
