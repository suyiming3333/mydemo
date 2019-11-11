package com.sym.mydemo.security.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author suyiming3333@gmail.com
 * @version V1.0
 * @Title: MyUserDetailsService
 * @Package com.sym.mydemo.security.service
 * @Description: TODO
 * @date 2019/5/10 23:24
 */

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("book-view"));
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        User user = new User("corn","111111",roles);
        return user;
    }
}
