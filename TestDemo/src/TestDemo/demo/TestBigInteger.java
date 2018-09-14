package demo;

import java.math.BigDecimal;
import java.util.Scanner;
/**
 * @content Java计算阶乘（n!）需要使用实现使用BigDecimal类,因为用int最多正确算到12!,用long最多正确算到20!
 * 计算机中提供了长整型和双精度等能存储较大数的数据类型，但在有些时候，这样的数据类型不能满足实际应用的需求，
 * 比如大数的阶乘。请编写程序，实现大数阶乘的算法。要求能计算N(6<=N<=300)的阶乘。
 */
public class TestBigInteger {
    public static BigDecimal factorial(BigDecimal n){
        BigDecimal bd1 = new BigDecimal(1);//BigDecimal类型的1
        BigDecimal bd2 = new BigDecimal(2);//BigDecimal类型的2
        BigDecimal result = bd1;//结果集，初值取1
        while(n.compareTo(bd1) > 0){//参数大于1，进入循环
            result = result.multiply(n.multiply(n.subtract(bd1)));//实现result*（n*（n-1））
            n = n.subtract(bd2);//n-2后继续
        }
        return result;
    }
    public static void main(String[] arguments){
        System.out.println("请输入阶乘数：");
        Scanner sc = new Scanner(System.in);
        BigDecimal n = sc.nextBigDecimal();
        sc.close();
        System.out.print(n + "!=" + "长度：" + factorial(n).toString().length());
    }

}
