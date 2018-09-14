package stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * 测试字节输入流输出流
 */
public class TestStreamOne {
    public static void main(String[] args) throws Exception{
        //定义要输出文件的路径
        File file = new File(File.separator + "home" + File.separator + "hadoop" + File.separator
                + "Documents" + File.separator + "demo" + File.separator + "test.txt");
        //判断并创建文件路径
        if (!file.getParentFile().exists()) {
            System.out.println(file.getParentFile().mkdirs());  //测试一下直接file.mkdirs
        }
        //使用outputstream进行和其子类进行对象的实例化 此时目录存在 文件还不存在
        OutputStream outputStream = new FileOutputStream(file,true);
        //要进行文件内容的输出
        String string = "hello world \r\n";
        byte[] bytes = string.getBytes();  //将字符串变为字节数组
        outputStream.write(bytes);
        outputStream.write(bytes,0,7);
        //资源操作一定要进行关闭
        outputStream.close();
    }
}
