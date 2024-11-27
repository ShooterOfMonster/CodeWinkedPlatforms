package com.at.maker.generator.main;

import cn.hutool.extra.template.TemplateException;
import java.io.IOException;


/**
 * 生成代码生成器主类
 */
public class MainGenerator extends GenerateTemplate {

    public static void main(String[] args) throws TemplateException, IOException, freemarker.template.TemplateException, InterruptedException {
        MainGenerator mainGenerator = new MainGenerator();
        mainGenerator.doGenerate();
    }

}
