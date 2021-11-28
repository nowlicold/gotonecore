/*
 * Bench.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.validator;

import com.yuan.gotonecore.common.GotoneCoreModel;
import com.yuan.gotonecore.common.exceptions.GotoneCoreException;

/**
 * 用于邮件、QQ、MSN消息的业务验证和参数验证
 * 
 * 1. 此验证器在验证过程中所需的参数验证对象GotoneMessage可从context中读取
 * 
 * 2. 业务验证时所需要的验证对象GotoneModel可从context中读取
 * 
 * 说明：由于业务验证和参数验证所处的阶段不同，在参数验证阶段尚没有GotoneModel对象，
 * 而从目前情况来看要做业务验证的参数需求也不尽相同，因此为了统一，出于需要什么
 * 传什么的原则，对于所有所需的参数都统一从context中获取。保证接口一致性
 * 
 * @author zouyuxia
 *
 * @version $Id: Validator.java, v 0.1 2017年2月27日 上午11:15:22 zouyuxia Exp $
 */
public interface Validator {
	/**
	 * 执行控制规则。
	 */
	void validate(GotoneCoreModel model) throws GotoneCoreException;

}
