package com.at.maker.generator.file;

import cn.hutool.core.io.FileUtil;

public class StaticFileGenerator {
    /**
     * 拷贝文件（Hutool）实现，会将输入目录完整拷贝到输出目录之下。
     * @param inputPath 输入路径
     * @param outputPath 输出路径
     * isOverride 是否覆盖 = false (即不覆盖已存在的文件)
     */
    public static void copyFilesByHutool(String inputPath, String outputPath){
        FileUtil.copy(inputPath, outputPath, false);
    }
}
