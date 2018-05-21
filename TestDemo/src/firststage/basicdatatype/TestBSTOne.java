package firststage.basicdatatype;

/**
 * 测试装箱与拆箱 对于基本数据类型的包装
 */
public class TestBSTOne {
    public static void main(String[] args){
        Integer integer = new Integer(10);//将基本数据类型装箱
        int temp = integer.intValue();//将基本数据类型拆箱
        String string = "true";
        boolean flag = Boolean.parseBoolean(string);
        if (flag){
            System.out.println("满足条件");
        }

        String str1 = "10";
        int n = Integer.parseInt(str1);
        System.out.println(n);

        int i = 10;
        String string1 = String.valueOf(i);
        System.out.println(string1);
        /**
         * jdk1.5之后 自动拆装箱
         */
        Integer integer1 = 10;
        int temp1 = integer1;
        integer1++; //包装类直接进行数学运算

        Object object = 10; //先包装 再转换
        int temp2 = (Integer) object;//向下变为interger 而后自动拆箱

        System.out.println(temp*2);
        System.out.println(integer1*2);
        System.out.println();
    }
}
