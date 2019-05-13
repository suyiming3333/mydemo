package com.sym.mydemo.security.config;

import com.sym.mydemo.security.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author suyiming3333@gmail.com
 * @version V1.0
 * @Title: SecurityConfig
 * @Package com.sym.mydemo.security.config
 * @Description: TODO
 * @date 2019/5/9 22:45
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                /**开放访问的资源路径**/
                .antMatchers("/","/login","/login-error","/css/**").permitAll()
                /**特定资源需要特定权限才能访问**/
//                .antMatchers("/user/**").hasAuthority("book-view")
                .antMatchers("/user/**").hasRole("USER")
                /**其他资源都需要身份验证**/
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").failureUrl("/login-error").successForwardUrl("/user/index")
                .and()
                .logout().logoutSuccessUrl("/");
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth.inMemoryAuthentication()
////                .withUser("user").password("password").roles("USER").authorities("book-view");
//        super.configure(auth);
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**获取用户信息**/
        auth.userDetailsService(myUserDetailsService);
    }

//    @Bean
//    protected UserDetailsService userDetailsService() {
//        User.UserBuilder builder = User.builder();
//        UserDetails user = builder.username("zhangsan").password("$2a$10$GStfEJEyoSHiSxnoP3SbD.R8XRowP1QKOdi.N6/iFEwEJWTQqlSba").roles("USER").build();
//        UserDetails admin = builder.username("lisi").password("$2a$10$GStfEJEyoSHiSxnoP3SbD.R8XRowP1QKOdi.N6/iFEwEJWTQqlSba").roles("USER", "ADMIN").build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }


    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("123456"));
        System.out.println(bCryptPasswordEncoder.encode("12345678"));
    }

}
