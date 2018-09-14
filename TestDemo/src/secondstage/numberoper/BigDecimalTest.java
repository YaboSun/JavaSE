package numberoper;

import java.math.BigDecimal;

/**
 * 实现准确的四舍五入
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        System.out.println(MyMath.round(19.1231231,2));
    }
}

class MyMath {
    /**
     * 实现准确位数的四舍五入操作
     * @param num 要进行四舍五入操作的数字
     * @param scale 要保留的小数位数
     * @return 处理后的四舍五入数据
     */
    public static double round(double num, int scale){
        BigDecimal bigDecimal1 = new BigDecimal(num);
        BigDecimal bigDecimal2 = new BigDecimal(1);
        return bigDecimal1.divide(bigDecimal2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}