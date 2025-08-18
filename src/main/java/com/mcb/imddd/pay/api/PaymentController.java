package com.mcb.imddd.pay.api;

import com.mcb.imddd.pay.application.command.TransferCommand;
import com.mcb.imddd.pay.application.dto.PaymentDTO;
import com.mcb.imddd.pay.application.manager.PaymentManager;
import com.mcb.imddd.pay.infrastructure.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentManager paymentManager;

    @PostMapping("/transfer")
    public Result<PaymentDTO> transfer(HttpServletRequest request, HttpServletResponse response, @RequestBody TransferCommand transferCommand) {
        PaymentDTO paymentDTO = paymentManager.transfer(transferCommand);
        return Result.ok(paymentDTO);
    }
}
