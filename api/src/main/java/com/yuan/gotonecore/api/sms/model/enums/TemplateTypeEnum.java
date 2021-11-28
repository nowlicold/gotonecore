package com.yuan.gotonecore.api.sms.model.enums;

import com.bench.common.enums.EnumBase;

public enum TemplateTypeEnum implements EnumBase {
	EMAIL("邮件"), SMS("短信");

	private String message;
	TemplateTypeEnum(String message){
		this.message = message;
	}

	@Override
	public String message() {
		return this.message;
	}

	@Override
	public Number value() {
		return null;
	}
}
