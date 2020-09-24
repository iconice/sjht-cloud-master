import com.sjht.cloud.UcenterServerApplication;
import com.sjht.cloud.ucenter.service.impl.SysUserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ***************************************************
 *
 * @ClassName Test
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/12/12 15:50
 * @Version V1.0
 * ****************************************************
 **/
@SpringBootTest(classes = UcenterServerApplication.class)
@RunWith(SpringRunner.class)
public class TestApp {
    @Autowired
    SysUserServiceImpl sysUserServiceImpl;
    @Test
    public void testUserInfo(){
        System.out.println(sysUserServiceImpl.getUserInfoByUserNameSimple("edison"));
    }
}
