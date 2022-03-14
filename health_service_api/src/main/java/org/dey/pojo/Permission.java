package org.dey.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 权限
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_permission")
public class Permission implements Serializable{
    private Integer id;
    private String name; // 权限名称
    private String keyword; // 权限关键字，用于权限控制
    private String description; // 描述
    private Set<Role> roles = new HashSet<Role>(0);

}
