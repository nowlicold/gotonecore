package com.yuan.gotonecore.service.sms.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bench.cache.local.AbstractGmtModifiedRefreshableCacheComponent;
import com.bench.lang.base.array.utils.ArrayUtils;
import com.bench.lang.base.list.utils.ListUtils;
import com.bench.lang.base.object.utils.ObjectUtils;
import com.bench.lang.base.string.utils.StringUtils;
import com.bench.common.model.PageVO;
import com.yuan.gotonecore.api.model.User;
import com.yuan.gotonecore.api.sms.model.SmsConfig;
import com.yuan.gotonecore.api.sms.request.SmsConfigQueryRequest;
import com.yuan.gotonecore.api.sms.result.SmsConfigPageQueryResult;
import com.yuan.gotonecore.repository.entity.SmsConfigDO;
import com.yuan.gotonecore.repository.entity.UserDO;
import com.yuan.gotonecore.repository.mapper.SmsConfigMapper;
import com.yuan.gotonecore.service.sms.SmsConfigConvert;
import com.yuan.gotonecore.service.sms.SmsConfigQueryComponent;
import com.yuan.gotonecore.service.user.UserConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @className SmsConfigQueryComponentImpl
 * @autor cold
 * @DATE 2021/6/20 0:22
 **/
@Service
public class SmsConfigQueryComponentImpl extends AbstractGmtModifiedRefreshableCacheComponent<SmsConfig, Long> implements SmsConfigQueryComponent {
	@Autowired
	private SmsConfigMapper smsConfigMapper;

	@Override
	public SmsConfigPageQueryResult search(SmsConfigQueryRequest searchRequest) {
		SmsConfigPageQueryResult result = new SmsConfigPageQueryResult();
		Page<SmsConfigDO> page = new Page(searchRequest.getCurrent(), searchRequest.getSize());

		List<SmsConfigDO> smsConfigDOList = smsConfigMapper.search(searchRequest.getId(), searchRequest.getContent(), searchRequest.getConfigId(),
				ObjectUtils.toString(searchRequest.getSendChannel()), searchRequest.getBeginModifiedDate(), searchRequest.getEndModifiedDate(), page);
		page.setRecords(smsConfigDOList);
		PageVO<SmsConfig> pageVO = SmsConfigConvert.convertPage(page);
		result.setPage(pageVO);
		return result;
	}

	@Override
	public SmsConfig getById(long id) {
		return SmsConfigConvert.convert(smsConfigMapper.selectById(id));
	}

	@Override
	public SmsConfig getByConfigName(String configName) {
		return SmsConfigConvert.convert(smsConfigMapper.selectByConfigName(configName));
	}

	@Override
	public SmsConfig getCachedByConfigName(String configName) {
		Optional<SmsConfig> smsConfig = super.getAllEnabled().stream().filter(sc -> StringUtils.equals(configName,sc.getConfigName())).findFirst();
		return smsConfig.get();

	}

	@Override
	public SmsConfig getCachedById(long id) {
		return super.getObject(id);
	}

	@Override
	public List<SmsConfig> getCachedByIds(List<Long> ids) {
		List<SmsConfig> returnList = new ArrayList<>();
		if(ListUtils.isEmpty(ids)){
			return returnList;
		}
		super.getAllEnabled().stream().forEach(smsConfig -> {
			if(ListUtils.contains(ids,smsConfig.getId())){
				returnList.add(smsConfig);
			}
		});
		return returnList;
	}

	@Override
	protected List<SmsConfig> loadAll() {

		return SmsConfigConvert.convertList(this.smsConfigMapper.selectAll());
	}

	@Override
	protected List<SmsConfig> loadLargeThan(Date maxRefreshCompareValue) {
		return SmsConfigConvert.convertList(smsConfigMapper.selectGreaterThanModifiedDate(maxRefreshCompareValue));

	}
}
