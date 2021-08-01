package ren.kura.core.dto;

import lombok.Data;

import java.util.List;

/**
 * <p>文件名称: EntityMake.java
 * <p>描述: Entity生成类需要的信息
 *
 * @author liuhao
 * @Date: 2021/7/31 11:53 上午
 * @since 1.0
 */
@Data
public class EntityMake extends BaseMake {

    /**
     * 表名
     */
    private String tableName;

    /**
     * 表描述
     */
    private String tableDescription;

    /**
     * 字段名称
     */
    private List<FiledInfo> filedInfos;

    @Data
    public static class FiledInfo {
        /**
         * 字段描述
         */
        private String filedComment;

        /**
         * 是否主键（1 主键 0 非主键）
         */
        private String primaryKeyField;
        /**
         * 字段数据库类型
         */
        private String fieldDbType;
        /**
         * 对应的Java类型
         */
        private String classType;
        /**
         * 字段名称
         */
        private String fieldName;
        /**
         * 字段数据的名称名称
         */
        private String fieldDbName;
    }

}
