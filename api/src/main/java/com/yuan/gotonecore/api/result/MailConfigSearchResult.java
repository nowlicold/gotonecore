package com.yuan.gotonecore.api.result;


import com.bench.common.model.PageVO;
import com.yuan.gotonecore.common.mail.MailSimpleConfig;
import lombok.Data;

@Data
public class MailConfigSearchResult {


	/**
	 * 分页信息
	 */
	private PageVO<MailSimpleConfig> page;


}
