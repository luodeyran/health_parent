package org.dey.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.dey.pojo.User;

import java.util.List;

/**
 * @author deyran
 * @classname
 * @see IService
 */
public interface UserService extends IService<User> {

    List<User> USERS();

}
