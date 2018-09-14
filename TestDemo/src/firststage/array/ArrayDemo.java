package array;

/**
 * 主要学习一维数组的有关操作
 * １、数组的创建方法
 * ２、数组的排序
 * ３、数组的转置
 * ４、对象数组的相关操作
 */

import java.util.Arrays;

class Book{
    private String strTitle;
    private double dPrice;

    public Book(){}

    public Book(String strTitle,double dPrice){
        this.strTitle = strTitle;
        this.dPrice  = dPrice;
    }
    public void setdPrice(double dPrice) {
        this.dPrice = dPrice;
    }

    public double getdPrice() {
        return dPrice;
    }

    public void setStrTitle(String strTitle) {
        this.strTitle = strTitle;
    }

    public String getStrTitle() {
        return strTitle;
    }

    public String getInfo() {
        return "书名" + strTitle  + ",价格" + dPrice;
    }
}
public class ArrayDemo {
    public static void main(String[] args) {
        Book[] book = new Book[]{
                new Book("shsi",23),
                new Book("ssf",232)
        };
        for (int i =0; i < book.length; i++){
            System.out.println(book[i].getInfo());
        }
        int[] TestData = new int[]{6,5,3,4};
        int[] TestData2 = new int[]{66,55,44,33};
        BubbleSort(TestData);
        print(TestData);
        ArrReverse(TestData);
        print(TestData);
        ArrayCopy(TestData,TestData2);
        print(TestData2);
        SysSort(TestData2);
        print(TestData2);
    }
    public static void BubbleSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    public static void ArrReverse(int[] arr){
        int temp;
        int nHeadIndex = 0;
        int nTailIndex = arr.length - 1;
        for (int i = 0; i < arr.length/2; i++){
            temp = arr[nHeadIndex];
            arr[nHeadIndex] = arr[nTailIndex];
            arr[nTailIndex] = temp;
            nHeadIndex++;
            nTailIndex--;
        }
    }
    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "、 ");
        }
        System.out.println();
    }

    /**
     * 调用Java本身具有的一些函数
     * @param FirstArr
     * @param SecondArr
     */
    public static void ArrayCopy(int[] FirstArr,int[] SecondArr){
        //实现要求
        /**
         * 将数组１对应１，２索引的值拷贝到数组２对应位置
         */
        System.arraycopy(FirstArr,1,SecondArr,1,2);
    }
    public static void SysSort(int[] arr){
        Arrays.sort(arr);
    }

}
