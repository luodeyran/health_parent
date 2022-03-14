package org.dey.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.dey.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author deyran
 * @classname
 * @see BaseMapper
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
