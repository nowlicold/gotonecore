package com.yuan.gotonecore.common.mail;


import com.yuan.gotonecore.common.enums.MailUserConfigStatusEnum;
import lombok.Data;

import java.util.Date;

/**
 * 邮件发送用户配置
 * 
 * @author cold
 * 
 * @version $Id: MailUserConfig.java, v 0.1 2010-12-13 下午03:54:28 cold Exp $
 */
@Data
public class MailUserConfig {

	/**
	 * 主键，Pk
	 */
	private Integer id;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 发送人地址
	 */
	private String fromAddr;
	
	/**
	 * 发件人用户名：用于发件验证
	 */
	private String fromUserword;

	/**
	 * 发送服务器Id
	 */
	private long mailServerId;;

	/**
	 * 发送人姓名
	 */
	private String fromName;

	/**
	 * 修改时间
	 */
	private Date gmtModified;

	/**
	 * 创建时间
	 */
	private Date gmtCreate;

	/**
	 * 用户类型，个性值设置
	 */
	private String userType;

	/**
	 * 状态
	 */
	private MailUserConfigStatusEnum status;

	/**
	 * 服务端是否有效，
	 */
	private boolean serversideEnabled;

	/**
	 * 服务端无效原因
	 */
	private String serversideDisabledReason;


}
