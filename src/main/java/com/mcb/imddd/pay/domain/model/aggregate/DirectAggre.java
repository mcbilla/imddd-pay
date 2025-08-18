package com.mcb.imddd.pay.domain.model.aggregate;

import com.mcb.imddd.pay.domain.model.valueobject.Amount;

import java.math.BigDecimal;

public class DirectAggre {

    private Long id;

    private Long payAccountId;

    private Long revAccountId;

    private Long payId;

    private Amount amount;

    public DirectAggre(Long payAccountId, Long revAccountId, Long payId, BigDecimal amount) {
        this.payAccountId = payAccountId;
        this.revAccountId = revAccountId;
        this.payId = payId;
        this.amount = new Amount(amount);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPayAccountId() {
        return payAccountId;
    }

    public void setPayAccountId(Long payAccountId) {
        this.payAccountId = payAccountId;
    }

    public Long getRevAccountId() {
        return revAccountId;
    }

    public void setRevAccountId(Long revAccountId) {
        this.revAccountId = revAccountId;
    }

    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }
}
