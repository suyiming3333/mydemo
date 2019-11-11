package com.sym.mydemo;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sym.mydemo.entity.User;
import com.sym.mydemo.mapper.UserMapper;
import com.sym.mydemo.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MydemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userServiceImpl;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        /**条件查询包装器**/
        QueryWrapper wrapper =new QueryWrapper<User>();
        wrapper.eq("name","Sandy");
//        List<User> userList = userMapper.selectList(wrapper);
//        Assert.assertEquals(5, userList.size());
        Page page = new Page<User>();
        page.setSize(2);
        page.setPages(0);
        IPage<User> userList = userMapper.getAllUserByPage(page,"test");
        //userList.forEach(System.out::println);
        System.out.println(11111);
    }

    @Test
    public void testUpdate(){
        userServiceImpl.updateUserByUserId("555","1");
        System.out.println("end");
    }

}
