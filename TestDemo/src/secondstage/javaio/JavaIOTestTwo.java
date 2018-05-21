package javaio;

import java.io.File;

public class JavaIOTestTwo {
    public static void main(String[] args) throws Exception {
        File file = new File(File.separator + "home" + File.separator + "hadoop" );
        if (file.exists()) {
            System.out.println("文件大小 " + file.length() + "byte");
        }
        if (file.isDirectory()) {
            File[] result = file.listFiles();
            for (int i = 0; i < result.length; i ++) {
                System.out.println(String.format(result[i] + "/t/t" + "修改日期" ));
            }
        }
    }
}
