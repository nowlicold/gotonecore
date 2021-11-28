/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.sms.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.PageList;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bench.lang.base.object.utils.ObjectUtils;
import com.bench.common.model.PageVO;
import com.yuan.gotonecore.api.sms.model.SmsOutHis;
import com.yuan.gotonecore.api.sms.request.SmsOutHisQueryRequest;
import com.yuan.gotonecore.api.sms.result.SmsOutHisQueryResult;
import com.yuan.gotonecore.repository.entity.SmsOutHisDO;
import com.yuan.gotonecore.repository.entity.UserDO;
import com.yuan.gotonecore.repository.mapper.SmsOutHisMapper;
import com.yuan.gotonecore.service.SmsOutHisQueryComponent;
import com.yuan.gotonecore.service.sms.SmsOutHisConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @author fangbianmian
 *
 * @version $Id: SmsOutHisQueryComponentImpl.java, v 0.1 2017年2月24日 上午10:47:09
 *          Administrator Exp $
 */
@Service
public class SmsOutHisQueryComponentImpl implements SmsOutHisQueryComponent {

	/**
	 * 已发送短信历史Mapper
	 */
	@Autowired
	private SmsOutHisMapper smsOutHisMapper;


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotonecore.core.service.sms.SmsOutHisQueryComponent#search
	 * (com
	 * .bench.app.gotonecore.common.service.facade.request.SmsOutHisQueryRequest
	 * )
	 */
	public SmsOutHisQueryResult search(SmsOutHisQueryRequest request) {
		Page<SmsOutHisDO> page = new Page<>(request.getCurrent(), request.getSize());

		List<SmsOutHisDO> pageList = smsOutHisMapper.search(request.getReceiver(), request.getUserId(), ObjectUtils.toString(request.getStatus()),
				page);
		page.setRecords(pageList);

		PageVO<SmsOutHis> pageVOList = SmsOutHisConvert.convertPage(page);
		SmsOutHisQueryResult SmsOutHisQueryResult = new SmsOutHisQueryResult();
		SmsOutHisQueryResult.setPage(pageVOList);

		return SmsOutHisQueryResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotonecore.core.service.sms.SmsOutHisQueryComponent#queryById
	 * (long)
	 */
	public SmsOutHis queryById(long id) {
		return SmsOutHisConvert.convert(smsOutHisMapper.selectById(id));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bench.app.gotonecore.core.service.sms.SmsOutHisQueryComponent#
	 * queryByUserId(java.lang.String)
	 */
	public List<SmsOutHis> queryByUserId(String userId) {
		return SmsOutHisConvert.convertList(smsOutHisMapper.selectByUserId(userId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bench.app.gotonecore.core.service.sms.SmsOutHisQueryComponent#queryByIds
	 * (java.util.List)
	 */
	public List<SmsOutHis> queryByIds(List<Long> ids) {
		return SmsOutHisConvert.convertList(smsOutHisMapper.selectByIds(ids));
	}
}
