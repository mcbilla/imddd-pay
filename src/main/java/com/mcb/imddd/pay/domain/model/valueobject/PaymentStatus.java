package com.mcb.imddd.pay.domain.model.valueobject;

import com.mcb.imddd.pay.domain.base.ValueObject;

import java.util.Arrays;

public enum PaymentStatus implements ValueObject<PaymentStatus> {

    SUC("SUC", "支付成功"),
    FAIL("FAIL", "支付失败"),
    CANC("CANC", "取消支付"),
    RFT("RFT", "退票"),
    TBP("TBP", "待经办"),
    UAP("UAP", "审批中"),
    APPR("APPR", "审批通过"),
    DLP("DLP", "直联处理中"),
    BPP("BPP", "银行处理中"),
    AHI("AHI", "待人工确认"),
    ARP("ARP", "重发审批中"),
    INST("INST", "初始状态"),
    WAP("WAP", "待支付"),
    PYG("PYG", "支付中"),
    PSUC("PSUC", "部分成功"),
    OTR("OTR", "其他"),
    ;

    private String code;

    private String desc;

    PaymentStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static PaymentStatus fromCode(String code) {
        return Arrays.stream(PaymentStatus.values()).filter(t -> t.getCode().equals(code)).findFirst().orElse(null);
    }

    @Override
    public boolean sameValueAs(PaymentStatus other) {
        return false;
    }
}
