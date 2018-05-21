package enumerate;


public class EnumTestOne {
    public static void main(String[] args) {
        IMessage message = Color.RED;
        System.out.println(message.getTitle()); //枚举实现接口
/*        for (Color c :Color.values()){
            System.out.println(c);
        }*/
    }
}

enum Color implements IMessage{
    RED("红色"),GREEN("绿色"),BLUE("蓝色");//之所以大写表示此处为实例化对象 只能放在首行
    private String title;
    private Color(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }

    @Override
    public String getTitle() {
        return this.title;
    }
}

interface IMessage {
    public String getTitle();
}