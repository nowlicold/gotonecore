package com.yuan.gotonecore.api.result;

import com.bench.common.model.PageVO;
import com.yuan.gotonecore.common.mail.MailServerConfig;
import lombok.Data;

@Data
public class MailServerConfigSearchResult {
	/**
	 * 分页信息
	 */
	private PageVO<MailServerConfig> page;


}
