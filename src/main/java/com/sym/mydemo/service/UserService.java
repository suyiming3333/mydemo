package com.sym.mydemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sym.mydemo.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author suyiming3333@gmail.com
 * @since 2019-04-24
 */
public interface UserService extends IService<User> {

    void updateUserByUserId(String age,String userId);

}
