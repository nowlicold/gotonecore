package com.yuan.gotonecore.api.user;

import com.bench.common.model.PageVO;
import com.yuan.gotonecore.api.model.User;
import com.yuan.gotonecore.api.user.request.UserSearchRequest;
import org.springframework.stereotype.Component;

import com.bench.common.model.JsonResult;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * @className UserApiFallback
 * @autor cold
 * @DATE 2021/5/9 15:21
 **/
@Component
@Slf4j
public class UserQueryApiFallback implements FallbackFactory<UserQueryApi> {
    @Override
    public UserQueryApi create(Throwable cause) {

        return new UserQueryApi() {
            @Override
            public JsonResult<PageVO<User>> search(UserSearchRequest request) {
                log.error("rpcError,method:search,request:{}", request);
                return JsonResult.rpcError("调用Search接口异常");
            }
        };
    }
}
