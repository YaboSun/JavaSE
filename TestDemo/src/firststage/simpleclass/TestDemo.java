package firststage.simpleclass;

/**
 * 定义一个有意义的类
 * 掌握一个类需要有的基本概念
 * 1、类名称必须存在有意义，比如说：Book、Empire等
 * 2、类中的所有属性必须使用private封装，封装后的属性必须提供setter和getter方法
 * 3、类之中可以提供任意多个构造方法，但是必须保留有一个无参构造方法
 * 4、类之中不允许出现任何的输出语句，所有的输出必须交给被调用处
 * 5、类之中需要提供一个取得对象完整信息的方法，暂定为getInfo，而且返回string类型
 */
class Empire{
    private int mnEmpNum;
    private String mstrEmpName;
    private String mstrJob;
    private double mdSalary;
    private double mdComm;

    /**
     * 无参构造函数
     */
    public Empire(){}

    /**
     * 有参构造函数
     */
    public Empire(int nNum, String strName, String strEmpJob, double dSal, double dCom){
        mnEmpNum = nNum;
        mstrEmpName = strName;
        mstrJob = strEmpJob;
        mdSalary = dSal;
        mdComm = dCom;
    }

    /**
     * setter方法
     * @param nEmpNum
     */
    public void setMnEmpNum(int nEmpNum){
        mnEmpNum = nEmpNum;
    }

    public void setMstrEmpName(String strEmpName){
        mstrEmpName = strEmpName;
    }

    public void setMstrJob(String strJob){
        mstrJob = strJob;
    }

    public void setMdSalary(double dSalary){
        mdSalary = dSalary;
    }

    public void setMdComm(double dComm){
        mdComm = dComm;
    }

    /**
     * getter方法
     * @return
     */
    public int getMnEmpNum() {
        return mnEmpNum;
    }

    public String getMstrEmpName() {
        return mstrEmpName;
    }

    public String getMstrJob() {
        return mstrJob;
    }

    public double getMdSalary() {
        return mdSalary;
    }

    public double getMdComm() {
        return mdComm;
    }

    public String getInfo(){
        return  "雇员编号: " + mnEmpNum + "\n" +
                "雇员姓名: " + mstrEmpName + "\n" +
                "雇员职位: " + mstrJob + "\n" +
                "雇员薪水: " + mdSalary + "\n" +
                "佣　　金: " + mdComm + "\n";
    }
}

public class TestDemo {
    public static void main(String []args){
        Empire empire = new Empire(001,"Frank","CEO",10245.2,3010.7);
        System.out.println(empire.getInfo());
    }
}
