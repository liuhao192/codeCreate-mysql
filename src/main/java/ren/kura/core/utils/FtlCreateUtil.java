package ren.kura.core.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import ren.kura.config.OutPathConfig;
import ren.kura.core.constants.MakeConstant;
import ren.kura.core.dto.BaseMake;
import ren.kura.core.enums.MakeTypeEnum;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * <p>文件名称: FtlCreateUtil.java
 * <p>描述: freemarker生成的工具
 *
 * @author liuhao
 * @Date: 2021/7/31 2:02 下午
 * @since 1.0
 */
public class FtlCreateUtil<T extends BaseMake> {


    /**
     * FtlCreateUtil:: createFileFromFtlFile
     * <p>TO: 通过ftl模版文件生成文件
     * <p>HISTORY: 2021/7/31 liuhao : Created.
     *
     * @param ftlPath     ftl的读取路径
     * @param filePath    文件生成的路径
     * @param ftlFileName ftl文件名
     * @param fileName    生成文件的后缀拼接字符串
     * @param makeInfo    替换的信息
     */
    public static void createFileFromFtl(String ftlPath, String filePath,
                                         String ftlFileName, String fileName, Map<String, Object> makeInfo) {
        File makeFile = new File(OutPathConfig.MAKE_PATH + ftlPath);
        File dir = new File(OutPathConfig.OUT_PATH + filePath);

        //生成路径
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            CreateFile(makeFile, new File(dir, fileName),
                    ftlFileName + ".ftl", makeInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * FtlCreateUtil:: CreateFile
     * <p>TO:根据模版和生成路径+替换信息生成文件
     * <p>HISTORY: 2021/7/31 liuhao : Created.
     *
     * @param fromFtlFile 读取的ftl的文件路径
     * @param toFile      生成的文件路径
     * @param ftlName     模版名称
     * @param makeInfo    生成的替换的信息
     * @throws Exception 生成过程中的异常
     */
    private static void CreateFile(File fromFtlFile, File toFile,
                                   String ftlName, Map<String, Object> makeInfo) throws Exception {
        Writer out = null;
        try (OutputStream fos = new FileOutputStream(toFile)) {
            Configuration config = new Configuration(Configuration.VERSION_2_3_31);
            config.setDirectoryForTemplateLoading(fromFtlFile);
            config.setDefaultEncoding("utf-8");
            config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

            Template template = config.getTemplate(ftlName);
            out = new OutputStreamWriter(fos, "utf-8");
            template.process(makeInfo, out);

            fos.flush();
            System.out.println("create " + toFile.getAbsolutePath());
        } catch (Exception e) {
            throw e;
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }


}
