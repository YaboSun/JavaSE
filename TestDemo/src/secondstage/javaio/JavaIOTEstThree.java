package javaio;

/**
 * 实现一个文件的列出操作
 */

import java.io.File;

public class JavaIOTEstThree {
    public static void main(String[] args) throws Exception {
        File file = new File(File.separator + "home" );
        printFile(file);
    }
    public static void printFile(File file) {
        if (file.isDirectory()) {  //如果现在给定的是一个路径 打印所在路径全部内容
            File[] result = file.listFiles() ;  //列出子目录
            if (result != null) {
                for (int i = 0; i < result.length; i ++) {
                    printFile(result[i]);
                }
            }
        }
        System.out.println(file);
    }
}
