package org.dey.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * 检查组
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_checkgroup")
public class CheckGroup implements Serializable {
    private Integer id;//主键
    private String code;//编码
    private String name;//名称
    private String helpCode;//助记
    private String sex;//适用性别
    private String remark;//介绍
    private String attention;//注意事项
    private List<CheckItem> checkItems;//一个检查组合包含多个检查项

}
