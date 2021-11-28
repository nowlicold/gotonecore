/*
 * Bench.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.validator;
import com.bench.lang.base.email.utils.EmailUtils;
import com.bench.lang.base.string.utils.StringUtils;
import com.yuan.gotonecore.common.GotoneCoreModel;
import com.yuan.gotonecore.common.MailModel;
import com.yuan.gotonecore.common.enums.ErrorCodeEnum;
import com.yuan.gotonecore.common.exceptions.GotoneCoreException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.Email;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.stereotype.Service;

/**
 * 邮件业务验证器
 * 
 * @author zouyuxia
 *
 * @version $Id: MailValidator.java, v 0.1 2017年2月27日 上午11:15:36 zouyuxia Exp $
 */
@Service
@Slf4j
public class MailValidator extends AbstractValidator {

	/** 替代参数间隔符 */
	private static final String INVALID_CHAR = "∈";

	/** 入参间隔符 */
	public static final String PREFIX = "^";

	/** EMAIL最大长度 100 */
	public static final int email_legth_max = 100;

	/** EMAIL最小长度 4 */
	public static final int email_legth_min = 4;

	/** 邮件接收人列表的最大长度 */
	public static final int email_receiver_max = 2500;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.Bench.gotone.core.service.validator.Validator#validate(com.Bench.
	 * gotone.common.service.message.GotoneMessage)
	 */
	public void validate(GotoneCoreModel gotoneModel) throws GotoneCoreException {
		MailModel mailModel = (MailModel) gotoneModel;
		// 邮件摸板ID
		if (mailModel.getMailConfig() == null) {
			log.error("邮件模板未指定");
			throw new GotoneCoreException(ErrorCodeEnum.MAIL_ID_VALID.errorCode());
		}
		// 邮件地址检查
		validateAddress(mailModel.getReceiver());
		if (log.isInfoEnabled()) {
			log.info("收件地址：" + mailModel.getReceiver() + " userId: " + mailModel.getUserId());
		}
	}

	/**
	 * 邮箱地址校验
	 * 
	 * @param address
	 */
	public void validateAddress(String address) throws GotoneCoreException {
		// step 1: 邮件地址设置为空
		if (StringUtils.isEmpty(address)) {
			log.error("邮件地址非法！");
			throw new GotoneCoreException(ErrorCodeEnum.MAIL_ADDR_INVALID.errorCode());
		}

		// step 2: 验证邮件接收人列表长度
		if (address.getBytes().length >= email_receiver_max) {
			throw new GotoneCoreException(ErrorCodeEnum.MAIL_ADDR_OVERFLOW.errorCode(), "邮件接收人列表超出沟通平台可处理长度："
					+ email_receiver_max + ",mailReciver=" + address);
		}

		String[] addrList = address.split(",");
		// step 3: 邮件地址中只有间隔符的情况，抛异常出去
		if (addrList.length <= 0) {
			log.error("邮件地址非法！");
			throw new GotoneCoreException(ErrorCodeEnum.MAIL_ADDR_INVALID.errorCode());
		}
		// step 4: 校验单个邮箱地址
		for (String addr : addrList) {
			validSingleAddress(addr);
		}
	}

	/**
	 * 校验邮箱地址
	 * 
	 * @param addr
	 */
	private void validSingleAddress(String addr) throws GotoneCoreException {

		// 邮件地址长度检查
		if ((addr.length() < email_legth_min) || (addr.length() > email_legth_max)) {
			throw new GotoneCoreException(ErrorCodeEnum.MAIL_ADDR_INVALID.errorCode(), "邮件地址长度不在允许范围（最大长度：100，最小长度：4）！"
					+ addr);
		}
		// 验证邮件地址

		if (!emailFormat(addr)) {
			throw new GotoneCoreException(ErrorCodeEnum.MAIL_ADDR_INVALID.errorCode(), "邮件地址非法！" + addr);
		}
	}

	/**
	 * 基本类型判断
	 * 
	 * @param clz
	 * @return
	 */
	public static boolean isWrapClass(Class<?> clz) {
		try {
			return ((Class<?>) clz.getField("TYPE").get(null)).isPrimitive();
		} catch (Exception e) {
			return false;
		}
	}
	public static boolean emailFormat(String email) {
		boolean tag = true;
		if (!email.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
			tag = false;
		}
		return tag;
	}
}
