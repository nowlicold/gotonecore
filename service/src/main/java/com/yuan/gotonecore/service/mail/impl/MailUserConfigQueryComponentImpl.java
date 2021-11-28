/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail.impl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bench.common.model.PageVO;
import com.bench.lang.base.object.utils.ObjectUtils;
import com.bench.lang.base.string.utils.StringUtils;
import com.yuan.gotonecore.api.request.MailUserConfigSearchRequest;
import com.yuan.gotonecore.common.mail.MailUserConfig;
import com.yuan.gotonecore.repository.entity.MailUserConfigDO;
import com.yuan.gotonecore.repository.mapper.MailUserConfigMapper;
import com.yuan.gotonecore.service.mail.MailUserConfigQueryComponent;
import com.yuan.gotonecore.service.mail.converter.MailUserConfigConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * @author cold
 * 
 * @version $Id: MailUserConfigQueryComponentImpl.java, v 0.1 2012-10-26
 *          下午2:02:38 cold Exp $
 */
@Service
public class MailUserConfigQueryComponentImpl implements MailUserConfigQueryComponent {
	@Autowired
	private MailUserConfigMapper mailUserConfigMapper;
	@Autowired
	private MailUserConfigConverter mailUserConfigConverter;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotone.core.service.common.MailUserConfigQueryComponent
	 * #search(com.bench.app.gotone.common.service.facade.request.
	 * MailUserConfigSearchRequest)
	 */
	public PageVO<MailUserConfig> search(MailUserConfigSearchRequest searchRequest) {
		// TODO Auto-generated method stub
		Page<MailUserConfigDO> page = new Page<>(searchRequest.getCurrent(),searchRequest.getSize());

		List<MailUserConfigDO> mailUserConfigDOList = this.mailUserConfigMapper.search(searchRequest.getId(), searchRequest.getFromAddr(), searchRequest.getPassword(),
				searchRequest.getMailServerId(), searchRequest.getFromName(), ObjectUtils.toString(searchRequest.getStatus()), searchRequest.getUserType(),
				searchRequest.getServersideEnabled(), searchRequest.getBeginModifiedDate(), searchRequest.getEndModifiedDate(), page);

		PageVO<MailUserConfig> pageVO = new PageVO<>(mailUserConfigConverter.convert(mailUserConfigDOList),page.getCurrent(),page.getSize(),page.getPages(),page.getTotal());

		return pageVO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotone.core.service.common.MailUserConfigQueryComponent
	 * #selectMailUserConfig(long, java.lang.String)
	 */
	public MailUserConfig selectMailUserConfig(long activityId, String receiverAddress) {
		// TODO Auto-generated method stub
		// 获取Domain
		String receiverDomain = StringUtils.substringAfter(receiverAddress, "@");
		MailUserConfigDO mailUserConfigDO = this.mailUserConfigMapper.selectRandomByActivityIdAndDomainName(activityId, receiverDomain);
		if (mailUserConfigDO == null) {
			mailUserConfigDO = mailUserConfigMapper.selectRandomByActivityId(activityId);
		}
		return mailUserConfigDO == null ? null : mailUserConfigConverter.convert(mailUserConfigDO);
	}

}
