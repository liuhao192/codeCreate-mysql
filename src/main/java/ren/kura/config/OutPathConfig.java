package ren.kura.config;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.util.regex.Matcher;

/**
 * <p>文件名称: OutPathConfig.java
 * <p>描述: 导出路径的配置
 *
 * @author liuhao
 * @Date: 2021/7/31 11:06 上午
 * @since 1.0
 */
public class OutPathConfig {

    public static String OUT_PATH = "./out/";

    public static String MAKE_PATH = "src/main/resources/";

    /**
     *  OutPathConfig:: setOutPath
     *  <p>TO:配置导出路径
     *  <p>DO:默认导出到当前项目的out,可以配置自定义到其他路径
     *  <p>HISTORY: 2021/7/31 liuhao : Created.
     *  @param    packageName  包路径
     *  @param    outPath 导出的路径
     */
    public static  void  setOutPathPath(String packageName,String outPath){
        if (StringUtils.isBlank(outPath) || StringUtils.isBlank(packageName) ) {
            System.out.println("导出路径:"+OUT_PATH);
            return;
        }
        //替换包路径的点为\
        packageName=packageName.replaceAll("\\.", Matcher.quoteReplacement(File.separator));
        outPath +=Matcher.quoteReplacement(File.separator)+"src"+ Matcher.quoteReplacement(File.separator)+"main"
                + Matcher.quoteReplacement(File.separator)+"java"+ Matcher.quoteReplacement(File.separator);
        OUT_PATH=outPath+packageName+Matcher.quoteReplacement(File.separator);
        System.out.println("导出路径:"+OUT_PATH);
    }

}
