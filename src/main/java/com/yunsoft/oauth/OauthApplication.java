package com.yunsoft.oauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"com.yunsoft.oauth"})
@MapperScan(value = "com.yunsoft.oauth.dao")
@EntityScan(value = "com.yunsoft.oauth.modle")
public class OauthApplication {
    public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class, args);
    }
}
