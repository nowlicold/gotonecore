package com.yuan.gotonecore.service.user;

import com.bench.common.model.PageVO;
import com.yuan.gotonecore.api.model.User;
import com.yuan.gotonecore.api.user.request.UserSearchRequest;

/**
 * @className UserQueryComponent
 * @autor cold
 * @DATE 2021/6/18 1:55
 **/
public interface UserQueryComponent {
    public PageVO<User> search(UserSearchRequest request);
}
