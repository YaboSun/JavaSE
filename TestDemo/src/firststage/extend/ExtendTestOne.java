package extend;

/**
 * 继承的限制
 * 1、java不允许多继承，但是可以使用多层继承，层数没有限制，但是一般不超过3层
 * 2、子类在继承弗雷的时候会继承所有的操作，但是私有的属于隐式继承，
 * 3、在子类对象构造之前一定会默认xian调用父类的无参构造函数
 * 如果这时候父类中没有无参构造函数，则在子类中需要使用super（参数列表），调用父类中指定的有参构造函数而且这需要放在子类构造方法的首行
 * 这就出现一个问题，super与this都要放在首行，所以这俩个不能同时出现，所以在子类对象实例化的过程实际上是实例化了俩个对象出来
 *
 *
 */
public class ExtendTestOne {
    public static void main(String[] args){
        Student student = new Student();
        student.setStrName("Ali");
        student.setnAge(20);
        student.setStrSchool("CUG");
        System.out.println(student.getStrName());
    }
}

class Person{
    private String strPerName;
    private int nPerAge;

    public Person(){
        System.out.println("person 类的构造方法");
    }
    public void setStrName(String strPerName){
        this.strPerName = strPerName;
    }

    public String getStrName() {
        return strPerName;
    }

    public void setnAge(int nPerAge){
        this.nPerAge = nPerAge;
    }

    public int getnAge() {
        return nPerAge;
    }
}

class Student extends Person{
    private String strSchool;

    public Student(){
        super();//可省略
        System.out.println("student类的构造方法");
    }
    public void setStrSchool(String strSchool){
        this.strSchool = strSchool;
    }

    public String getStrSchool() {
        return strSchool;
    }
}
