package com.sym.mydemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sym.mydemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author suyiming3333@gmail.com
 * @version V1.0
 * @Title: UserMapper
 * @Package com.sym.mydemo.mapper
 * @Description: TODO
 * @date 2019/4/24 15:42
 */
public interface UserMapper extends BaseMapper<User> {

    IPage<User> getAllUserByPage(Page page, @Param("email") String email);

}
