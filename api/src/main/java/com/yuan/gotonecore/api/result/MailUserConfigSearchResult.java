package com.yuan.gotonecore.api.result;

import com.bench.common.model.PageVO;
import com.yuan.gotonecore.common.mail.MailUserConfig;
import lombok.Data;
@Data
public class MailUserConfigSearchResult {


	/**
	 * 分页信息
	 */
	private PageVO<MailUserConfig> page;



}
