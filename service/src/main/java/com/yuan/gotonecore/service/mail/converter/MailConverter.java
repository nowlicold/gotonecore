/*
 * Bench.com Inc.
 * Copyright (c) 2004-2005 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail.converter;

import com.bench.lang.base.properties.utils.PropertiesUtils;
import com.bench.lang.base.string.utils.StringUtils;
import com.bench.lang.base.velocity.VelocityHelper;
import com.bench.runtime.convert.ConverterManager;
import com.yuan.gotonecore.common.Activity;
import com.yuan.gotonecore.common.MailModel;
import com.yuan.gotonecore.common.enums.ErrorCodeEnum;
import com.yuan.gotonecore.common.exceptions.GotoneCoreException;
import com.yuan.gotonecore.common.mail.MailConfig;
import com.yuan.gotonecore.common.mail.MailUserConfig;
import com.yuan.gotonecore.repository.entity.MailOutBodyDO;
import com.yuan.gotonecore.repository.entity.MailOutDO;
import com.yuan.gotonecore.repository.entity.MailOutHistoryDO;
import com.yuan.gotonecore.repository.mapper.MailOutBodyMapper;
import com.yuan.gotonecore.service.ActivityQueryComponent;
import com.yuan.gotonecore.service.mail.MailConfigQueryComponent;
import com.yuan.gotonecore.service.mail.MailServerConfigQueryComponent;
import com.yuan.gotonecore.service.mail.MailUserConfigQueryComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Map.Entry;

/**
 * 邮件数据转换器
 * 
 * @author cold
 * 
 * @version $Id: GotoneMailConvert.java, v 0.1 2009-10-20 下午02:35:58 cold
 *          Exp $
 */
@Service
@Slf4j
public class MailConverter {

	/** 最大允许存储容量 */
	private static final int MAX_PACITY = 4000;

	/** log */

	/** 参数间隔符 */
	public static final String SUB_PREFIX = "∈";

	/** 参数间隔符 */
	public static final String LIST_PREFIX = "^";

	@Autowired
	private ConverterManager converterManager;

	@Autowired
	private ActivityQueryComponent activityQueryComponent;

	@Autowired
	private MailConfigQueryComponent mailConfigQueryComponent;

	@Autowired
	private MailUserConfigQueryComponent mailUserConfigQueryComponent;

	@Autowired
	private MailServerConfigQueryComponent mailServerConfigQueryComponent;
	@Autowired
	private MailOutBodyMapper mailOutBodyMapper;

	/**
	 * convert Model To HistoryDO
	 * 
	 * @param model
	 * @return
	 */
	public MailOutHistoryDO convertModelToHistoryDO(MailModel model) {
		MailOutHistoryDO gtMailOutHistoryDO = new MailOutHistoryDO();
		converterManager.convert(model, gtMailOutHistoryDO,new String[]{"gmt_create","gmt_modified"});
		gtMailOutHistoryDO.setActivityId(model.getActivity().getId());
		gtMailOutHistoryDO.setMailConfigId(model.getMailConfig().getId());
		gtMailOutHistoryDO.setProperties(PropertiesUtils.convert2String(model.getProperties(), false));
		gtMailOutHistoryDO.setTemplateArgs(PropertiesUtils.convert2String(model.getTemplateArgs(), false));
		gtMailOutHistoryDO.setMailUserConfigId(model.getSendMailUserConfig().getId());
		gtMailOutHistoryDO.setMailFrom(model.getSendMailUserConfig().getFromAddr());
		gtMailOutHistoryDO.setGmtMailMsgCreate(model.getGmtCreate());
		if (model.getProperties() != null)
			gtMailOutHistoryDO.setProperties(PropertiesUtils.convert2String(model.getProperties(), false));
		gtMailOutHistoryDO.setTemplateArgs(PropertiesUtils.convert2String(model.getTemplateArgs(), false));
		return gtMailOutHistoryDO;
	}

	public MailModel convertToModel(MailOutDO mailOutDO) throws GotoneCoreException {
		// 构建模型
		MailModel mailModel = new MailModel();
		this.converterManager.convert(mailOutDO, mailModel);
		mailModel.setId(mailModel.getId());
		mailModel.setSendTimes((int) mailModel.getSendTimes());
		Activity activity = activityQueryComponent.getCachedById(mailOutDO.getActivityId());
		mailModel.setActivity(activity);
		MailConfig mailConfig = mailConfigQueryComponent.getCachedMailConfigById(mailOutDO.getMailConfigId());
		if (!mailConfig.isEnabled()) {
			mailConfig = mailConfigQueryComponent.getCachedRandomEnabledMailConfigByActivityId(activity.getId());
		}
		if (mailConfig == null) {
			log.error("发送邮件时，无法选额发送的用户，id=" + mailOutDO.getId());
			throw new GotoneCoreException(ErrorCodeEnum.MAIL_CONFIG_NOT_EXISTS.errorCode());
		}
		mailModel.setMailConfig(mailConfig);

		MailUserConfig mailUserConfig = mailUserConfigQueryComponent.selectMailUserConfig(activity.getId(), mailModel.getReceiver());
		if (mailUserConfig == null) {
			log.error("发送邮件时，无法选额发送的用户，id=" + mailOutDO.getId());
			throw new GotoneCoreException(ErrorCodeEnum.MAIL_USER_CONFIG_NOT_EXISTS.errorCode());
		}
		mailModel.setMailReplayTo(mailUserConfig.getFromAddr());
		mailModel.setSendMailUserConfig(mailUserConfig);
		Map<String, String> map = PropertiesUtils.restoreMap(mailOutDO.getTemplateArgs());
		mailModel.setMailSubject(VelocityHelper.getInstance().evaluate(map, mailConfig.getSubject()));
		mailModel.setMailServerConfig(mailServerConfigQueryComponent.getCachedMailServerConfig(mailUserConfig.getMailServerId()));
		mailModel.setMailContent(VelocityHelper.getInstance().evaluate(map,mailConfig.getContent()));
		return mailModel;
	}

