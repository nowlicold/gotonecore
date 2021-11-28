/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service;

import com.yuan.gotonecore.api.sms.model.SmsOutHis;
import com.yuan.gotonecore.api.sms.request.SmsOutHisQueryRequest;
import com.yuan.gotonecore.api.sms.result.SmsOutHisQueryResult;

import java.util.List;

/**
 * 已发送短信列表component
 * 
 * @author cold
 *
 * @version $Id: SmsOutHisQueryComponent.java, v 0.1 2017年2月23日 下午7:05:27
 *          Administrator Exp $
 */
public interface SmsOutHisQueryComponent {

	/**
	 * 根据条件查询短信息历史发送记录
	 * 
	 * @param request
	 * @return
	 */
	SmsOutHisQueryResult search(SmsOutHisQueryRequest request);

	/**
	 * 根据ID查询短信历史数据
	 * 
	 * @param id
	 * @return
	 */
	SmsOutHis queryById(long id);

	/**
	 * 根据ID查询短信历史数据
	 * 
	 * @param id
	 * @return
	 */
	List<SmsOutHis> queryByIds(List<Long> ids);

	/**
	 * 根据用户号查询
	 * 
	 * @param userId
	 * @return
	 */
	List<SmsOutHis> queryByUserId(String userId);
}
