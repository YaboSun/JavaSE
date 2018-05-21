package firststage.abstractdemo;

/**
 * 1、如果真的使用类继承的话就使用抽象类
 * 2、抽象类强制规定了子类必须要做的事，而且可以与抽象类的普通方法相配合
 * 3、不管抽象类如何努力都有单继承的局限
 */
public class AbstractTestTwo {
    public static void main(String[] args){
        fun(new Robot());
        fun(new Human());
        fun(new Pig());
    }
    public static void fun(Action action){
        action.command(Action.EAT);
        action.command(Action.SLEEP);
        action.command(Action.WORK);
    }
}

/**
 * 定义行为类
 */
abstract class Action{
    public static final int EAT = 1;
    public static final int SLEEP = 5;
    public static final int WORK = 7;

    public void command(int flag){
        switch (flag){
            case EAT:
                this.eat();
                break;
            case SLEEP:
                this.sleep();
                break;
            case WORK:
                this.work();
                break;
            case EAT + WORK:
                this.eat();
                this.work();
                break;
            default:
                break;
        }
    }
    public abstract void eat();
    public abstract void sleep();
    public abstract void work();
}

class Robot extends Action{
    @Override
    public void eat() {
        System.out.println("机器人补充能量！");
    }

    @Override
    public void sleep() {

    }

    @Override
    public void work() {
        System.out.println("机器人努力工作！");
    }
}

class Human extends Action{
    @Override
    public void work() {
        System.out.println("人在努力工作！");
    }

    @Override
    public void sleep() {
        System.out.println("人在睡觉！");
    }

    @Override
    public void eat() {
        System.out.println("人在吃饭！");
    }
}

class Pig extends Action{
    @Override
    public void work() {

    }

    @Override
    public void sleep() {
        System.out.println("猪在睡觉！");
    }

    @Override
    public void eat() {
        System.out.println("猪在吃东西！");
    }
}