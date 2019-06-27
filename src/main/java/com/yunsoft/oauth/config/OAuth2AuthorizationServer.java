package com.yunsoft.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Resource
    private AuthenticationManager authenticationManager;


    @Autowired
    private DataSource dataSource;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    @Qualifier("customerUserDetailServiceImpl")
    private UserDetailsService userDetailsService;


    @Bean("jdbcTokenStore")
    public JdbcTokenStore getJdbcTokenStore() {
        return new JdbcTokenStore(dataSource);
    }



    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(getJdbcTokenStore())
                .accessTokenConverter(jwtAccessTokenConverter())
                .authenticationManager(authenticationManager)
        .userDetailsService(userDetailsService);
       // endpoints.authenticationManager(authenticationManager);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
       security.tokenKeyAccess("permitAll()") //url:/oauth/token_key,exposes public key for token verification if using JWT tokens
               .checkTokenAccess("isAuthenticated()") //url:/oauth/check_token allow check token
               .allowFormAuthenticationForClients();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("webapp").secret(bCryptPasswordEncoder.encode("112233")).authorizedGrantTypes("password","refresh_token").scopes("read_userInfo","read_contacts");
    }




    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        //对称加密方式
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("micosrv_signing_key");
        return converter;
    }
}
