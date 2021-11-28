/**
 * BenchCode.com Inc.
 * Copyright (c) 2005-2009 All Rights Reserved.
 */
package com.yuan.gotonecore.common.comparator;


import com.yuan.gotonecore.common.SmsChannelConfig;

import java.util.Comparator;

/**
 * 短信通道权重按大到小排序
 * 
 * @author cold
 * 
 * @version $Id: SmsChannelConfigByWeightComparator.java, v 0.1 2014-6-19
 *          上午11:02:47 cold Exp $
 */
public class SmsChannelConfigByWeightComparator implements Comparator<SmsChannelConfig> {

	public static final SmsChannelConfigByWeightComparator INSTANCE = new SmsChannelConfigByWeightComparator();

	public int compare(SmsChannelConfig o1, SmsChannelConfig o2) {
		// TODO Auto-generated method stub
		return o1.getWeight() - o2.getWeight();
	}
}
