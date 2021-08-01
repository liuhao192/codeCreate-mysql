package ren.kura.core.dto;

import lombok.Data;

/**
 * <p>文件名称: BaseMake.java
 * <p>描述: 构建的基础类
 *
 * @author liuhao
 * @Date: 2021/7/31 11:44 上午
 * @since 1.0
 */
@Data
public class BaseMake {
    /**
     * 包名
     */
    private String packageName;
    /**
     * 类名
     */
    private String entityName;
    /**
     * 作者
     */
    private String author;

    //赋值系统的用户名
    {
        this.author=System.getProperty("user.name");
    }

}
