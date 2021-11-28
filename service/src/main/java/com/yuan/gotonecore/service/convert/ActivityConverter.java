/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.convert;
import com.bench.runtime.convert.ConverterManager;
import com.yuan.gotonecore.common.Activity;
import com.yuan.gotonecore.repository.entity.ActivityDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @author cold
 * 
 * @version $Id: ActivityConverter.java, v 0.1 2012-10-26 下午5:21:58 cold Exp
 *          $
 */
@Component
public class ActivityConverter {

	@Autowired
	private ConverterManager converterManager;

	public Activity convert(ActivityDO dataDO) {
		Activity model = new Activity();
		converterManager.convert(dataDO, model);
		return model;
	}
}
