package com.yuan.gotonecore.repository.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.gotonecore.repository.entity.UserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author cold
 * @since 2021-06-18
 */
public interface UserMapper extends BaseMapper<UserDO> {
	public List<UserDO> search(@Param("id") Integer id, @Param("name")String name, @Param("ids")List<Integer> ids, @Param("orderBy")String orderBy,@Param("page") Page<UserDO> page);
}
