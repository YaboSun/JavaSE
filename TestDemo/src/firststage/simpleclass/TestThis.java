package simpleclass;

/**
 * １、表示本类属性
 * 对于this关键字来说，实际上就是明确标记本类的结构，
 * 只要是访问类中的属性，就一定加上this关键字
 * ２、用this可以调用本类的普通方法或构造方法
 * 对于调用普通方法的时候，是否加this对结果没有多大影响。但是为了代码的严谨可读性等，加上
 * 而当涉及到构造方法间的互相调用，需要this关键字来实现,注意的是对this的调用必须放在首行
 * 构造能够调用普通方法，但是普通不能调用构造方法
 * 构造函数一定要保留一个出口，就是说不管怎么调用，总要保留一个构造函数没有使用this　调用其他构造函数
 * ３、用this表示当前对象
 * 当前对象指的就是当前正在调用类中的方法的对象
 */
class Book1{
    private String title;
    private double price;

    public Book1(){
        System.out.println("新的构造方法产生");
    }

    public Book1(String title){
        this();
        this.title = title;
    }
    public Book1(String title,double price){
        this(title);
        this.price = price;
    }
    public void printTest(){
        System.out.println("××××××");
    }
    public void printThis(){
        System.out.println("this=" + this);
    }
    /**
     * setter\getter略
     * @return
     */
    public String getInfo() {
        this.printTest();
        return "书名：" + title + "价格:" + price;
    }
}
public class TestThis {
    public static void main(String[] args){
        Book1 book = new Book1("java",10);
        book.printThis();
        Book1 book1 = new Book1("c++");
        book1.printThis();
        System.out.println(book.getInfo());
        System.out.println(book1.getInfo());

    }
}
