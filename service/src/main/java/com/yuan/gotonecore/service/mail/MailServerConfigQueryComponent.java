package com.yuan.gotonecore.service.mail;

import com.bench.common.model.PageVO;
import com.yuan.gotonecore.api.request.MailServerConfigSearchRequest;
import com.yuan.gotonecore.common.mail.MailServerConfig;

/**
 * 
 * 
 * @author cold
 * 
 * @version $Id: MailServerConfigQueryComponent.java, v 0.1 2012-10-26
 *          上午11:10:58 cold Exp $
 */
public interface MailServerConfigQueryComponent {

	/**
	 * 根据ID获取邮件服务器配置
	 * 
	 * @param id
	 * @return
	 */
	public MailServerConfig getById(long id);

	/**
	 * 得到缓存的邮件服务器配置
	 * 
	 * @param id
	 * @return
	 */
	public MailServerConfig getCachedMailServerConfig(long id);

	/**
	 * 刷新cache数据
	 */
	public void refreshCacheData();

	/**
	 * 查询邮件服务器配置
	 * 
	 * @param request
	 * @return
	 */
	public PageVO<MailServerConfig> search(MailServerConfigSearchRequest request);
}
