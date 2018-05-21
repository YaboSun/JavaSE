package firststage.linkedlist;

/**
 * 链表类 外部能看到的只有这一个类
 */

/**
 * 2018.4.21更新 将原本类型转化为object
 */
class LinkThree {
    /**
     * 定义的一个节点类
     * 之所以要定义在内部主要让其为link类服务
     */
    private class InnerNode {
        private Object strData; //保存数据
        private InnerNode next; //引用关系

        public InnerNode(Object strData) {
            this.strData = strData;
        }

        public void addNode(InnerNode innerNode) {
            if (this.next == null) { //表示当前节点为空
                this.next = innerNode;
            } else {
                this.next.addNode(innerNode);
            }
        }
        public boolean bContainsNode(Object strData){
            if (strData.equals(this.strData)){  //d当前节点数据为要查询的数据
                return true;    //后面不再查询
            }
            else {
                if (this.next != null){
                    return this.next.bContainsNode(strData);
                }
                else {
                    return false;
                }
            }
        }

        public Object getNode(int index){
            if (LinkThree.this.foot ++ == index){
                return this.strData;
            }
            else {
                return this.next.getNode(index);
            }
        }

        public void setNode(int index,Object strData){
            if (LinkThree.this.foot++ == index){
                this.strData = strData;  //进行内容的修改
            }
            else {
                this.next.setNode(index,strData);
            }

        }

        /**
         * 专门处理非根节点的删除
         * 需要传递上一个节点以及要传递的数据
         * 实现通过判断数据是要删的节点
         * 还可能通过索引来删除数据
         */
        public void removeNode(InnerNode preNode,Object strData){
            if (strData.equals(this.strData)){
                preNode.next = this.next;
            }
            else { //如果当前节点不是 应该向后继续查询
                this.next.removeNode(this,strData);
            }
        }

        /**
         * 实现内容的修改
         */
        public void toArrayNode(){
            LinkThree.this.strRetArrays[LinkThree.this.foot++] = this.strData;
            if (this.next != null){
                this.next.toArrayNode();
            }
        }
    }

    /*  =============================以上为内部类===============================   */
    private InnerNode innerRootNode;
    private int count = 0; //保存元素的个数
    private int foot; //表示
    private Object[] strRetArrays; //返回的数组
    /**
     * 实现增加元素
     * @param strData
     */
    public void add(Object strData) {
        InnerNode newNode = new InnerNode(strData);
        if (this.innerRootNode == null) {   //表示当前没有根节点
            this.innerRootNode = newNode;
        } else {
            this.innerRootNode.addNode(newNode);
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
        if (innerRootNode == null){
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
        if (data == null || this.innerRootNode ==null){
            return false;
        }

        return this.innerRootNode.bContainsNode(data);
    }

    public Object get(int index){
        if (index > this.count){
            return null;
        }
        this.foot = 0;
        return this.innerRootNode.getNode(index);
    }
    public void set(int index, Object strData){
        if (index > this.count){
            return;
        }
        this.foot = 0;
        this.innerRootNode.setNode(index,strData);
    }

    /**
     * 在Link类里面增加根节点的判断
     */
    public void remove(Object strData){
        if (this.bContains(strData)){
            //root是node类的对象，此处直接访问了内部类的私有操作
            //尝试不使用内部类实现
            if (strData.equals(this.innerRootNode.strData)){
                this.innerRootNode = this.innerRootNode.next;
            }
            else { //不是根节点
                //此时根元素已经判断过，从第二个
                this.innerRootNode.next.removeNode(this.innerRootNode,strData);
            }
            this.count--;
        }
    }

    /**
     * 增加toArray方法
     */
    public Object[] toArray(){
        if (this.innerRootNode == null){
            return null;
        }
        this.foot = 0;  //需要脚标控制
        this.strRetArrays = new Object[this.count]; //根据保存内容开辟数组
        this.innerRootNode.toArrayNode();  //将节点转换为对象数组
        return this.strRetArrays;
    }
}
public class LinkDemoThree {
    public static void main(String[] args){
        LinkThree linkThree = new LinkThree();
        /**
         * 输入数据
         */
        linkThree.add("sf");
        linkThree.add("123");
        linkThree.add("sfsf");

        /**
         * 测试功能
         */
        linkThree.remove("123");
        Object[] data = linkThree.toArray();
        for (int i = 0; i < data.length; i++){
            System.out.println(data[i]);
        }
    }
}

/**
 * 链表有关常用方法
 * public void add(数据类型 变量) 向链表之中增加新的数据
 * public int size()  取得链表中保存的元素个数
 * public boolean isEmpty()  判断是否是空链表
 * public boolean contains(数据类型 变量)  判断某一个数据是否存在
 * public 数据类型 get(int index) 根据索引取得数据
 * public void set(int index,数据类型 变量) 使用新的内容替换掉指定索引的内容
 * public void remove(数据类型 变量) 删除指定的数据，如果是对象，要进行对象比较
 * 对于删除数据而言，眼删除的数据分为两种情况：
 * 情况一：根节点数据则root应该指向根节点.next Link类才关心根节点，所以此种情况要在Link类中实现
 * 情况二：要删除的不是根节点 当前节点上一节点next = 当前节点next 删除的不是根节点 而是普通节点 应该在node类中处理
 * public 数据类型[] toArray 将链表变为对象数组
 */