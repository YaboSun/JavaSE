package stream;

import java.io.*;

public class TestStreamFour {
    public static void main(String[] args) throws Exception {
        //定义要输入的文件路径
        File file = new File(File.separator + "home" + File.separator + "hadoop" + File.separator
                + "Documents" + File.separator + "demo" + File.separator + "test.txt");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        //实现转换 将outputstream类对象传递给fileoutputstream构造方法 之后向上转型为Writer
        OutputStream outputStream = new FileOutputStream(file);
        Writer writer = new OutputStreamWriter(outputStream);
        writer.write("hello world");
        writer.close();
    }
}
