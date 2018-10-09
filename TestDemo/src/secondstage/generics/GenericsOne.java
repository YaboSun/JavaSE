package generics;

/**
 * 说明：
 * 1、如果在使用过程中没有声明T的类型，那么默认是object
 * 2、从jdk1.7版本之后可以简化泛型声明
 */

public class GenericsOne {
    public static void main(String[] args) {
        Point<Integer> p = new Point<>();
        p.setX(10);
        p.setY(20);

        // 利用包装类的自动装箱功能
        int x = p.getX();
        int y = p.getY();
        System.out.println("x坐标" + x + "y坐标" + y);
    }
}

/**
 * 此时设置的T在point类中只表示一个标记，在使用的时候要为其设置具体的类型
 * @param <T>
 */
class Point<T>{
    private T x;
    private T y;

    public T getY() {
        return y;
    }

    public T getX() {

        return x;
    }

    public void setY(T y) {

        this.y = y;
    }

    public void setX(T x) {

        this.x = x;
    }
}
