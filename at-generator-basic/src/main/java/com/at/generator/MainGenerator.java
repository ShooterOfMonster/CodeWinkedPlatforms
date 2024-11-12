package com.at.generator;

import com.at.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 核心生成器
 */
public class MainGenerator {

    /**
     * 生成
     *
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException {
        String inputRootPath = "D:\\Java_subject\\CodeSuggestion\\后端工程\\at-generator\\at-generator-demo-projects\\acm-template-pro";
        String outputRootPath = "D:\\Java_subject\\CodeSuggestion\\后端工程\\at-generator\\at-generator-basic\\generated";
        // 这里定义全局变量的原因是： 要生成的文件可能有静态动态之分，动态文件需要传入数据模型，静态文件不需要。
        String inputPath;
        String outputPath;
        File outputDir;
        // 生成动态文件之前，确认输出目录存在
        outputDir = new File(outputRootPath, "src/com/at/acm");
        if (!outputDir.exists()) {
            outputDir.mkdirs(); // 创建所有必要的父目录
        }
        // 生成动态文件
        inputPath = new File(inputRootPath, "src/com/at/acm/MainTemplate.java.ftl").getAbsolutePath();
        outputPath = new File(outputRootPath, "src/com/at/acm/MainTemplate.java").getAbsolutePath();
        DynamicGenerator.doGenerate(inputPath, outputPath, model);
        System.out.println("动态文件生成成功！");

        // 生成静态文件之前，确认输出目录存在
        outputDir = new File(outputRootPath);
        if (!outputDir.exists()) {
            outputDir.mkdirs(); // 创建所有必要的父目录
        }

        // 生成静态文件.gitignore
        inputPath = new File(inputRootPath, ".gitignore").getAbsolutePath();
        outputPath = new File(outputRootPath, ".gitignore").getAbsolutePath();
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);
        // 生成静态文件README.md
        inputPath = new File(inputRootPath, "README.md").getAbsolutePath();
        outputPath = new File(outputRootPath, "README.md").getAbsolutePath();
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("aotian");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");
        doGenerate(mainTemplateConfig);
    }
}

