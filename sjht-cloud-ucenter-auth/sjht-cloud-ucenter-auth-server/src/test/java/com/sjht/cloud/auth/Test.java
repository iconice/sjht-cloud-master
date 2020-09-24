package com.sjht.cloud.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * ***************************************************
 *
 * @ClassName Test
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/12/5 19:33
 * @Version V1.0
 * ****************************************************
 **/
public class Test {


    public static void main(String[] args) {

        //原始密码
        String password = "XcWebApp";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //使用BCrypt加密，每次加密使用一个随机盐
        String encode = bCryptPasswordEncoder.encode(password);
        boolean matches = bCryptPasswordEncoder.matches(password, encode);
        System.out.println(encode);


//        String json = "{\"access_token\":\"07081367-c90d-4ec7-abc2-c060152c47f8\",\"jwt_token\":\"eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJpdGNhc3QiLCJzY29wZSI6WyJhcHAiXSwiYXRpIjoiMDcwODEzNjctYzkwZC00ZWM3LWFiYzItYzA2MDE1MmM0N2Y4IiwibmFtZSI6bnVsbCwiaGVhZFVybCI6bnVsbCwiaWQiOm51bGwsInVzZXJUeXBlIjpudWxsLCJleHAiOjE1NzU5ODgzMzIsIm9yZ0lkIjpudWxsLCJqdGkiOiI1Njk1N2QxYy0xMjdmLTQ0YzMtYjY4ZC0wYjU2NjkzNjM0MzEiLCJjbGllbnRfaWQiOiJYY1dlYkFwcCJ9.R_XJBiQjqYSm-FCSuuSRn332t16otXP21Gxf4TaiEsGhAOb6inwJB-XFPDEzm5lvcE6N5dyGSiWYzYwdPX7aHmTCyN8WKLzT42w8_DjlRnE37K2a--YXtAWdFj6XD21YAWTBKpkNZZM898l2DrbpHjhHLdZINoxnKczS1ZIr3cjcoeMmVscBZnCKY3rjnkoBVFC5VdGffh_Cl8fzXJ_U0RbskOK3zDVMDn29XBIS_EIQ9M8fzW8p6nxURF0eSvtYEigjEbfK4awybXkXQO5BbshfyWO42b7ZDgjU-uQRct_kiwsbsu1SHn3mEo9In-MBdwlfCOQ6njnmpYwwHW8FLQ\",\"refresh_token\":\"eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJpdGNhc3QiLCJzY29wZSI6WyJhcHAiXSwibmFtZSI6bnVsbCwiaGVhZFVybCI6bnVsbCwiaWQiOm51bGwsInVzZXJUeXBlIjpudWxsLCJleHAiOjE1NzU5ODgzMzIsIm9yZ0lkIjpudWxsLCJqdGkiOiIwNzA4MTM2Ny1jOTBkLTRlYzctYWJjMi1jMDYwMTUyYzQ3ZjgiLCJjbGllbnRfaWQiOiJYY1dlYkFwcCJ9.g9W_kHFB59sOtmHdjwjhDVXRvX-BP24uYDZvbYo5QIcdsyDprPnVUO1v1I1BzVm2QMS52FMg44HbtNBmHqme57NFJVDbzL3ZsyTv7RAbC_INnEk48wGGk8OwN1giUjmkGOL6UxZPJbUEJnsKAiP9MCD7Nl8KddvfCAL-ndttRBSRem2wPkHH0bHJqKkH1uxdUj3ukc8qnZ1j20oAhDvsIMQT8mG25s58eadvQ0HLqgcmO0bbQ4e3bm1uaFq6-5KCpvYe5HXdBbdFaN6B7ISypM-ix_zdRpBbQrcLe8hieDZdVOUO3Xrjtd367ndWj_Clo5dXvOHSIjwokUhwWBFSYA\"}";
//
//        AuthToken authToken = JSONObject.parseObject(json, AuthToken.class);
//
//        System.err.println(authToken.getJwt_token());
    }
}
