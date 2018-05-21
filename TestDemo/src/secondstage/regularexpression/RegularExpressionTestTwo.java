package regularexpression;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegularExpressionTestTwo {
    public static void main(String[] args) {
        String string = "10.242366";
        String string1 = "114.67.40.28";
        String string2 = "2018-5-6";
        String string3 = "yabosun@163.com";
        String regex = "[^a-z]"; //编写正则
        //实现保留所有的小写字母
        System.out.println(string.replaceAll(regex,""));
        //将给定的字符串按数字拆分
        String[] strings = string.split("\\d+");
        for (int i = 0; i < strings.length; i ++){
            System.out.print(strings[i] + " ");
        }
        //验证一个字符串是否是数字，如果是，则将其变为double型
        if (string.matches("\\d+(\\.\\d+)?")){
            System.out.println(Double.parseDouble(string));
        }

        //验证是否是一个IP地址
        System.out.println(string1.matches("(\\d{1,3}\\.){3}\\d{1,3}"));
        //验证是否是日期格式，如果是就转换为标准date型数据
        if (string2.matches("\\d{4}(\\-\\d{1,2}){2}")){
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(string2);
                System.out.println(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //验证email地址
        if (string3.matches("\\w+\\@\\w+\\.\\w+")){
            System.out.println("是电子邮件");
        }
    }
}
