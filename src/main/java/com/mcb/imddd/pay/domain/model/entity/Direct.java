package com.mcb.imddd.pay.domain.model.entity;

import com.mcb.imddd.pay.domain.model.valueobject.Amount;

public class Direct {

    private Long id;

    private String directNo;

    private Amount amount;

    public Direct(String directNo, Amount amount) {
        this.directNo = directNo;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirectNo() {
        return directNo;
    }

    public void setDirectNo(String directNo) {
        this.directNo = directNo;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }
}
