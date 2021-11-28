package com.yuan.gotonecore.common.enums;

import com.bench.common.enums.EnumBase;

/**
 * 邮件内容生成类型
 * 
 * @author huasheng
 *
 * @version $Id: MailBodyPatternTypeEnum.java, v 0.1 2016年7月29日 下午12:20:41 huasheng Exp $
 */
public enum MailBodyPatternTypeEnum implements EnumBase{
		
	BY_CONTENT("自带内容"),
	
	BY_TEMPLATE("模板渲染"), ;

	private String message;
	
	private MailBodyPatternTypeEnum(String message){
		this.message = message;
	}

	public String message() {
		// TODO Auto-generated method stub
		return message;
	}

	public Number value() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
