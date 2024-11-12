package com.at.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true)
// name= ASCIIArt的含义：ASCIIArt是一个命令行工具，可以将文字转换为ASCII艺术。
// version= ASCIIArt的版本号，这里是1.0。
// mixinStandardHelpOptions= 该选项会自动添加-h、-help、--help选项，用于显示帮助信息。
public class ASCIIArt implements Runnable {

    @Option(names = { "-s", "--font-size" }, description = "Font size")
    int fontSize = 19;

    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli",
            description = "Words to be translated into ASCII art.")
    private String[] words = { "Hello,", "picocli" };

    @Override
    public void run() {
        // 自己实现业务逻辑
        System.out.println("fontSize = " + fontSize);
        System.out.println("words = " + String.join(",", words));
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new ASCIIArt()).execute(args);
        System.exit(exitCode);
    }
}
