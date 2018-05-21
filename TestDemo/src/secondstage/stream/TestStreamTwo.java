package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 主要测试字节输入流
 */
public class TestStreamTwo {
    public static void main(String[] args) throws Exception{
        //定义输入文件的路径
        File file = new File(File.separator + "home" + File.separator + "hadoop" + File.separator
                + "Documents" + File.separator + "demo" + File.separator + "test.txt");
        //判断文件是否存在
        if (file.exists()) {
            InputStream inputStream = new FileInputStream(file);
            byte[] data = new byte[1024];
            int foot = 0;
            int temp;
            while ((temp = inputStream.read(data)) != -1){
                data[foot ++] = (byte) temp;
            }
            //int len = inputStream.read(data); //将内容保存到字节数组里
            inputStream.close();
            System.out.println(new String(data,0,foot));
        }
        else {
            System.out.println("文件不存在！");
        }
    }
}
