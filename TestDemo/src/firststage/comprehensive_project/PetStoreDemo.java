package firststage.comprehensive_project;

public class PetStoreDemo {
    public static void main(String[] args){
        PetShop petShop = new PetShop();
        petShop.add(new Cat("白猫",20));

        petShop.add(new Cat("黑猫",21));

        petShop.add(new Dog("白狗",23));

        petShop.add(new Dog("黑狗",22));

        Link link = petShop.search("白");
        Object[] objects = link.toArray();
        for (int i = 0; i < objects.length; i++ ){
            System.out.println(objects[i]);
        }
    }
}

/**
 * 定义一个链表类 相当于定义了一个链表的接口供使用
 */
class Link{
    /**
     * 定义的一个节点类
     * 之所以要定义在内部主要让其为link类服务
     */
    private class Node {
        private Object data; //保存数据
        private Node next; //引用关系

        public Node(Object data) {
            this.data = data;
        }

        public void addNode(Node node) {
            if (this.next == null) { //表示当前节点为空
                this.next = node;
            } else {
                this.next.addNode(node);
            }
        }
        public boolean bContainsNode(Object data){
            if (data.equals(this.data)){  //d当前节点数据为要查询的数据
                return true;    //后面不再查询
            }
            else {
                if (this.next != null){
                    return this.next.bContainsNode(data);
                }
                else {
                    return false;
                }
            }
        }

        public Object getNode(int index){
            if (Link.this.foot ++ == index){
                return this.data;
            }
            else {
                return this.next.getNode(index);
            }
        }

        public void setNode(int index,Object data){
            if (Link.this.foot++ == index){
                this.data = data;  //进行内容的修改
            }
            else {
                this.next.setNode(index,data);
            }
        }
        /**
         * 专门处理非根节点的删除
         * 需要传递上一个节点以及要传递的数据
         * 实现通过判断数据是要删的节点
         * 还可能通过索引来删除数据
         */
        public void removeNode(Node preNode,Object data){
            if (data.equals(this.data)){
                preNode.next = this.next;
            }
            else { //如果当前节点不是 应该向后继续查询
                this.next.removeNode(this,data);
            }
        }

        /**
         * 实现内容的修改
         */
        public void toArrayNode(){
            Link.this.retArrays[Link.this.foot++] = this.data;
            if (this.next != null){
                this.next.toArrayNode();
            }
        }
    }

    /*  =============================以上为内部类===============================   */
    private Node rootNode;
    private int count = 0; //保存元素的个数
    private int foot; //表示
    private Object[] retArrays; //返回的数组
    /**
     * 实现增加元素
     * @param data
     */
    public void add(Object data) {
        Node newNode = new Node(data);
        if (this.rootNode == null) {   //表示当前没有根节点
            this.rootNode = newNode;
        } else {
            this.rootNode.addNode(newNode);
        }
        this.count++;
    }
    public int size() {
        return this.count;
    }

    /**
     * 判断链表是否为空
     * @return
     */
    public boolean isEmpty(){
        if (rootNode == null){
            System.out.println("链表为空！！！");
        }
        else {
            System.out.println("链表不为空！");
        }
        return true;
    }

    /**
     * 实现链表查询
     * 最简单的字符串查询，读取数据进行equals，不同的话判断下一个元素是否存在
     */
    public boolean bContains(Object data){
        //现在没有要查询的数据，根节点也没有保存数据
        if (data == null || this.rootNode ==null){
            return false;
        }
        return this.rootNode.bContainsNode(data);
    }

    public Object get(int index){
        if (index > this.count){
            return null;
        }
        this.foot = 0;
        return this.rootNode.getNode(index);
    }
    public void set(int index, Object data){
        if (index > this.count){
            return;
        }
        this.foot = 0;
        this.rootNode.setNode(index,data);
    }

    /**
     * 在Link类里面增加根节点的判断
     */
    public void remove(Object data){
        if (this.bContains(data)){
            //root是node类的对象，此处直接访问了内部类的私有操作
            //尝试不使用内部类实现
            if (data.equals(this.rootNode)){
                this.rootNode = this.rootNode.next;
            }
            else { //不是根节点
                //此时根元素已经判断过，从第二个
                this.rootNode.next.removeNode(this.rootNode,data);
            }
            this.count--;
        }
    }

    /**
     * 增加toArray方法
     */
    public Object[] toArray(){
        if (this.rootNode == null){
            return null;
        }
        this.foot = 0;  //需要脚标控制
        this.retArrays = new Object[this.count]; //根据保存内容开辟数组
        this.rootNode.toArrayNode();  //将节点转换为对象数组
        return this.retArrays;
    }
}
/**
 * 定义宠物的标准
 */
interface Pet{
    public String getName();
    public int getAge();
}

/**
 * 定义宠物商店
 */
class PetShop{
    private Link pets = new Link(); //保存宠物的信息
    public void add(Pet pet){   //宠物上架
        this.pets.add(pet);
    }
    public void delete(Pet pet){  //下架
        this.pets.remove(pet);
    }
    //模糊查询一定是返回多个内容
    public Link search(String keyWord){
        Link result = new Link();
        //将集合变为对象数组的形式返回 因为集合保存的是object
        //但是真正要查询的数据在pet接口对象的getName
        Object[] object = this.pets.toArray();
        for (int i = 0; i < object.length; i++){
            Pet pet = (Pet) object[i];
            if (pet.getName().contains(keyWord)){
                result.add(pet);
            }
        }
        return result;
    }
}

/**
 * 定义猫
 */
class Cat implements Pet{
    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null){
            return false;
        }
        if (!(o instanceof Cat)){
            return false;
        }
        Cat cat = (Cat) o;
        if (this.name.equals(cat.name) && this.age == cat.age){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Cat(String name, int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }
}

/**
 * 定义狗
 */
class Dog implements Pet{
    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null){
            return false;
        }
        if (!(o instanceof Dog)){
            return false;
        }
        Dog dog = (Dog) o;
        if (this.name.equals(dog.name) && this.age == dog.age){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Dog(String name, int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }
}