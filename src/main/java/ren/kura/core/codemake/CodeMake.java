package ren.kura.core.codemake;

import ren.kura.core.constants.MakeConstant;
import ren.kura.core.dto.ControllerMake;
import ren.kura.core.dto.EntityMake;
import ren.kura.core.dto.MapperMake;
import ren.kura.core.dto.MysqlConnection;
import ren.kura.core.dto.ServiceMake;
import ren.kura.core.enums.MakeTypeEnum;
import ren.kura.core.utils.FtlCreateUtil;
import ren.kura.core.utils.MysqlUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * <p>文件名称: CodeMake.java
 *
 * <p>描述: 代码生成的主要类
 *
 * @author liuhao
 * @Date: 2021/7/31 11:43 上午
 * @since 1.0
 */
public class CodeMake {

    /**
     * CodeMake:: createController
     * <p>TO:生成Controller层代码
     * <p>DO:map组装模版中需要替换的信息；结合ftl模版生成指定路径的Java文件
     * <p>HISTORY: 2021/7/31 liuhao : Created.
     *
     * @param packageName 包名
     * @param entityName  类名
     */
    public static void createController(String packageName, String entityName) {
        ControllerMake controllerMake = new ControllerMake();
        controllerMake.setPackageName(packageName);
        controllerMake.setEntityName(entityName);

        String filePath = String.valueOf(MakeTypeEnum.CONTROLLER).toLowerCase(Locale.ROOT);
        Map<String, Object> makeInfo = new HashMap(16);
        makeInfo.put(filePath, controllerMake);

        FtlCreateUtil.createFileFromFtl(MakeConstant.MAKE_CONTROLLER, filePath,
                filePath, entityName + "Controller.java", makeInfo);
    }

    /**
     * CodeMake:: createService
     * <p>TO:生成Service层代码
     * <p>DO:map组装模版中需要替换的信息；结合ftl模版生成指定路径的Java文件
     * <p>HISTORY: 2021/7/31 liuhao : Created.
     *
     * @param packageName 包名
     * @param entityName  类名
     */
    public static void createService(String packageName, String entityName) {
        ServiceMake serviceMake = new ServiceMake();
        serviceMake.setPackageName(packageName);
        serviceMake.setEntityName(entityName);

        String filePath = String.valueOf(MakeTypeEnum.SERVICE).toLowerCase(Locale.ROOT);
        Map<String, Object> makeInfo = new HashMap(16);
        makeInfo.put(filePath, serviceMake);

        FtlCreateUtil.createFileFromFtl(MakeConstant.MAKE_SERVICE, filePath,
                filePath, "I" + entityName + "Service.java", makeInfo);
    }


    /**
     * CodeMake:: createServiceImpl
     * <p>TO:生成Service实现类层代码
     * <p>DO:map组装模版中需要替换的信息；结合ftl模版生成指定路径的Java文件
     * <p>HISTORY: 2021/7/31 liuhao : Created.
     *
     * @param packageName 包名
     * @param entityName  类名
     */
    public static void createServiceImpl(String packageName, String entityName) {
        ServiceMake serviceMake = new ServiceMake();
        serviceMake.setPackageName(packageName);
        serviceMake.setEntityName(entityName);

        String filePath = String.valueOf(MakeTypeEnum.SERVICE).toLowerCase(Locale.ROOT);
        String mapKey = String.valueOf(MakeTypeEnum.SERVICEIMPL).toLowerCase(Locale.ROOT);
        Map<String, Object> makeInfo = new HashMap(16);
        makeInfo.put(mapKey, serviceMake);

        FtlCreateUtil.createFileFromFtl(MakeConstant.MAKE_SERVICE_IMPL, filePath + "/impl",
                mapKey, entityName + "ServiceImpl.java", makeInfo);
    }

    /**
     * CodeMake:: createMapper
     * <p>TO:生成Mapper层代码
     * <p>DO:map组装模版中需要替换的信息；结合ftl模版生成指定路径的Java文件
     * <p>HISTORY: 2021/7/31 liuhao : Created.
     *
     * @param packageName 包名
     * @param entityName  类名
     */
    public static void createMapper(String packageName, String entityName) {
        MapperMake mapperMake = new MapperMake();
        mapperMake.setPackageName(packageName);
        mapperMake.setEntityName(entityName);

        String filePath = String.valueOf(MakeTypeEnum.MAPPER).toLowerCase(Locale.ROOT);
        Map<String, Object> makeInfo = new HashMap(16);
        makeInfo.put(filePath, mapperMake);

        FtlCreateUtil.createFileFromFtl(MakeConstant.MAKE_MAPPER, filePath,
                filePath, entityName + "Mapper.java", makeInfo);
    }

    /**
     * CodeMake:: createMapperXml
     * <p>TO:生成Mapper对应的xml层代码
     * <p>DO:map组装模版中需要替换的信息；结合ftl模版生成指定路径的xml文件
     * <p>HISTORY: 2021/7/31 liuhao : Created.
     *
     * @param packageName 包名
     * @param entityName  类名
     */
    public static void createMapperXml(String packageName, String entityName) {
        MapperMake mapperMake = new MapperMake();
        mapperMake.setPackageName(packageName);
        mapperMake.setEntityName(entityName);
        String filePath = String.valueOf(MakeTypeEnum.MAPPER).toLowerCase(Locale.ROOT);
        String mapKey = String.valueOf(MakeTypeEnum.XML).toLowerCase(Locale.ROOT);
        Map<String, Object> makeInfo = new HashMap(16);
        makeInfo.put(mapKey, mapperMake);
        FtlCreateUtil.createFileFromFtl(MakeConstant.MAKE_MAPPER_XML, filePath + "/xml",
                mapKey, entityName + "Mapper.xml", makeInfo);
    }


    /**
     * CodeMake:: createEntity
     * <p>TO:生成Entity层代码
     * <p>DO:map组装模版中需要替换的信息；结合ftl模版生成指定路径的Java文件
     * <p>HISTORY: 2021/7/31 liuhao : Created.
     *
     * @param packageName     包名
     * @param entityName      类名
     * @param mysqlConnection 连接信息
     */
    public static void createEntity(String packageName, String entityName, MysqlConnection mysqlConnection) {
        //查询字段
        List<EntityMake.FiledInfo> filedInfos = MysqlUtil.queryFields(mysqlConnection);
        //查询描述
        String tableDescription = MysqlUtil.getTableDescription(mysqlConnection);

        EntityMake entityMake = new EntityMake();
        entityMake.setPackageName(packageName);
        entityMake.setEntityName(entityName);
        entityMake.setTableName(mysqlConnection.getTableName());
        entityMake.setTableDescription(tableDescription);
        entityMake.setFiledInfos(filedInfos);
        String filePath = String.valueOf(MakeTypeEnum.ENTITY).toLowerCase(Locale.ROOT);

        Map<String, Object> makeInfo = new HashMap(16);
        makeInfo.put(filePath, entityMake);

        FtlCreateUtil.createFileFromFtl(MakeConstant.ENTITY_MAPPER, filePath,
                filePath, entityName + ".java", makeInfo);
    }
}
