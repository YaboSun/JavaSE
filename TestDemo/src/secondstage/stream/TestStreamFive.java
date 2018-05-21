package stream;

import java.io.*;

/**
 * 模拟dos的文件拷贝程序 实现字节流的综合使用
 * 方法一、将所有的文件内容一次性的读取然后一次性的输出
 * 这里需要开辟一个与文件大小相同的数组 但是如果文件过大程序就会崩溃
 * 方法二、采用边读边输出的方法
 */
public class TestStreamFive {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        if (args.length != 2) {   //初始化参数不足2位
            System.out.println("命令执行错误！");
            System.exit(1);
        }

        //如果输入参数不正确 那么应该进行文件的验证
        File inFile = new File(args[0]);
        if (!inFile.exists()) {
            System.out.println("源文件不存在 请确认文件执行路径");
            System.exit(1); //程序退出
        }

        File outFile = new File(args[1]);
        if (!outFile.getParentFile().exists()) {
            outFile.getParentFile().mkdirs(); //创建目录
        }

        //实现文件内容的拷贝
        InputStream inputStream = new FileInputStream(inFile);
        OutputStream outputStream = new FileOutputStream(outFile);

        int temp = 0;
        byte[] data = new byte[1024];
        while ((temp = inputStream.read()) != -1) {
            outputStream.write(data,0,temp);
        }
        inputStream.close();
        outputStream.close();
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start));
    }
}
