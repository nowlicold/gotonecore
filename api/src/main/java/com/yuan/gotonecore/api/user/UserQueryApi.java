package com.yuan.gotonecore.api.user;

import com.bench.common.model.JsonResult;
import com.bench.common.model.PageVO;
import com.yuan.gotonecore.api.model.User;
import com.yuan.gotonecore.api.user.request.UserSearchRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 */
@FeignClient(
        value = "userApi",
        url = "${rpc.gotonecore.url}",
        fallbackFactory = UserQueryApiFallback.class
)
public interface UserQueryApi {
    @PostMapping("/private/user/search")
    JsonResult<PageVO<User>> search(UserSearchRequest request);
}
