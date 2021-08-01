package ${entity.packageName}.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
* @Description: ${entity.entityName}
* @Author: ${entity.author}
* @Date:   ${.now?string["yyyy-MM-dd"]}
* @Version: V1.0
*/
@Data
@TableName("${entity.tableName}")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="${entity.tableName}对象", description="${entity.tableDescription}")
public class ${entity.entityName} implements Serializable {

    private static final long serialVersionUID = 1L;

<#list entity.filedInfos as po>
    /**${po.filedComment}*/
    <#if po.primaryKeyField?? && po.primaryKeyField=='1'>
    @TableId(type = IdType.AUTO)
    <#else>
        <#if po.classType =='java.util.Date'>
            <#if po.fieldDbType =='date'>
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
            <#elseif po.fieldDbType =='datetime'>
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
            </#if>
        </#if>
    </#if>
    @ApiModelProperty(value = "${po.filedComment}")
    @TableField(value ="${po.fieldDbName}")
    private <#if po.fieldDbType=='java.sql.Blob'>byte[]<#else>${po.classType}</#if> ${po.fieldName};
</#list>
}
