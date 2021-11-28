package com.yuan.gotonecore.api.user;

import com.bench.common.model.JsonResult;
import com.yuan.gotonecore.api.user.request.UserCreateRequest;
import com.yuan.gotonecore.api.user.result.UserCreateResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @className UserCreateApi
 * @autor cold
 * @DATE 2021/6/18 2:09
 **/
@FeignClient(
        value = "userApi",
        url = "${rpc.gotonecore.url}",
        fallbackFactory = UserQueryApiFallback.class
)
public interface UserCreateApi {
    @PostMapping("/private/user/create")
    JsonResult<UserCreateResult> create(UserCreateRequest request);
}
