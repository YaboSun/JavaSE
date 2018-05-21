package firststage.extend;

import java.util.Arrays;

/**
 * 主要实现一个数组操作类，这个类中可以进行整型数组的操作，实现数据的保存和输出等 另外在这个类的基础上派生俩个子类
 * 排序类：通过此类取得的数据可以进行排序
 * 反转类：通过此类取得的数组数据要求采用倒序的方式输出
 *
 * 过程：
 * 1、开发数组的父类
 * 2、开发排序类
 * 3、开发反转类
 */
public class ExtendTestThree {
    public static void main(String[] args){
        ReverseArray operArray = new ReverseArray(3);
        operArray.add(100);
        operArray.add(20);
        boolean add = operArray.add(350);
        System.out.println(add);
        int[] temp = operArray.getnDatas();
        for (int i =0; i < temp.length; i++){
            System.out.println(temp[i]);
        }

    }
}

/**
 * 定义一个数组
 */
class OperArray{
    private int[] nDatas;
    private int nFoot; //表示数组的操作脚标

    public OperArray() {
    }

    public OperArray(int nLenth) {
        if (nLenth > 0){
            this.nDatas = new int[nLenth]; //开辟一个大小为nlenth的数组
        }
        else {
            this.nDatas = new int[1];  //否则保持数组大小为1
        }

    }
    public boolean add(int num){
        if (this.nFoot < this.nDatas.length){   //有空间保存
            this.nDatas[this.nFoot++] = num;
            return true;
        }
        return false;
    }

    public int[] getnDatas() {
        return nDatas;
    }
}

/**
 * 定义一个排序数组子类
 */
class SortArray extends OperArray {
    public SortArray(int nLenth) {
        super(nLenth); //明确的调用父类的有参构造函数 这样父类中的data数组就可以初始化
    }

    /**
     * 因为父类中的getData方法不够房钱类使用的
     * 所以使用覆写的方法来将次方法进行扩充
     */
    @Override
    public int[] getnDatas() {
        Arrays.sort(super.getnDatas());
        return super.getnDatas();
    }
}

/**
 * 定义一个反转类
 */
class ReverseArray extends OperArray{
    public ReverseArray(int len){
        super(len);
    }

    public int[] getnDatas(){
        int center = super.getnDatas().length/2;
        int head = 0;
        int tail = super.getnDatas().length - 1;
        for (int i = 0; i < center; i++){
            int temp = super.getnDatas()[head];
            super.getnDatas()[head] = super.getnDatas()[tail];
            super.getnDatas()[tail] = temp;
            head ++;
            tail --;
        }
        return super.getnDatas();
    }
}

