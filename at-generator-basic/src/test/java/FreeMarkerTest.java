import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreeMarkerTest {

    @Test
    public void test01() throws IOException, TemplateException {
        // new出Configuration对象，参数为FreeMarker的版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("UTF-8");
        // 设置数字格式化的格式 ----> 不要 “,”分隔符
        configuration.setNumberFormat("0.######");

        // 创建模板对象，加载指定的模板
        Template template = configuration.getTemplate("myweb.html.ftl");

        // 创建数据模型
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("currentYear", 2024);
        List<Map<String, Object>> menuItems = new ArrayList<>();
        Map<String, Object> menuItem1 = new HashMap<>();
        menuItem1.put("url", "https://codefather.cn");
        menuItem1.put("label", "编程导航");
        Map<String, Object> menuItem2 = new HashMap<>();
        menuItem2.put("url", "https://tongyi.aliyun.com");
        menuItem2.put("label", "通易千问AI");
        menuItems.add(menuItem1);
        menuItems.add(menuItem2);

        dataModel.put("menuItems", menuItems);

        // 合并数据模型与模板，生成HTML文件
        Writer out = new FileWriter("myweb.html");

        template.process(dataModel, out);
        // 生成文件后别忘了关闭哦
        out.close();

    }
}