	/**
	 * 根据内容发送时：把mailOutDO + mailOutBodyDO 合并成MailModel
	 * 
	 * @param mailOutDO
	 * @param mailOutBodyDO
	 * @return
	 * @throws GotoneCoreException
	 */
	public MailModel convertToBodyModel(MailOutDO mailOutDO, MailOutBodyDO mailOutBodyDO) throws GotoneCoreException {
		// 构建模型
		MailModel mailModel = new MailModel();
		MailOutBodyDO mailBody = mailOutBodyMapper.selectById(mailOutDO.getId());
		if (mailBody == null) {
			log.error("发送邮件时，发现邮件内容不存在，邮件id为：mailOutId=" + mailOutDO.getId());
			throw new GotoneCoreException(ErrorCodeEnum.MAIL_BODY_NOT_FOUND.errorCode());
		}
		this.converterManager.convert(mailOutDO, mailModel);
		mailModel.setId(mailModel.getId());
		mailModel.setSendTimes((int) mailModel.getSendTimes());

		Activity activity =  null;
		//todo
		//		activityQueryComponent.getById(mailOutDO.getActivityId());
		mailModel.setActivity(activity);

		MailConfig mailConfig = new MailConfig();
		mailModel.setMailConfig(mailConfig);

		MailUserConfig mailUserConfig = mailUserConfigQueryComponent.selectMailUserConfig(activity.getId(), mailOutDO.getReceiver());
		if (mailUserConfig == null) {
			log.error("发送邮件时，无法选额发送的用户，userid=" + mailOutDO.getUserId());
			throw new GotoneCoreException(ErrorCodeEnum.MAIL_USER_CONFIG_NOT_EXISTS.errorCode());
		}
		mailModel.setMailReplayTo(mailUserConfig.getFromAddr());
		mailModel.setSendMailUserConfig(mailUserConfig);

		mailModel.setMailServerConfig(mailServerConfigQueryComponent.getCachedMailServerConfig(mailUserConfig.getMailServerId()));
		mailModel.setMailContent(mailOutBodyDO.getMailBody());

		return mailModel;
	}

	/**
	 * 将参数替换成Map
	 * 
	 * @param content
	 * @param contentTail
	 * @return
	 */
	public Map<String, String> getTemplateMap(String content, String contentTail) {
		// 允许替代参数为空
		if (StringUtils.isEmpty(content)) {
			log.warn("从数据库捞取到的替代参数为空");
			return new HashMap<String, String>();
		}

		// 当后半段不为空时进行拼接，构成完整消息替代参数
		if (!StringUtils.isEmpty(contentTail)) {
			content = content + contentTail;
		}

		// 得到键值对
		String[] contentArr = content.split(SUB_PREFIX);

		// 转Map
		Map<String, String> templateMap = new HashMap<String, String>();
		for (String str : contentArr) {
			templateMap.putAll(PropertiesUtils.toMap(PropertiesUtils.restoreFromString(str, "GBK")));
		}
		return templateMap;
	}

	/**
	 * 替代参数内容截取
	 * 
	 * 策略： 前后两个字段各存一半
	 * 
	 * @param
	 * @return
	 */
	public String[] getContent(Map<String, String> map) {

		// 拼接map参数
		StringBuffer header = new StringBuffer();
		StringBuffer tail = new StringBuffer();

		if (map == null || map.size() == 0) {
			return new String[] { MailConverter.SUB_PREFIX, MailConverter.SUB_PREFIX };
		}

		int size = map.size();
		int index = 0;
		// 分段存储替代参数
		for (Entry<String, String> entry : map.entrySet()) {

			// 存储前半段
			if ((index < (size / 2)) || (size == 1)) {
				header.append(entry.toString());
				header.append(MailConverter.SUB_PREFIX);
			}

			// 存储后半段
			if ((index >= (size / 2)) && (size != 1)) {
				tail.append(entry.toString());
				tail.append(MailConverter.SUB_PREFIX);
			}
			index++;
		}
		String[] templateArgs = new String[2];
		templateArgs[0] = header.toString();
		templateArgs[1] = tail.toString();

		if ((templateArgs[0].length() > MAX_PACITY) || (templateArgs[1].length() > MAX_PACITY)) {
			log.warn("templateArgs[0]=" + templateArgs[0]);
			log.warn("templateArgs[1]=" + templateArgs[1]);
			log.warn("邮件替代参数占用空间大小超限！");
		}

		if (log.isInfoEnabled()) {
			log.info("消息参数1：" + header.toString());
			log.info("消息参数2：" + tail.toString());
		}

		return templateArgs;
	}

	/**
	 * 构造参数中的List参数
	 * 
	 * @param str
	 * @param props
	 * @param key
	 * @return
	 */
	public List<String> getParmList(String str, Properties props, String key) {

		String value = (String) props.get(key);

		String[] paramArr = value.split(LIST_PREFIX);

		List<String> list = new ArrayList<String>();

		for (String param : paramArr) {
			if (StringUtils.isEmpty(param)) {
				list.add(param);
			}
		}
		return list;
	}

	/**
	 * 计算字符长度
	 * 
	 * @param content
	 * @return
	 */
	private int getContentLen(String content) {
		return content.getBytes().length;
	}

}
