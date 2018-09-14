package staticdemo;

/**
 * 一旦在对象定义上使用了static那么只要有一个对象修改了该属性，则所有对象的属性都会修改
 * static属性和非static属性最大的区别就是保存的内存空间　不同，一个是保存在堆内存空间中，一个是在全局数据区
 * 另外，非static属性必须产生实例化对象，而static属性不受实例化对象的，是独立于类存在的
 * 静态函数中无法调用非静态属性或方法,而非静态方法可以访问静态属性或方法，不受任何的限制
 */
public class TestStatic {
    public static void main(String[] args){
        Book book = new Book("Java",12.0);
        Book book1 = new Book("Android",13.0);
        Book.setStrPub("北大出版社");
        Book book2 = new Book("Oracle",14.0);
        System.out.println(book.getInfo());
    }
}

class Book{
    private String strTitle;
    private double dPrice;
    //定义一个描述出版社信息的属性
    private static String strPub = "清华大学出版社";

    public Book(String strTitle,double dPrice){
        this.strTitle = strTitle;
        this.dPrice = dPrice;
    }

    public static void setStrPub(String strPub) {
        Book.strPub = strPub;
    }

    public static String getStrPub() {
        return strPub;
    }

    public String getInfo(){
        return "图书名称: " + this.strTitle + " 图书价格: " + this.dPrice + " 出版社:  " + Book.strPub;
    }
}
