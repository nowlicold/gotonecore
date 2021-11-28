/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail;

import com.bench.common.model.PageVO;
import com.yuan.gotonecore.api.request.MailUserConfigSearchRequest;
import com.yuan.gotonecore.common.mail.MailUserConfig;

/**
 * 邮件发送用户配置查询组件
 * 
 * @author cold
 * 
 * @version $Id: MailUserConfigManageComponent.java, v 0.1 2012-10-25 下午6:16:40
 *          cold Exp $
 */
public interface MailUserConfigQueryComponent {

	/**
	 * 查询邮件用户配置
	 * 
	 * @param searchRequest
	 * @return
	 */
	public PageVO<MailUserConfig> search(MailUserConfigSearchRequest searchRequest);

	/**
	 * 根据活动ID，接收方邮件地址，选择一个发送用户配置
	 * 
	 * @param activityId
	 * @param receiverAddress
	 * @return
	 */
	public MailUserConfig selectMailUserConfig(long activityId, String receiverAddress);
}
