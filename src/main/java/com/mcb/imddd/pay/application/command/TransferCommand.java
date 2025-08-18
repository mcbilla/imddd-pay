package com.mcb.imddd.pay.application.command;

import java.math.BigDecimal;

public class TransferCommand {

    public String payAccountNo;

    public String revAccountNo;

    public BigDecimal amount;

    public String getPayAccountNo() {
        return payAccountNo;
    }

    public void setPayAccountNo(String payAccountNo) {
        this.payAccountNo = payAccountNo;
    }

    public String getRevAccountNo() {
        return revAccountNo;
    }

    public void setRevAccountNo(String revAccountNo) {
        this.revAccountNo = revAccountNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TransferCommand{");
        sb.append("payAccountNo='").append(payAccountNo).append('\'');
        sb.append(", revAccountNo='").append(revAccountNo).append('\'');
        sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }
}
