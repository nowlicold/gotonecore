/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.service.mail.impl;

import com.bench.lang.base.string.utils.StringUtils;
import com.yuan.gotonecore.service.mail.RegisterKeyComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author cold
 * 
 * @version $Id: RegisterKeyComponentImpl.java, v 0.1 2011-1-28 上午11:27:37 cold Exp $
 */
@Service
public class RegisterKeyComponentImpl implements RegisterKeyComponent {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bench.app.gotone.core.service.client.RegisterKeyComponent#validateKey (java.lang.String, java.lang.String)
	 */
	public boolean validateKey(String key, String configName) {
		// TODO Auto-generated method stub
		return StringUtils.isNotEmpty(key) && StringUtils.equals(key, StringUtils.EMPTY_STRING);
	}

}
