package com.mcb.imddd.pay.application.dto;

public class PaymentDTO {

    private String payNo;

    public PaymentDTO(String payNo) {
        this.payNo = payNo;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

}
