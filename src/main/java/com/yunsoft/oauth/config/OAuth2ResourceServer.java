package com.yunsoft.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServer  extends ResourceServerConfigurerAdapter {

    private static final String SPARKLR_RESOURCE_ID = "webapp";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
       resources.resourceId(SPARKLR_RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll().antMatchers("/api/**").authenticated();
    }
}
