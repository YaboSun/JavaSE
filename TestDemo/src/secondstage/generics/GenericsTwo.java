package generics;

/**
 * 测试泛型--通配符
 */
public class GenericsTwo {
    public static void main(String[] args) {
        Message<Double> m = new Message<>();
        m.setMsg(20.0);
        fun(m);

        /**
         * 测试泛型接口
         */
        IMessage<String> msg = new MessageImpl();
        msg.print("hello World");
    }

    /**
     * 通过问号可以明确不能改变内容 但是可以取出 ,
     * ? extends表示设置泛型上限 表示只能是设置的子类
     * ? super 表示泛型下限
     * @param temp
     */
    private static void fun(Message<? extends Number> temp){
        System.out.println(temp.getMsg());
    }
}

class Message<T>{
    private T msg;

    public T getMsg() {
        return msg;
    }

    public void setMsg(T msg) {

        this.msg = msg;
    }
}

interface IMessage<T>{
    void print(T t);
}

/**
 * 子类也使用泛型，并且父接口使用和子类同样的泛型标记
 *
 */
class MessageImpl implements IMessage<String>{
    @Override
    public void print(String t) {
        System.out.println(t);
    }
}

