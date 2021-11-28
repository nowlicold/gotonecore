package com.yuan.gotonecore.service.sms;

import com.yuan.gotonecore.api.sms.model.SmsConfigInChannel;
import com.yuan.gotonecore.api.sms.model.enums.SmsChannelEnum;

/**
 * 短信配置在通道上的个性化配置查询组件,做了id和smsConfigInChannel缓存
 * 
 * @author cold
 *
 * @version $Id: SmsConfigInChannelQueryComponent.java, v 0.1 2017年2月24日
 *          上午10:49:27 Administrator Exp $
 */
public interface SmsConfigInChannelQueryComponent {

	/**
	 * 根据短信配置id和通道查找
	 * 
	 * @param smsConfigId
	 * @param channelEnum
	 * @return
	 */
	public SmsConfigInChannel getEnabledBySmsConfigIdAndChannel(long smsConfigId, SmsChannelEnum channelEnum);

}
