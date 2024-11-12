package com.at.generator;

import com.at.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 动态文件生成器
 */
public class DynamicGenerator {
    public static void main(String[] args) throws IOException, TemplateException {
        String projectPath = System.getProperty("user.dir") + File.separator + "at-generator-basic";
        System.out.println("projectPath: " + projectPath);
        String inputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputPath = projectPath + File.separator + "MainTemplate.java";
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("aotian");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");
        doGenerate(inputPath, outputPath, mainTemplateConfig);
    }

    public static void doGenerate (String inputPath, String outputPath, Object model) throws IOException,TemplateException{
        // new出Configuration对象，参数为FreeMarker的版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        File templateDir = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("UTF-8");
        // 设置数字格式化的格式 ----> 不要 “,” 分隔符
        configuration.setNumberFormat("0.######");

        // 创建模板对象，加载指定的模板
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);

        // 合并数据模型与模板，生成HTML文件
        Writer out = new FileWriter(outputPath);
        template.process(model, out);
        // 生成文件后别忘了关闭哦
        out.close();
    }
}
