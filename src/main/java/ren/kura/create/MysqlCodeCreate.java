package ren.kura.create;

import ren.kura.config.OutPathConfig;
import ren.kura.core.codemake.CodeMake;
import ren.kura.core.dto.MysqlConnection;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * <p>文件名称: MysqlCodeCreate.java
 * <p>描述: mysql的代码主程序入口
 *
 * @author liuhao
 * @Date: 2021/7/31 12:10 上午
 * @since 1.0
 */
public class MysqlCodeCreate {
    public static void main(String[] args) {

        ResourceBundle bundle = ResourceBundle.getBundle("create_Info", new Locale("ZH", "CN"));

        //地址
        String url = bundle.getString("url");

        //用户名
        String userName = bundle.getString("user_name");

        //密码
        String password = bundle.getString("password");

        //表名
        String tableName = bundle.getString("table_name");

        //导出路径
        String outPath = bundle.getString("out_path");

        //导出的类名
        String entityName = bundle.getString("entity_name");

        //包名
        String packageName = bundle.getString("package_name");

        //配置导出的路径
        OutPathConfig.setOutPathPath(packageName, outPath);

        MysqlConnection mysqlConnection = new MysqlConnection(tableName, url, userName, password);

        //生成controller
        CodeMake.createController(packageName,entityName);

        //生成service
        CodeMake.createService(packageName,entityName);

        //生成serviceImpl
        CodeMake.createServiceImpl(packageName,entityName);

        //生成mapper
        CodeMake.createMapper(packageName,entityName);

        //生成mapperXml
        CodeMake.createMapperXml(packageName,entityName);

        //生成entity
        CodeMake.createEntity(packageName, entityName, mysqlConnection);

    }

}
