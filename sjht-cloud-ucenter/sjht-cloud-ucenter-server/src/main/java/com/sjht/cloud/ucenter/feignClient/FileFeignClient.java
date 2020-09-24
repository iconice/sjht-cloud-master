package com.sjht.cloud.ucenter.feignClient;

import com.sjht.cloud.framework.common.constant.SjhtServerListConstant;
import com.sjht.cloud.framework.common.entity.response.ResponseDataResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ***************************************************
 * @ClassName FileFeignClient
 * @Description 文件调用
 * @Author maojianyun
 * @Date 2020/1/7 18:06
 * @Version V1.0
 * ****************************************************
 **/
@FeignClient(SjhtServerListConstant.SJHT_CLOUD_FILESYSTEM_SERVER)
public interface FileFeignClient {

    @GetMapping("/file/file/getUrl")
    public ResponseDataResult getUrl(@RequestParam("id") long id);
}
