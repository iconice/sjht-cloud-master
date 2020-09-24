package com.sjht.cloud.auth.feignClient;

import com.sjht.cloud.framework.common.constant.SjhtServerListConstant;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import com.sjht.cloud.framework.common.entity.response.ResponseResult;
import com.sjht.cloud.ucenter.api.dto.RegisteredDto;
import com.sjht.cloud.ucenter.api.dto.UserDto;
import com.sjht.cloud.ucenter.api.vo.AuthUserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ***************************************************
 * @ClassName UserFeignClient
 * @Description user的远程调用
 * @Author maojianyun
 * @Date 2019/12/5 22:27
 * @Version V1.0
 * ****************************************************
 **/
@FeignClient(SjhtServerListConstant.SJHT_CLOUD_UCENTER_SERVER)
public interface UserFeignClient {

    @GetMapping("/ucenter/user/getUserInfoByUserNmae")
    public ResponseDataResult<AuthUserVo> getUserInfoByUserNmae(@RequestParam("userName") String userName);

    @PostMapping("/ucenter/user/registered")
    public ResponseResult registered(@RequestBody RegisteredDto registeredDto);

    @PostMapping("/ucenter/user/createUser")
    public ResponseResult createUser(@RequestBody UserDto userDto);
}
