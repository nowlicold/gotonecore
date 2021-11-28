/*
 * Bench.com Inc.
 * Copyright (c) 2004-2005 All Rights Reserved.
 */
package com.yuan.gotonecore.common.exceptions;

/**
 * 打包异常处理类
 * 
 * @author min.weixm
 *
 * @version $Id: PacketException.java, v 0.1 2009-9-16 下午02:35:58 min.weixm Exp $
 */
public class PacketException extends Exception {
    /** serialVersionUID */
    private static final long serialVersionUID = -5862929872254867784L;

    /**
     * PacketException
     */
    public PacketException() {
    }

    /**
     * PacketException
     * 
     * @param s
     */
    public PacketException(String s) {
        super(s);
    }

    /**
     * PacketException
     * 
     * @param e
     */
    public PacketException(Exception e) {
        super(e);
    }

    /**
     * PacketException
     * 
     * @param s
     * @param e
     */
    public PacketException(String s, Exception e) {
        super(s, e);
    }
}
