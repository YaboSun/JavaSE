package stream;

/**
 * 测试Writer
 */

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class TestStreamThree {
    public static void main(String[] args) throws Exception{
        //定义要输入的文件路径
        File file = new File(File.separator + "home" + File.separator + "hadoop" + File.separator
                + "Documents" + File.separator + "demo" + File.separator + "test.txt");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        //实例化writer类对象
        Writer writer = new FileWriter(file);
        //进行内容输出
        String string = "Hello World";
        writer.write(string);
        //关闭输出流
        writer.close();
    }
}
