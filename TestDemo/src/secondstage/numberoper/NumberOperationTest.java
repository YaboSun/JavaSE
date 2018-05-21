package numberoper;

import java.util.Arrays;
import java.util.Random;

public class NumberOperationTest {
    public static void main(String[] args) {
        Random random = new Random();
        int[] data = new int[7];
        int foot = 0; //此为数组操作的脚标
        while (foot < 7){
            int t = random.nextInt(37); //生成一个不大于37的随机数
            if (!isReapeat(data,t)){
                data[foot++] = t;   //保存数据
            }
        }
        Arrays.sort(data);
        for (int i = 0; i < data.length; i++){
            System.out.println(data[i]);
        }
    }

    /**
     * 此方法主要判断是否存在有重复的内容 但是不允许保存0
     * @param temp 指的是以保存的数据
     * @param num 新生成的数据
     * @return 如果存在 那么返回true 否则返回false
     */
    public static boolean isReapeat(int[] temp, int num){
        if (num ==0){
            return true;
        }
        for (int i = 0; i < temp.length; i++){
            if (temp[i] == num){
                return true;  //表示后面的数据不再进行判断了
            }
        }
        return false;
    }
}
