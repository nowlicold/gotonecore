package com.yuan.gotonecore.api.model.enums;


import com.bench.common.enums.error.ErrorEnum;

/**
 * 错误代码
 *
 * @author cold
 * @version $Id: ErrorCodeEnum.java, v 0.1 2018年5月2日 下午8:00:55 cold Exp $
 */
public enum ErrorCodeEnum implements ErrorEnum {
	// *****************************公共信息【GOTONE】*****************************

	DATA_LOCK_FAILED("数据锁定失败"),

	SYSTEM_ERROR("系统错误"),

	PARAMETER_ERROR("缺少参数"),

	PARAMETER_MISSING("缺少参数"),

	ENV_ERROR("系统环境开关不可识别，可选参数如下：TEST_MODE(开发、测试模式), TEST_PRESS(压力测试模式), PRODUCTION(线上环境)"),

	TEMPLATE_NOT_FOUND("沟通velocity模板未找到"),

	MAIL_NOT_FOUND("邮件未找到"),

	MAIL_BODY_NOT_FOUND("邮件内容未找到"),

	MAIL_ID_VALID("邮件模板ID不可为空"),

	MAIL_ADDR_INVALID("邮件地址非法！"),

	MAIL_ADDR_OVERFLOW("邮件接收人列表超出沟通平台可处理长度！"),

	MAIL_MESSAGE_BODY_ERROR("邮件发送消息体构建失败！"),

	MAIL_CONFIG_NOT_EXISTS("邮件配置不存在或不可用"),

	MAIL_NOT_SUBJECT("无法确定邮件主题"),

	MAIL_CONFIG_EXISTED("邮件配置已经存在"),

	MAIL_USER_CONFIG_NOT_EXISTS("邮件发送配置不存在"),

	MAIL_USER_CONFIG_EXISTED("邮件用户配置已存在"),

	MAIL_SERVER_EXISTED("邮件发送服务器已存在"),

	MAIL_TEMPLATE_MERGE_ERROR("邮件模板参数替换出错"),

	MAIL_SEND_ERROR("邮件发送失败"),

	MAIL_OUT_NOT_EXISTS("邮件发送对象不存在"),

	MAIL_OUT_LOCK_FAILED("邮件发送锁定失败"),

	ACTIVITY_NOT_EXISTS("活动不存在"),

	ACTIVITY_EXISTED("活动已存在"),

	/**
	 * 客户端错误
	 */
	CLIENT_MISMATCH("客户端不匹配"),

	CLIENT_DEAD("客户端已死亡"),

	CLIENT_DISABLED("客户端被禁用"),

	CLIENT_NOT_FOUND("没有找到客户端"),

	CLIENT_REGISTER_KEY_ERROR("客户端注册KEY错误"),

	CLIENT_NO_REQUIRED("客户端号不能为空"),

	CLIENT_ID_REGISTERED("客户端ID已经被注册了"),

	CLIENT_SIGN_ERROR("客户端签名错误"),

	/*******************************
	 * 短信错误代码
	 ******************************/

	SMS_CHANNEL_CONFIG_NOT_FOUND("短信通道配置无法找到"),

	SMS_CONFIG_IDS_EMPTY("短信配置ids为空"),

	SMS_SEND_DUPLICATE_IN_INTERVAL_SECONDS("当前用户短信发送频率过高，请稍后再试"),

	SMS_MESSAGE_RENDER_ERROR("短信内容渲染错误"),

	SMS_CONFIG_NOT_FOUND("短息配置无法找到"),

	SMS_OUT_LOCK_FAILED("短信锁定失败"),

	SMS_OUT_HIS_LOCK_FAILED("短信发送历史锁定失败"),

	SMS_OUT_USER_MISMATCH("短信发送用户不匹配"),

	SMS_OUT_RECEIVER_MISMATCH("验证码手机号不匹配"),

	SMS_OUT_NOT_FOUND("短信无法找到"),

	SMS_OUT_NOT_SEND_YET("短信尚未发送"),

	SMS_OUT_BIZ_ID_MISMATCH("短信BizId不一致"),

	SMS_OUT_HIS_NOT_FOUND("短信发送历史无法找到"),

	SMS_OUT_ACK_CODE_TIME_OUT("短信验证码过期"),

	SMS_OUT_ACK_CODE_VALIDATE_TOO_MUCH("短信验证码验证次数超限"),

	SMS_OUT_ACK_CODE_VALIDATE_MISMATCH("短信验证码校验错误"),

	SMS_OUT_ACK_CODE_NOT_SUPPORT("不支持短信验证码"),

	SMS_OUT_SEND_TO_THRID_SERVER_ERROR("发送短信到第三方服务器错误"),

	TEXT_CONTENT_EXISTED("文本内容已存在"),

	TEXT_CONTENT_NOT_FOUND("文本内容未找到"),

	VALIDATE_CODE_NOT_FOUND("验证码无法找到"),

	VALIDATE_CODE_VALIDATED("验证码已验证过"),

	VALIDATE_CODE_MISMATCH("验证码不正确"),

	VALIDATE_CODE_EXPIRED("验证码过期"),

	VALIDATE_CODE_VALIDATE_TOO_MUCH("验证码验证次数超限"),

	WX_MSG_TYPE_UNKNOWN("微信消息类型未知"),

	WX_MSG_SAVE_HANDLER_NOT_FOUND("微信存储处理器无法找到"),

	SIGN_REQUIRED("sign不能为空"),

	SIGN_TYPE_ERROR("signType错误"),

	APP_SIGN_KEY_NOT_FOUND("app的signKey不存在"),

	APP_SIGN_KEY_DISABLED("app的signKey已禁用"),

	SIGN_ERROR("sign错误"),

	APP_CODE_REQUIRED("appCode不能为空"),

	APP_CODE_ERROR("appCode错误"),

	APP_CODE_NOT_ENABLED("appCode未启用"),

	SERVICE_NAME_ERROR("服务名错误"),

	MOBILE_CLIENT_SETTING_NOT_FOUND("移动客户端设置无法找到"),

	MOBILE_CLIENT_USER_LOGIN_SUCCESS_NOTIFY_EXPIRED("移动客户端会员登录成功通知已过期"),

	MOBILE_CLIENT_USER_LOGOUT_SUCCESS_NOTIFY_EXPIRED("移动客户端会员登出成功通知已过期"),

	MOBILE_CLIENT_SETTING_NOTICE_KEY_UPDATE_EXPIRED("移动客户端通知key更新已过期"),

	MOBILE_CLENT_USER_SETTING_NOT_FOUND("移动客户端设置无法找到"),

	MOBILE_CLIENT_PUSH_MSG_EXISTED("移动客户端推送消息已存在"),

	MOBILE_CLENT_PUSH_MSG_NOT_FOUND("移动客户端推送消息无法找到"),

	MOBILE_CLENT_PUSH_MSG_LOCK_FAILED("移动客户端推送消息锁定失败"),

	MOBILE_CLENT_PUSH_MSG_OVER_MAX_TRY_COUNT("移动客户端推送消息超过最大重试次数"),

	IP_NOT_VALID("ip不合法"),

	IP_IN_BLACK_LIST("ip被拉黑"),

	SMS_BLACK_LIST_NOT_EXIST("短信黑名单不存在"),;

	private String message;

	ErrorCodeEnum(String message) {
		this.message = message;
	}

	@Override
	public String message() {
		// TODO Auto-generated method stub
		return message;
	}

	@Override
	public Number value() {
		// TODO Auto-generated method stub
		return null;
	}

}
