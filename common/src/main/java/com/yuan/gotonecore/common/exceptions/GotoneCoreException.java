/*
 * Bench.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.common.exceptions;

import com.bench.common.error.ErrorCode;
import com.bench.common.exception.BenchException;
import com.bench.common.exception.BenchRuntimeException;

/**
 * 
 * 通过在异常中设置Error对象来判断处理的结果！
 * <p>
 * <code>GotoneResultEnum</code>只是做一些辅助性的说明
 * </p>
 * 
 * @author cold
 * 
 * @version $Id$
 */
public class GotoneCoreException extends BenchException {

	private static final long serialVersionUID = 6687164311142885369L;

	public GotoneCoreException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public <E extends BenchException> GotoneCoreException(E exception) {
		super(exception);
		// TODO Auto-generated constructor stub
	}

	public <E extends BenchRuntimeException> GotoneCoreException(E exception) {
		super(exception);
		// TODO Auto-generated constructor stub
	}

	public GotoneCoreException(ErrorCode errorCode, String message, Throwable throwable) {
		super(errorCode, message, throwable);
		// TODO Auto-generated constructor stub
	}

	public GotoneCoreException(ErrorCode errorCode, String message) {
		super(errorCode, message);
		// TODO Auto-generated constructor stub
	}

	public GotoneCoreException(ErrorCode errorCode, Throwable throwable) {
		super(errorCode, throwable);
		// TODO Auto-generated constructor stub
	}

	public GotoneCoreException(ErrorCode errorCode) {
		super(errorCode);
		// TODO Auto-generated constructor stub
	}

	public <E extends BenchException> GotoneCoreException(String message, E exception) {
		super(message, exception);
		// TODO Auto-generated constructor stub
	}

	public <E extends BenchRuntimeException> GotoneCoreException(String message, E exception) {
		super(message, exception);
		// TODO Auto-generated constructor stub
	}

}