package javaio;

import java.io.File;

public class JavaIOTestOne {
    public static void main(String[] args) throws Exception {
        File file = new File(File.separator + "home"+File.separator + "hadoop"
                + File.separator + "demo" + File.separator + "test.txt");
        if (!file.exists()) {
            System.out.println(file.getParentFile().mkdirs());
            System.out.println(file.createNewFile());
        }
        else {
            System.out.println("文件已经存在");
            System.out.println(file.delete());
        }
    }
}
