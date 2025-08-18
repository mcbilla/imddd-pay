package com.mcb.imddd.pay.infrastructure.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;

@TableName("t_payment")
public class PaymentPO {

    private Long id;

    private Long payAccountId;

    private Long revAccountId;

    private String payNo;

    private BigDecimal amount;

    private String paymentStatus;

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

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public static final class Builder {
        private Long id;
        private Long payAccountId;
        private Long revAccountId;
        private String payNo;
        private BigDecimal amount;
        private String paymentStatus;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder payAccountId(Long payAccountId) {
            this.payAccountId = payAccountId;
            return this;
        }

        public Builder revAccountId(Long revAccountId) {
            this.revAccountId = revAccountId;
            return this;
        }

        public Builder payNo(String payNo) {
            this.payNo = payNo;
            return this;
        }

        public Builder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder paymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public PaymentPO build() {
            PaymentPO paymentPO = new PaymentPO();
            paymentPO.setId(id);
            paymentPO.setPayAccountId(payAccountId);
            paymentPO.setRevAccountId(revAccountId);
            paymentPO.setPayNo(payNo);
            paymentPO.setAmount(amount);
            paymentPO.setPaymentStatus(paymentStatus);
            return paymentPO;
        }
    }
}
