package com.yuan.gotonecore.service.mail.converter;
import com.bench.runtime.convert.ConverterManager;
import com.yuan.gotonecore.common.mail.MailServerConfig;
import com.yuan.gotonecore.repository.entity.MailServerConfigDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 邮件配置服务器配置转换类
 * 
 * @author cold
 * 
 * @version $Id: MailServerConfigConverter.java, v 0.1 2012-10-26 下午2:48:59
 *          cold Exp $
 */
@Service
public class MailServerConfigConverter {

	@Autowired
	private ConverterManager converterManager;

	public MailServerConfig convert(MailServerConfigDO configDO) {
		MailServerConfig mc = new MailServerConfig();
		converterManager.convert(configDO, mc);
		return mc;
	}

	public List<MailServerConfig> convert(List<MailServerConfigDO> mailServerConfigDOList){
		List<MailServerConfig> returnList = new ArrayList<>();
		for(MailServerConfigDO mailServerConfigDO : mailServerConfigDOList){
			returnList.add(convert(mailServerConfigDO));
		}
		return returnList;
	}
}
