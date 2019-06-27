package com.yunsoft.oauth.service;

import com.yunsoft.oauth.dao.UserDao;
import com.yunsoft.oauth.modle.MyUserDetail;
import com.yunsoft.oauth.modle.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("customerUserDetailServiceImpl")
public class CustomerUserServiceImpl implements UserDetailsService ,CustomerUserService{

    @Autowired
    private UserDao userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<User> user = userMapper.selectByUserName(s);
        if(user.isEmpty()){
            throw  new UsernameNotFoundException("User name"+s+"not found");
        }else if(user.size()==1){
            return new MyUserDetail(user.get(0));
        }else {
            throw  new IllegalAccessError("存在多个相同名称的用户");
        }
    }


    @Override
    public int save(User user) {
        return userMapper.insertSelective(user);
    }

}
