package ren.kura.core.dto;

import lombok.Data;

/**
 * <p>文件名称: MysqlConnection.java
 * <p>描述: mysql的连接配置
 *
 * @author liuhao
 * @Date: 2021/7/31 11:30 上午
 * @since 1.0
 */
@Data
public class MysqlConnection {

    /**
     * 表名
     */
    private String tableName;
    /**
     * 连接地址
     */
    private String url;
    /**
     * 用户名
     */
    private String user;
    /**
     * 密码
     */
    private String password;

    public MysqlConnection(String tableName, String url, String user, String password) {
        this.tableName = tableName;
        this.url = url;
        this.user = user;
        this.password = password;
    }


}
