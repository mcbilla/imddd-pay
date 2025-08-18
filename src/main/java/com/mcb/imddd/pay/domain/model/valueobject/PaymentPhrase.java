package com.mcb.imddd.pay.domain.model.valueobject;

import com.mcb.imddd.pay.domain.base.ValueObject;

import java.util.Arrays;

public enum PaymentPhrase implements ValueObject<PaymentPhrase> {

    PRE_ACCEPT_SUBMIT("PRE_ACCEPT_SUBMIT", "提交预处理"),
    PRE_ACCEPT_REJECT("PRE_ACCEPT_REJECT", "预处理拒绝"),
    PRE_ACCEPT_APPROVE("PRE_ACCEPT_APPROVE", "预处理通过"),
    PRE_APPLY_SUBMIT("PRE_APPLY_SUBMIT", "预处理经办"),

    APPLY_SUBMIT("APPLY_SUBMIT", "支付经办"),
    FUND_MONITOR_SUBMIT("FUND_MONITOR_SUBMIT", "提交资金监控审批"),
    FUND_MONITOR_CANCEL("FUND_MONITOR_CANCEL", "资金监控审批-审批撤销"),
    FUND_MONITOR_REJECT("FUND_MONITOR_REJECT", "资金监控审批-审批拒绝"),
    FUND_MONITOR_BACK("FUND_MONITOR_BACK", "资金监控审批-审批退回"),
    FUND_MONITOR_SUBMIT_FAIL("FUND_MONITOR_SUBMIT_FAIL", "资金监控审批-发起审批失败"),
    FUND_MONITOR_PART_APPROVE("FUND_MONITOR_PART_APPROVE", "资金监控审批-初审审批通过"),
    FUND_MONITOR_APPROVE("FUND_MONITOR_APPROVE", "资金监控审批-终审审批通过"),

    APPLY_SUBMIT_FAIL("APPLY_SUBMIT_FAIL", "发起审批失败"),
    APPLY_SUBMIT_SUCCESS("APPLY_SUBMIT_SUCCESS", "发起审批成功"),
    APPLY_AUTO_APPROVE("APPLY_AUTO_APPROVE", "自动审批通过"),
    APPLY_AUTO_REJECT("APPLY_AUTO_REJECT", "自动审批拒绝"),

    APPLY_CANCEL("APPLY_CANCEL", "审批撤销"),
    APPLY_REJECT("APPLY_REJECT", "审批拒绝"),
    APPLY_BACK("APPLY_BACK", "审批退回"),
    APPLY_FAIL("APPLY_FAIL", "审批失败"),
    APPLY_PART_APPROVE("APPLY_PART_APPROVE", "初审（中间节点）审批通过"),
    APPLY_APPROVE("APPLY_APPROVE", "终审审批通过"),

    OTHPC_DTC_NOTSUBMIT("OTHPC_DTC_NOTSUBMIT", "非直联渠道不提交直联"),
    //"提交直联-受理中"只写入日志扩展表保存指令数据，不写入日志表，非正式的事件类型
    DTC_SUBMIT_PROCESSING("DTC_SUBMIT_PROCESSING", "提交直联-受理中"),
    DTC_SUBMIT("DTC_SUBMIT", "提交直联"),
    //DTC_CALLBACK_DTC_FAIL("DTC_CALLBACK_DTC_FAIL", "直联回调-直联处理失败"),
    DTC_CALLBACK_BANK_PROCESSING("DTC_CALLBACK_BANK_PROCESSING", "直联回调-银行处理中"),
    DTC_CALLBACK_SUSPICIOUS("DTC_CALLBACK_SUSPICIOUS", "直联回调-可疑"),
    DTC_CALLBACK_WAIT_CONFIRM("DTC_CALLBACK_WAIT_CONFIRM", "直联回调-待人工确认"),
    DTC_CALLBACK_PART_SUCCESS("DTC_CALLBACK_PART_SUCCESS", "直联回调-部分成功"),
    DTC_CALLBACK_PAY_SUCCESS("DTC_CALLBACK_PAY_SUCCESS", "直联回调-支付成功"),
    DTC_CALLBACK_PAY_FAILED("DTC_CALLBACK_PAY_FAILED", "直联回调-支付失败"),
    DTC_CALLBACK_REFUND("DTC_CALLBACK_REFUND", "直联回调-退票"),
    DTC_CALLBACK_PAY_EXPIRE("DTC_CALLBACK_PAY_EXPIRE", "直联回调-支付过期"),

    APPLY_SUBMIT_CANCEL("APPLY_SUBMIT_CANCEL", "取消支付"),

    FLOW_RESEND_SUBMIT("FLOW_RESEND_SUBMIT", "指令重发提交直联-申请"),
    FLOW_RESEND_CANCEL("FLOW_RESEND_CANCEL", "指令重发提交直联-审批撤销"),
    FLOW_RESEND_REJECT("FLOW_RESEND_REJECT", "指令重发提交直联-审批拒绝"),
    FLOW_RESEND_BACK("FLOW_RESEND_BACK", "指令重发提交直联-审批退回"),
    FLOW_RESEND_PART_APPROVE("FLOW_RESEND_PART_APPROVE", "指令重发提交直联-初审审批通过"),
    FLOW_RESEND_APPROVE("FLOW_RESEND_APPROVE", "指令重发提交直联-终审审批通过"),

    MANUAL_UPDATE_SUBMIT("MANUAL_UPDATE_SUBMIT", "手工修改支付状态-申请"),
    //MANUAL_UPDATE_SUBMIT_FAIL("MANUAL_UPDATE_SUBMIT_FAIL", "手工修改支付状态-发起审批失败", true) ,
    //MANUAL_UPDATE_SUBMIT_SUCCESS("MANUAL_UPDATE_SUBMIT_SUCCESS", "手工修改支付状态-发起审批成功",false) ,
    MANUAL_UPDATE_CANCEL("MANUAL_UPDATE_CANCEL", "手工修改支付状态-审批撤销"),
    MANUAL_UPDATE_REJECT("MANUAL_UPDATE_REJECT", "手工修改支付状态-审批拒绝"),
    MANUAL_UPDATE_BACK("MANUAL_UPDATE_BACK", "手工修改支付状态-审批退回"),
    //MANUAL_UPDATE_FAIL("MANUAL_UPDATE_FAIL", "手工修改支付状态-审批失败"),
    MANUAL_UPDATE_PART_APPROVE("MANUAL_UPDATE_PART_APPROVE", "手工修改支付状态-初审通过"),
    MANUAL_UPDATE_APPROVE("MANUAL_UPDATE_APPROVE", "手工修改支付状态-终审通过"),

    APPLY_RESEND("APPLY_RESEND", "申请重发"),
    ACCOUNT_SYNC_UPDATE_STATUS("ACCOUNT_SYNC_UPDATE_STATUS", "账户退票对账更改状态"),
    ACCOUNT_CANCEL_UPDATE_STATUS("ACCOUNT_CANCEL_UPDATE_STATUS", "账户取消退票对账更改状态");

    private String code;
    private String desc;

    PaymentPhrase(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static PaymentPhrase fromCode(String code) {
        return Arrays.stream(PaymentPhrase.values()).filter(t -> t.getCode().equals(code)).findFirst().orElse(null);
    }

    @Override
    public boolean sameValueAs(PaymentPhrase other) {
        return false;
    }
}
