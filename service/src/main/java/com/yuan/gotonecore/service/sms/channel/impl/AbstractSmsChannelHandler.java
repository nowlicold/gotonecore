package com.yuan.gotonecore.service.sms.channel.impl;

import java.util.Map;

import com.bench.lang.base.properties.utils.PropertiesUtils;
import com.bench.lang.base.string.utils.StringUtils;
import com.yuan.gotonecore.api.sms.model.SmsConfigInChannel;
import com.yuan.gotonecore.api.sms.model.enums.SmsChannelEnum;
import com.yuan.gotonecore.repository.entity.SmsOutDO;
import com.yuan.gotonecore.service.sms.SmsChannelConfigQueryComponent;
import com.yuan.gotonecore.service.sms.SmsConfigInChannelQueryComponent;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 抽象的短信通道处理器
 * 
 * @author cold
 *
 * @version $Id: AbstractSmsChannelHandler.java, v 0.1 2016年8月22日 下午12:07:49
 *          cold Exp $
 */
public class AbstractSmsChannelHandler {

	/**
	 * 短信通道配置查询组件
	 */
	@Autowired
	protected SmsChannelConfigQueryComponent smsChannelConfigQueryComponent;

	/**
	 * 短信配置在通道上的个性化配置查询组件
	 */
	@Autowired
	protected SmsConfigInChannelQueryComponent smsConfigInChannelQueryComponent;

	public AbstractSmsChannelHandler() {
		super();
	}

	protected SmsConfigInChannel setSpecialParameters(SmsOutDO smsOutDO, Map<String, String> parameters, SmsChannelEnum channel) {
		SmsConfigInChannel smsConfigInChannel = smsConfigInChannelQueryComponent.getEnabledBySmsConfigIdAndChannel(smsOutDO.getSmsConfigId(), channel);
		Map<String, String> smsOutTemplateArgs = PropertiesUtils.restoreMap(smsOutDO.getTemplateArgs());
		for (Map.Entry<String, String> entry : smsConfigInChannel.getProperties().entrySet()) {
			// 如果是参数值开头的，添加到参数中
			if (StringUtils.startsWith(entry.getKey(), SmsConfigInChannel.PARAM_VALUE_START_WITH)) {
				parameters.put(entry.getKey().substring(SmsConfigInChannel.PARAM_VALUE_START_WITH.length()), entry.getValue());
			}
			// 如果是替换变量开头的
			if (StringUtils.startsWith(entry.getKey(), SmsConfigInChannel.PARAM_ARG_REPLACE_START_WITH)) {
				String value = smsOutTemplateArgs.get(entry.getValue());
				String name = entry.getKey().substring(SmsConfigInChannel.PARAM_ARG_REPLACE_START_WITH.length());
				// 默认值
				if (StringUtils.isEmpty(value)) {
					String defaultValue = smsConfigInChannel.getProperties().get(SmsConfigInChannel.PARAM_ARG_DEFAULT_VALUE_START_WITH + name);
					if (!StringUtils.isEmpty(defaultValue)) {
						value = defaultValue;
					}
				}
				parameters.put(name, value);
			}
		}
		return smsConfigInChannel;
	}

}