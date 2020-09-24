package com.sjht.cloud.auth;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;

/**
 * ***************************************************
 *
 * @ClassName TestJwt
 * @Description jwt令牌测试
 * @Author maojianyun
 * @Date 2019/12/4 13:47
 * @Version V1.0
 * ****************************************************
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestJwt {

    //创建jwt令牌
    @Test
    public void testCreateJwt(){
        //密钥库文件
        String keystore = "xc.keystore";
        //密钥库的密码
        String keystore_password = "xuechengkeystore";
        //密钥库文件路径
        ClassPathResource classPathResource = new ClassPathResource(keystore);
        //密钥别名
        String alias  = "xckey";
        //密钥的访问密码
        String key_password = "xuecheng";
        //密钥工厂
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(classPathResource,keystore_password.toCharArray());
        //密钥对（公钥和私钥）
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(alias, key_password.toCharArray());
        //获取私钥
        RSAPrivateKey aPrivate = (RSAPrivateKey) keyPair.getPrivate();
        //jwt令牌的内容
        Map<String,String> body = new HashMap<>();
        body.put("name","itcast");
        String bodyString = JSON.toJSONString(body);
        //生成jwt令牌
        Jwt jwt = JwtHelper.encode(bodyString, new RsaSigner(aPrivate));
        //生成jwt令牌编码
        String encoded = jwt.getEncoded();
        System.out.println(encoded);

    }

    //校验jwt令牌
    @Test
    public void testVerify(){
        //公钥
        String publickey = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnASXh9oSvLRLxk901HANYM6KcYMzX8vFPnH/To2R+SrUVw1O9rEX6m1+rIaMzrEKPm12qPjVq3HMXDbRdUaJEXsB7NgGrAhepYAdJnYMizdltLdGsbfyjITUCOvzZ/QgM1M4INPMD+Ce859xse06jnOkCUzinZmasxrmgNV3Db1GtpyHIiGVUY0lSO1Frr9m5dpemylaT0BV3UwTQWVW9ljm6yR3dBncOdDENumT5tGbaDVyClV0FEB1XdSKd7VjiDCDbUAUbDTG1fm3K9sx7kO1uMGElbXLgMfboJ963HEJcU01km7BmFntqI5liyKheX+HBUCD4zbYNPw236U+7QIDAQAB-----END PUBLIC KEY-----";
        //jwt令牌
        String jwtString = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJpdGNhc3QiLCJzY29wZSI6WyJhcHAiXSwiYXRpIjoiMTBjYTY0YzQtOWZmMi00MGY2LWFhNWYtYjNhMGZmZTcwM2VhIiwibmFtZSI6Iml0Y2FzdCIsImhlYWRVcmwiOm51bGwsImlkIjoiMTIwODk3Mjk0NjU5NzQ5ODk5MSIsInVzZXJUeXBlIjoiMSIsImV4cCI6MTU3NzIxMTk5OCwib3JnSWQiOiIxIiwiYXV0aG9yaXRpZXMiOlsidXNlcjpsaXN0Iiwicm9sZXMiLCJ1c2VyOmJhdGNoRGVsZXRlIiwicGVybWlzc2lvbjphZGQiLCJvbmxpbmVVc2VyOmtpY2tvdXQiLCJyb2xlOmFkZCIsImRhdGFiYXNlIiwicGVybWlzc2lvbjpkZWxldGUiLCJvbmxpbmVVc2VyOmJhdGNoS2lja291dCIsInBlcm1pc3Npb25zIiwicm9sZTphc3NpZ25QZXJtcyIsInJvbGU6bGlzdCIsInJvbGU6ZGVsZXRlIiwicGVybWlzc2lvbjplZGl0IiwidXNlcjphZGQiLCJ1c2VyOmRlbGV0ZSIsInBlcm1pc3Npb246bGlzdCIsInJvbGU6YmF0Y2hEZWxldGUiLCJvbmxpbmVVc2VyOmxpc3QiLCJvbmxpbmVVc2VycyIsIndvcmtkZXN0IiwiaWNvbnMiLCJ1c2VycyIsInVzZXI6YXNzaWduUm9sZSIsInVzZXI6ZWRpdCIsInJvbGU6ZWRpdCJdLCJqdGkiOiJjNDE1MjI3OS1iYjg5LTRmMWYtOGY2Yi04ZDc0ZmYzYWQ5YzciLCJjbGllbnRfaWQiOiJYY1dlYkFwcCJ9.ibspbIAKOnewNZAXNQ1lQyMm4K1GnTsu_DuNswuzoAUTigvzAr76dhOM_-whb79ama6aWD_GXsC9-nIcVfNXjyQcyE4XK09PBa8evGQkn1B-lkUvBaocUOmZtAYYPGpx_jM3EzqsZhmX30r5VUBd5SwVmk_cHOQ91z9Uak-z8Wh8aRSnOnbW05xs2Uj1GHWWJYBFMom4fu-zSZwrn4N49BikKPGD4JNsrIx4t-oG7ZBBWMDHVde98L1X91vN_iLzglMKLIo8zK6RGljC7GGtKi_xBT9lG2DklJByBHqV2lWo5kKXenvz3KWcTJyUxZEL38QNpPw4X6ujfCYbrEYV5A";
        //校验jwt令牌
        Jwt jwt = JwtHelper.decodeAndVerify(jwtString, new RsaVerifier(publickey));
        //拿到jwt令牌中自定义的内容
        String claims = jwt.getClaims();
        System.out.println(claims);
    }
}

