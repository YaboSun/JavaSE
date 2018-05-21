package firststage.string;

/**
 * 主要学习java引用传递
 * １、引用传递的实质就是不同栈内存空间可以指向同一块堆内存空间，并对其内容进行修改
 * ２、对于String对象来说，有对象不可变的特性
 */
class Message{
    private String strInfo = "Hello";
    public Message(String strInfo){
        this.strInfo = strInfo;
    }

    public void setStrInfo(String strInfo) {
        this.strInfo = strInfo;
    }

    public String getStrInfo() {
        return strInfo;
    }

}
class Member{
    private int nMid; //人员编号
    private String strName; //人员姓名
    //用于表示一个人是否有车，如果car有实例化对象，表示有车，如果为null表示没有车
    private Car car;//表示属于人的车
    private Member mChild;

    public Member(int nMid,String strName){
        this.nMid = nMid;
        this.strName = strName;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setmChild(Member mChild) {
        this.mChild = mChild;
    }

    public Member getmChild() {
        return mChild;
    }

    public String getInfo() {
        return "人员编号:" + this.nMid + " 姓名：" + this.strName;
    }
}

class Car{
    private Member member; //车属于人
    private String strPname;
    public Car(String strPname){
        this.strPname = strPname;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Member getMember() {
        return member;
    }

    public String getInfo() {
        return "车的名字" + this.strPname;
    }
}
public class ReferenceDemo {
    public static void main(String[] args){
        Message message = new Message("NiHao");
        fun(message);
        System.out.println(message.getStrInfo());

        /**
         * 测试人和车
         */
        Member member = new Member(1,"Franky");
        Car car = new Car("Honda");
        member.setCar(car);
        car.setMember(member);
        System.out.println(member.getCar().getInfo());
        System.out.println(car.getMember().getInfo());

        /**
         * 测试child
         */
        Member member1 = new Member(2,"ss");
        Car car1 = new Car("BMW");
        member1.setCar(car1);
        car1.setMember(member1);
        member1.setmChild(member1);
        System.out.println(member1.getmChild().getInfo());
        System.out.println(car1.getInfo());//代码链
    }

    public static void fun(Message temp){
        temp.setStrInfo("World");
    }
}
