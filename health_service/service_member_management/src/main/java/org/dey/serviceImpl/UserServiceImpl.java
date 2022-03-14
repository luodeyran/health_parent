package org.dey.serviceImpl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.dey.mapper.UserMapper;
import org.dey.pojo.User;
import org.dey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author deyran
 * @classname
 * @see ServiceImpl
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> USERS() {
        return this.list();
    }
}
