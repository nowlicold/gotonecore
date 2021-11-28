/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.common.weixin;


import com.yuan.gotonecore.common.enums.WxMsgTypeEnum;

/**
 * 发送的文本消息
 * 
 * @author cold
 *
 * @version $Id: WxTextSendMsg.java, v 0.1 2017年2月28日 上午10:21:37 Administrator Exp $
 */
public class WxTextSendMsg extends AbstractWxSendMsg {

	/**
	 * 
	 */
	private static final long serialVersionUID = 812964479179247715L;

	private String content;

	public WxTextSendMsg() {
		super();
		this.setMessageType(WxMsgTypeEnum.TEXT);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
