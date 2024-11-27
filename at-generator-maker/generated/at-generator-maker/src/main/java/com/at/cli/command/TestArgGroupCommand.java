package com.at.cli.command;

import lombok.Data;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.ArgGroup;

@Command(name = "test", mixinStandardHelpOptions = true)
public class TestArgGroupCommand implements Runnable {

    @Option(names = {"--needGit"}, arity = "0..1", description = "是否生成 .gitignore 文件", interactive = true, echo = true)
    private boolean needGit = true;

    @Option(names = {"-l", "--loop"}, arity = "0..1", description = "是否生成循环", interactive = true, echo = true)
    private boolean loop = false;

    @ArgGroup(exclusive = false, heading = "核心模板%n")
    MainTemplate mainTemplate;

    @Override
    public void run() {
        System.out.println(needGit);
        System.out.println(loop);
        System.out.println(mainTemplate);
    }

    @Data
    static class MainTemplate {
        @Option(names = {"-mainTemplate.a", "--mainTemplate.author"}, arity = "0..1", description = "作者注释", interactive = true, echo = true)
        private String author = "傲天灬曜星";

        @Option(names = {"-mainTemplate.o", "--mainTemplate.outputText"}, arity = "0..1", description = "输出信息", interactive = true, echo = true)
        private String outputText = "sum = ";
    }

    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine(TestArgGroupCommand.class);
//      commandLine.execute("-l", "-mainTemplate.a", "--mainTemplate.outputText");
        commandLine.execute( "--help");
    }
}
