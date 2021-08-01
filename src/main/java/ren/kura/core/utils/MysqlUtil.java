package ren.kura.core.utils;

import org.apache.commons.lang3.StringUtils;
import ren.kura.core.dto.EntityMake;
import ren.kura.core.dto.MysqlConnection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * <p>文件名称: MysqlUtil.java
 * <p>描述: mysql的工具类
 *
 * @author liuhao
 * @Date: 2021/7/31 8:38 下午
 * @since 1.0
 */
public class MysqlUtil {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    static final String PRIMARY_KEY_FIELD = "1";


    /**
     * MysqlUtil:: queryFields
     * <p>TO:获取字段
     * <p>HISTORY: 2021/7/31 liuhao : Created.
     *
     * @param mysqlConnection 连接信息
     * @return List<EntityMake.FiledInfo>   字段信息
     */
    public static List<EntityMake.FiledInfo> queryFields(MysqlConnection mysqlConnection) {
        List<EntityMake.FiledInfo> list = new ArrayList();
        Connection conn = null;

        try {
            conn = getConnection(mysqlConnection);
            DatabaseMetaData metaData = conn.getMetaData();

            String databaseName = conn.getCatalog();
            //主键
            ResultSet primaryKeys = metaData.getPrimaryKeys(databaseName, null,
                    mysqlConnection.getTableName());
            Set<String> keysSet = new HashSet();
            while (primaryKeys.next()) {
                String columnName = primaryKeys.getString("COLUMN_NAME");
                keysSet.add(columnName);
            }

            //列名
            ResultSet rs = metaData.getColumns(databaseName, "%",
                    mysqlConnection.getTableName(), "%");
            while (rs.next()) {
                String columnName = rs.getString("COLUMN_NAME");
                String columnType = rs.getString("TYPE_NAME");
                String remarks = rs.getString("REMARKS");

                EntityMake.FiledInfo filedInfo = new EntityMake.FiledInfo();
                filedInfo.setFiledComment(remarks);
                filedInfo.setFieldDbType(columnType);
                filedInfo.setClassType(getJavaTypeFromSqlType(columnType.toLowerCase(Locale.ROOT)));
                filedInfo.setFieldName(CodeMakeUtil.camelName(columnName));
                filedInfo.setFieldDbName(columnName);
                if (keysSet.contains(columnName)) {
                    filedInfo.setPrimaryKeyField(PRIMARY_KEY_FIELD);
                }
                list.add(filedInfo);
            }

            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return list;
    }

    /**
     * MysqlUtil:: getTableDescription
     * <p>TO:获取表描述
     * <p>HISTORY: 2021/7/31 liuhao : Created.
     *
     * @param mysqlConnection 连接信息
     * @return String  字段信息
     */
    public static String getTableDescription(MysqlConnection mysqlConnection) {
        Connection conn = null;
        String description = "";
        try {
            conn = getConnection(mysqlConnection);
            DatabaseMetaData metaData = conn.getMetaData();

            String databaseName = conn.getCatalog();
            ResultSet tables = metaData.getTables(databaseName, null, mysqlConnection.getTableName(), null);
            while (tables.next()) {
                description = tables.getString("REMARKS");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return description;
    }

    /**
     * MysqlUtil:: getConnection
     * <p>TO:获取连接
     * <p>HISTORY: 2021/7/31 liuhao : Created.
     *
     * @param mysqlConnection 连接信息
     * @return Connection  连接
     */
    private static Connection getConnection(MysqlConnection mysqlConnection) throws SQLException, ClassNotFoundException {
        String url = mysqlConnection.getUrl();
        String user = mysqlConnection.getUser();
        String password = mysqlConnection.getPassword();
        // 注册 JDBC 驱动
        Class.forName(JDBC_DRIVER);

        return DriverManager.getConnection(url, user, password);
    }


    /**
     * MysqlUtil:: getJavaTypeFromSqlType
     * <p>TO:将mysql转成对应的Java类型
     * <p>HISTORY: 2021/7/31 liuhao : Created.
     *
     * @param sqlType sql的类型
     * @return String 返回对应Java的类型
     */
    private static String getJavaTypeFromSqlType(String sqlType) {
        if (StringUtils.isBlank(sqlType)) {
            return sqlType;
        }
        switch (sqlType) {
            case "nvarchar":
            case "nchar":
            case "text":
            case "char":
            case "varchar":
                return "String";
            case "blob":
            case "image":
                return "byte[]";
            case "integer":
            case "id":
                return "Long";
            case "tinyint":
            case "smallint":
            case "mediumint":
                return "Integer";
            case "bit":
            case "boolean":
                return "Boolean";
            case "bigint":
                return "java.math.BigInteger";
            case "float":
                return "Float";
            case "double":
            case "money":
            case "smallmoney":
                return "Double";
            case "decimal":
            case "numeric":
            case "real":
                return "java.math.BigDecimal";
            case "date":
            case "datetime":
            case "year":
                return "java.util.Date";
            case "time":
                return "java.sql.Time";
            case "timestamp":
                return "java.sql.Timestamp";
            default:
                System.out.println("-----------------》转化失败：未发现的类型" + sqlType);
                return "String";
        }
    }


}
