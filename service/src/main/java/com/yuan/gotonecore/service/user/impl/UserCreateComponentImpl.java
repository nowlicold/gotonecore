package com.yuan.gotonecore.service.user.impl;
import com.yuan.gotonecore.api.user.request.UserCreateRequest;
import com.yuan.gotonecore.api.user.result.UserCreateResult;
import com.yuan.gotonecore.common.enums.GotoneCoreErrorCodeEnum;
import com.yuan.gotonecore.repository.entity.UserDO;
import com.yuan.gotonecore.repository.mapper.UserMapper;
import com.yuan.gotonecore.service.user.UserCreateComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 @className UserCreateComponentImpl
 @autor cold
 @DATE 2021/6/18 1:50
 **/
@Service
@Slf4j
public class UserCreateComponentImpl implements UserCreateComponent {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserCreateResult create(UserCreateRequest request) {
        UserCreateResult result = new UserCreateResult();
        //默认是成功的
        result.setSuccess(true);

        UserDO userDO = new UserDO();
        userDO.setName(request.getName());
        int resultCount = userMapper.insert(userDO);
        if(resultCount <= 0){
            result.setSuccess(false);
            result.setErrorCode(GotoneCoreErrorCodeEnum.SYSTEM_ERROR.errorCode());
            return result;
        }
        result.setId(userDO.getId());
        return result;
    }
}
