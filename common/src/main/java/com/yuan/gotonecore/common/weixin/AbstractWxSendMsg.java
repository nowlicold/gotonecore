package com.yuan.gotonecore.common.weixin;
import com.bench.common.model.BaseModel;
import com.yuan.gotonecore.common.enums.WxMsgTypeEnum;

import java.util.Date;

/**
 * 抽象的微信发送消息
 * 
 * @author cold
 *
 * @version $Id: AbstractWxSendMsg.java, v 0.1 2017年2月28日 上午10:20:50 Administrator Exp $
 */
public abstract class AbstractWxSendMsg extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6465376836282845214L;

	/**
	 * 平台ID
	 */
	private String gzhId;

	/**
	 * 会员openId
	 */
	private String userOpenId;

	/**
	 * 消息类型
	 */
	private WxMsgTypeEnum messageType;

	/**
	 * 消息创建时间
	 */
	private Date gmtMessageCreate;
	
	
	public String getGzhId() {
		return gzhId;
	}

	public void setGzhId(String gzhId) {
		this.gzhId = gzhId;
	}

	public String getUserOpenId() {
		return userOpenId;
	}

	public void setUserOpenId(String userOpenId) {
		this.userOpenId = userOpenId;
	}

	public WxMsgTypeEnum getMessageType() {
		return messageType;
	}

	public void setMessageType(WxMsgTypeEnum messageType) {
		this.messageType = messageType;
	}

	public Date getGmtMessageCreate() {
		return gmtMessageCreate;
	}

	public void setGmtMessageCreate(Date gmtMessageCreate) {
		this.gmtMessageCreate = gmtMessageCreate;
	}

	/**
	 * 转换为微信的消息类型
	 * 
	 * @return
	 */
	public String toWxMsgType() {
		return this.messageType.name().toLowerCase();
	}

}
