package com.mcb.imddd.pay.domain.model.entity;

import com.mcb.imddd.pay.domain.base.Entity;
import com.mcb.imddd.pay.domain.model.valueobject.Amount;
import com.mcb.imddd.pay.domain.model.valueobject.PaymentStatus;

public class Payment implements Entity<Payment> {

    private Long id;

    private String payNo;

    private Amount amount;

    private PaymentStatus paymentStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }


    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public boolean sameIdentityAs(Payment other) {
        return false;
    }

    public static final class Builder {
        private Long id;
        private String payNo;
        private Amount amount;
        private PaymentStatus paymentStatus;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder payNo(String payNo) {
            this.payNo = payNo;
            return this;
        }

        public Builder amount(Amount amount) {
            this.amount = amount;
            return this;
        }

        public Builder paymentStatus(PaymentStatus paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public Payment build() {
            Payment payment = new Payment();
            payment.setId(id);
            payment.setPayNo(payNo);
            payment.setAmount(amount);
            payment.paymentStatus = this.paymentStatus;
            return payment;
        }
    }
}
