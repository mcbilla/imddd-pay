package com.mcb.imddd.pay.interfaces.dto;

public class TransferRespDTO {

    private String payNo;

    public TransferRespDTO(String payNo) {
        this.payNo = payNo;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

}
