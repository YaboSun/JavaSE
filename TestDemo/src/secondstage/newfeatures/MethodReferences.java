package newfeatures;

public class MethodReferences {
    public static void main(String[] args) {
        IMessageRef<Book> msg = Book::new;
        Book temp = msg.creat("java",79.0);
        System.out.println(temp);
    }
}

/**
 * 实现方法的引用接口
 */
@FunctionalInterface //表示函数式接口 只能有一个方法
interface IMessageRef<C>{
    public C creat(String t,double p);
}

class Book{
    private String title;
    private double price;

    public Book(String title,double price){
        this.title = title;
        this.price = price;
    }
    @Override
    public String toString() {
        return "书名" + this.title + "价格"+ this.price;
    }
}
