package com.mcb.imddd.pay.domain.model.valueobject;

import com.mcb.imddd.pay.domain.base.ValueObject;

import java.math.BigDecimal;

public final class Amount implements ValueObject<Amount> {

    private final BigDecimal amount;

    public Amount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean sameValueAs(Amount other) {
        return false;
    }
}
