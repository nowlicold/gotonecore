package com.yuan.gotonecore.service.user;

import java.util.List;

import com.yuan.gotonecore.api.model.User;
import com.yuan.gotonecore.repository.entity.UserDO;
import org.springframework.cglib.beans.BeanCopier;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.bench.common.model.PageVO;

/**
 * @className UserConvert
 * @autor cold
 * @DATE 2021/5/23 19:51
 **/
public class UserConvert {
    private static final BeanCopier ENTRY_TO_MODEL = BeanCopier
            .create(UserDO.class, User.class, false);
    private static final BeanCopier PAGE_TO_PAGEDO = BeanCopier
            .create(Page.class, PageVO.class, false);
    public static User convert(UserDO userDO) {
        User user = new User();
        ENTRY_TO_MODEL.copy(userDO, user, null);
        return user;
    }
    public static List<User> convertList(List<UserDO> userDOList) {
        List<User> userList = Lists.newArrayList();
        userDOList.forEach(userDO -> {
            userList.add(convert(userDO));
        });
        return userList;
    }
    public static PageVO<User> convertPage(Page<UserDO> page){
        return new PageVO<User>(convertList(page.getRecords()),page.getTotal(),page.getSize(),page.getPages(),page.getTotal());
    }

}
