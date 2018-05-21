package firststage.simpleclass;

/**
 * 通过部门－雇佣关系设计学习简单Java类的设计
 * 主要涉及数据表以及简单Java类映射
 */

/**
 * 第一步：创建对象
 * 第二步：解决外键关系
 * １、一个雇员属于一个部门应该在雇员中保存部门信息
 * 2、一个部门有多个雇员,如果要描述多个这个概念应该使用数组,一个雇员有一个领导
 * 3、设置并取得数据
 * 对于这种映射的方式分两步完成，第一步根据结构设置数据，第二部根据数据
 * 第一步设置数据
 * a、产生各自的独立对象
 * b、设置雇员和领导关系
 * c、设置雇员和部门关系
 * 第二步取出数据
 * 要求可以根据一个雇员查询他所对应的领导信息和部门信息
 * 可以根据一个部门取出所有的雇员以及每个雇员的领导信息
 */
class Department{
    private int deptNum;
    private String deptName;
    private String deptLoc;

    private Employee[] employees; //多个雇员

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    //setter、getter、无参构造略
    public Department(int deptNum,String deptName,String deptLoc){
        this.deptNum = deptNum;
        this.deptName = deptName;
        this.deptLoc = deptLoc;
    }
    public String getInfo(){
        return "部门编号：" + this.deptNum + "部门名称：" + this.deptName + "部门地址：" + this.deptLoc;
    }
}

class Employee{
    private int empNo;
    private String empName;
    private String empJob;
    private double empSalary;
    private double empCommon;

    private Employee empManager; //表示雇员对应的领导

    public void setEmpManager(Employee empManager) {
        this.empManager = empManager;
    }

    public Employee getEmpManager() {
        return empManager;
    }

    private Department department;//表示对应的部门信息

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    //setter、getter、无参构造略
    public Employee(int empNo,String empName,String empJob,double empSalary,double empCommon){
        this.empNo = empNo;
        this.empName = empName;
        this.empJob = empJob;
        this.empSalary = empSalary;
        this.empCommon = empCommon;
    }
    public String getInfo(){
        return "雇员编号"+this.empNo+"姓名"+this.empName+"职位"+this.empJob+"工资"+this.empSalary+"佣金"+this.empCommon;
    }
}

public class TestDemoSecond {
    public static void main(String[] args){
        /**
         * 设置关系
         */
        //产生各自的独立对象
        Department department = new Department(01,"开发","beijing");//部门信息
        Employee employee = new Employee(2013100,"Lish","Java",3000,500);//雇员信息
        Employee employee1 = new Employee(2013101,"Jonh","C++",2000,500);//雇员信息
        Employee employee2 = new Employee(2013103,"Smith","Manager",4000,500);//雇员信息

        //设置雇员和领导的关系
        employee.setEmpManager(employee2);
        employee1.setEmpManager(employee2);
        //设置雇员和部门关系
        employee.setDepartment(department);
        employee1.setDepartment(department);
        employee2.setDepartment(department);
        department.setEmployees(new Employee[]{employee,employee1,employee2});
        /**
         * 取出数据
         * 要求可以根据一个雇员查询他所对应的领导信息和部门信息
         */
        System.out.println(employee.getInfo());
        System.out.println(employee.getEmpManager().getInfo());
        System.out.println(employee.getDepartment().getInfo());
        /**
         * 可以根据一个部门取出所有的雇员以及每个雇员的领导信息
         */
        System.out.println("------------------------------");
        System.out.println(department.getInfo());
        for (int i = 0;i < department.getEmployees().length;i++){
            System.out.println(department.getEmployees()[i].getInfo());
            if (department.getEmployees()[i].getEmpManager()!= null){
                System.out.println(department.getEmployees()[i].getEmpManager().getInfo());
            }
        }
    }
}
/**
 * 总结
 * 可以将任意给出的数据表转换为类的形式，并可以设置和取出所有的数据
 * 第一个面向对象过程就是以数据表与简单Java类的转换为终点
 */
