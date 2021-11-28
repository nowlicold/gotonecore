package com.yuan.gotonecore.common.enums;

import com.bench.common.enums.EnumBase;

/**
 * 微信消息类型
 * 
 * @author cold
 *
 * @version $Id: WxMsgTypeEnum.java, v 0.1 2017年2月28日 上午10:20:37 Administrator
 *          Exp $
 */
public enum WxMsgTypeEnum implements EnumBase {

	TEXT("文本"),

	LINK("链接"),

	VIDEO("视频"),

	IMAGE("图片"),

	VOICE("语音"),

	LOCATION("地理"),

	EVENT("事件"), ;

	private String message;

	public String message() {
		// TODO Auto-generated method stub
		return message;
	}

	private WxMsgTypeEnum(String message) {
		this.message = message;
	}

	public Number value() {
		// TODO Auto-generated method stub
		return null;
	}

}
