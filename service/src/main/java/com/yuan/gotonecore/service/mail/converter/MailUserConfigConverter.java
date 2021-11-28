package com.yuan.gotonecore.service.mail.converter;

import com.bench.runtime.convert.ConverterManager;
import com.yuan.gotonecore.common.mail.MailUserConfig;
import com.yuan.gotonecore.repository.entity.MailUserConfigDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 邮件用户配置转换类
 * 
 * @author cold
 * 
 * @version $Id: MailUserConfigConverter.java, v 0.1 2012-10-26 下午2:48:59
 *          cold Exp $
 */
@Service
public class MailUserConfigConverter {

	@Autowired
	private ConverterManager converterManager;

	public MailUserConfig convert(MailUserConfigDO configDO) {
		MailUserConfig mc = new MailUserConfig();
		converterManager.convert(configDO, mc);
		return mc;
	}

	public List<MailUserConfig> convert(List<MailUserConfigDO> mailUserConfigDOList){
		List<MailUserConfig> returnList = new ArrayList<>();
		mailUserConfigDOList.forEach(d ->{
			returnList.add(convert(d));
		});
		return returnList;
	}
}
