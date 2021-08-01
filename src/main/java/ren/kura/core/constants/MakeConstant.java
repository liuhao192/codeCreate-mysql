package ren.kura.core.constants;

import java.io.File;
import java.util.regex.Matcher;

/**
 * <p>文件名称: MakeConstant.java
 * <p>描述: 模块的静态变量
 *
 * @author liuhao
 * @Date: 2021/7/31 1:55 下午
 * @since 1.0
 */
public class MakeConstant {

    /**
     * 根目录
     */
    private static final String MAKE_ROOT_PATH ="make";
    /**
     * controller的ftl路径地址
     */
    public static final String MAKE_CONTROLLER =MAKE_ROOT_PATH+ Matcher.quoteReplacement(File.separator)
            +"controller"+Matcher.quoteReplacement(File.separator);

    /**
     * service的ftl路径地址
     */
    public static final String MAKE_SERVICE =MAKE_ROOT_PATH+ Matcher.quoteReplacement(File.separator)
            +"service"+Matcher.quoteReplacement(File.separator);

    /**
     * serviceImpl的ftl路径地址
     */
    public static final String MAKE_SERVICE_IMPL =MAKE_ROOT_PATH+ Matcher.quoteReplacement(File.separator)
            +"service"+Matcher.quoteReplacement(File.separator)+"impl"+Matcher.quoteReplacement(File.separator);

    /**
     * mapper的ftl路径地址
     */
    public static final String MAKE_MAPPER =MAKE_ROOT_PATH+ Matcher.quoteReplacement(File.separator)
            +"mapper"+Matcher.quoteReplacement(File.separator);

    /**
     * mapper对应的xml的ftl路径地址
     */
    public static final String MAKE_MAPPER_XML =MAKE_ROOT_PATH+ Matcher.quoteReplacement(File.separator)
            +"mapper"+Matcher.quoteReplacement(File.separator)+"xml"+Matcher.quoteReplacement(File.separator);

    /**
     * entity的ftl路径地址
     */
    public static final String ENTITY_MAPPER =MAKE_ROOT_PATH+ Matcher.quoteReplacement(File.separator)
            +"entity"+Matcher.quoteReplacement(File.separator);

}
