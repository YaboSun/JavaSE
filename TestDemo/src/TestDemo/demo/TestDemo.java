package demo;

import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        StringBuffer stringBuffer = new StringBuffer(string);
        System.out.println(replaceSpace(stringBuffer));
    }
    /*public static String replaceSpace(StringBuffer str) {
        //将StringBuffer 转换为字符数组
        char[] chars = str.toString().toCharArray();
        //遍历字符串找到空格
        if(chars == null || chars.length < 0) {
            return null;
        }
        int i = 0;
        int nOldStrLen = 0;  //记录以前的长度
        int nSpaceNum = 0;  //记录空格数量
        while (chars[i] != "\0") {

        }
    }*/
    public static String replaceSpace(StringBuffer str) {
        char[] ch = str.toString().toCharArray();
        int spacenum = 0;
        for(int i =0; i<ch.length; i++){
            if(ch[i]==' '){
                spacenum++;
            }
        }
        char[] ch1 = new char[2*spacenum + str.length()];
        int len = 2*spacenum+str.length()-1;
        for(int i=ch.length-1; i>=0; i--){
            if(ch[i] != ' '){
                ch1[len--] = ch[i];
            }else{
                ch1[len--] = '0';
                ch1[len--] = '2';
                ch1[len--] = '%';
            }
        }
        return String.valueOf(ch1);
    }

}
