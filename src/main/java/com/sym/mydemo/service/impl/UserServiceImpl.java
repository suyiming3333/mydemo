package com.sym.mydemo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sym.mydemo.entity.User;
import com.sym.mydemo.mapper.UserMapper;
import com.sym.mydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author suyiming3333@gmail.com
 * @since 2019-04-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    @Transactional(rollbackFor = RuntimeException.class)
    public IPage<User> selectUserPage(Page<User> page, String email) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为非 0 时(默认为 0),分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        return userMapper.getAllUserByPage(page, email);
    }

    public void updateUserByUserId(String age,String userId){

        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        // 事物隔离级别，开启新事务
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        // 获得事务状态(已经进入了事务，需要对事务进行操作才有效)
        TransactionStatus status = dataSourceTransactionManager.getTransaction(def);



        try{
            userMapper.updateUserByUserId(age,userId);
            System.out.println(10/0);
            dataSourceTransactionManager.commit(status);
        }catch (Exception e){
            e.printStackTrace();
            //事务回滚
            dataSourceTransactionManager.rollback(status);
            System.out.println("rollbaxk");
        }finally {

        }

    }
}
