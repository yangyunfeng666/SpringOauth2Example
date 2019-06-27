package com.yunsoft.oauth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OauthApplicationTests {

    @Test
    public void contextLoads() {

       BCryptPasswordEncoder cryptPasswordEncoder =  new BCryptPasswordEncoder();
       System.out.println(cryptPasswordEncoder.encode("123456"));
    }

}
