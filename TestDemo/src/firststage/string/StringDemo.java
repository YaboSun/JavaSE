package string;

/**
 *1、String实例化方法
 * 直接赋值
 * 利用构造方法实例化
 * 2、字符串的比较
 *"=="比较实际上是比较的字符串所在的堆内存中的地址
 * public boolean equals(str)是比较的内容
 * 3、字符串常量就是String的匿名对象
 * 为了避免ＮＰＥ出现
 * 4、俩种实例化方式的区别
 * a、直接赋值就是相当于将一个字符串的匿名对象直接赋值给变量，这里涉及到一个共享设计模式，也就是说
 * 在jvm底层存在一个对象池，当创建某个对象时，就会将这个对象的匿名对象入池保存，而后如果有相同的方式创建对象，
 * 并且所对应的匿名对象是相同的内容，那么就不会在堆内存中开辟新的内存空间，而是将栈内存中的对象直接指向已有的地址
 * b、如果使用是构造方法进行对象的实例化，那么对于内存分析来看可以知道是在堆内存中开辟了俩块内存空间，并且其中有一块成为了垃圾
 * 并且使用这种方法定义的对象，其内容不会保存在对象池中，而是开辟了新内存
 * 如果想要入池，需要手工入池，使用的方法是：public String intern();但是造成代码很麻烦，所以一般赋值采用直接赋值
 */
public class StringDemo {
    public static void main(String[] args){
        String input = null;
        String strA = "Hello World";
        String strB = new String("Hello World");
        String strC = strB; //引用传递
        String strD = "Hello World";
        String strE = new String("Hello World").intern();
        String strLower = "hello";
        String strTest = "1a25352";
        String strSplit = "shfak shf hello world sha niha ";
        String strSplit1 = "192.168.1.131";
        String strSplit2 = "张三：20|李四：21|王五:22";

        /**
         * 测试比较"=="操作
         */
        System.out.println(strA == strB);//false,比较的是地址的数值，显然不同

        System.out.println(strA == strC);//false,比较的是地址的数值，显然不同

        System.out.println(strC == strB);//true

        System.out.println(strA == strD);//true,对象池中有对象

        /**
         * 测试eauals
         */
        System.out.println(strB.equals(strA));//true

        System.out.println(strA.equals(input));//false,内容不同
        //System.out.println(input.equals(strA));//input为空，出现空指向异常

        /**
         * 测试compareTo
         */
        System.out.println(strA.compareTo(strC));//0

        /**
         * 测试是否入池
         */
        System.out.println(strE == strA);//true

        /**
         * 测试String常用方法
         */
        //大小写转换
        char[] chars = strLower.toCharArray();
        for (int i = 0; i < chars.length; i++){
            chars[i] -=32;
        }
        System.out.println(new String(chars,1,2));

        /**
         * 判断给定一个字符串是否为数字
         */
        if (isNumber(strTest)){
            System.out.println(strTest + " is a number");
        }
        else System.out.println(strTest + " is not a number");

        /**
         * 测试indexOf
         * 返回满足单词条件的第一个字母(String),找不到返回－１
         * (int)
         */
        System.out.println(strB.indexOf("World"));
        System.out.println(strA.indexOf("l"));
        System.out.println(strA.indexOf("l",5));
        System.out.println(strA.lastIndexOf("l"));
        if (strA.lastIndexOf("s")==-1){
            System.out.println("没有找到");
        }
        if (strA.contains("l")){
            System.out.println("查询到数据");
        }

        /**
         * 测试字符串拆分
         * 这里需要注意的是拆分的标准是前面的字符串是正则表达式
         * 可以加转义字符\
         */
        String[] strings = strSplit.split("\\ ");
        printString(strings);
        String[] strings1 = strSplit1.split("\\.");
        printString(strings1);
        String[] strings2 = strSplit2.split("\\|");
        printString(strings2);
    }
    public static boolean isNumber(String string){
        char[] chars1 = string.toCharArray();
        for (int i = 0; i < chars1.length; i++){
            if (chars1[i] < '0' || chars1[i] > '9'){
                return false;
            }
        }
        return true;
    }

    public static void printString(String[] strings){
        for (int i = 0; i < strings.length;i++){
            System.out.println(strings[i]);
        }
    }
}
