/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail.converter;
import com.bench.lang.base.bool.utils.BooleanUtils;
import com.bench.runtime.convert.ConverterManager;
import com.yuan.gotonecore.common.mail.MailConfig;
import com.yuan.gotonecore.repository.entity.MailConfigDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author cold
 * 
 * @version $Id: MailConfigConverter.java, v 0.1 2012-10-30 上午10:27:11 cold
 *          Exp $
 */
@Service
public class MailConfigConverter {

	@Autowired
	private ConverterManager converterManager;

	public MailConfig convert(MailConfigDO configDO) {
		MailConfig mc = new MailConfig();
		converterManager.convert(configDO, mc);
		mc.setEnabled(BooleanUtils.toBoolean(configDO.getEnabled()));
		return mc;
	}

}
