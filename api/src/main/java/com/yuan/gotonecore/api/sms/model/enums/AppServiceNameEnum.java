package com.yuan.gotonecore.api.sms.model.enums;


import com.bench.common.enums.EnumBase;

/**
 * 应用服务名枚举
 * 
 * @author cold
 *
 * @version $Id: AppServiceNameEnum.java, v 0.1 2017年2月24日 下午3:51:44 Administrator Exp $
 */
public enum AppServiceNameEnum implements EnumBase {
	
	SMS_SEND(true, "发送短信"),

	SMS_SEND_SIMPLE(true, "简单发送短信"),

	SMS_VALIDATE_ACK(true, "验证短信校验码"),
	
	;
	private AppServiceNameEnum(boolean verifySign, String message) {
		this.verifySign = verifySign;
		this.message = message;
	}

	private String message;

	/**
	 * 是否需要验证签名<br>
	 */
	private boolean verifySign;

	public String message() {
		// TODO Auto-generated method stub.........................................
		return message;
	}

	public boolean verifySign() {
		return verifySign;
	}

	public Number value() {
		// TODO Auto-generated method stub
		return null;
	}
}
