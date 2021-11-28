/*
 * Bench.com Inc.
 * Copyright (c) 2008-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.common.mail;

import lombok.Data;

import java.io.Serializable;

/**
 * Mail配置类。
 * 
 * @author min.weixm
 * 
 * @version $Id: Mail.java, v 0.1 2009-9-12 下午02:35:58 min.weixm Exp $
 */
@Data
public class MailConfig extends MailSimpleConfig implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2584708285000172702L;
	/**
	 * 内容
	 */
	private String content;



}
