package com.at.maker.model;

import lombok.Data;

/**
 * 静态模板配置
 * @author aotian
 */
@Data
public class DataModel {
    /**
     * 动态生成的需求：
     * 1. 在代码开头增加作者@Author 注释（增加代码）
     * 2. 修改程序输出的信息提示（替换代码）
     * 3. 将循环读取输入改为单次读取（可选代码）
     */
    // 作者(填充值、字符串)
    private String author;
    // 程序输出信息提示(填充值、字符串)
    private String outputText;
    // 是否循环读取输入(开关)
    private Boolean loop;
}
