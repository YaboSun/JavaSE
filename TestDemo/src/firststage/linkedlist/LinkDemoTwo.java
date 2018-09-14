package linkedlist;

/**
 * 链表的基本操作特点
 * 1、客户端不用去关注具体的Node以及引用关系细节，只关注提供的数据
 * 2、Link类的主要功能是控制Node类对象的产生和根节点
 * 3、Node类主要负责数据的保存以及引用关系的分配
 */
public class LinkDemoTwo {
    public static void main(String[] args){
        Link link = new Link();//由这个类负责所有的数据操作
        link.addData("Hello World");
        link.addData("nihao shijie");
        link.addData("nice to meet ");
        link.print();   //展示数据
    }
}

class NodeTwo{
    private String strData; //要保存的数据
    private NodeTwo next; //要保存的下一个节点
    //每一个node；类对象都必须保存有相应的数据
    public NodeTwo(String strData){
        this.strData = strData;
    }
    public void setNext(NodeTwo next){
        this.next = next;
    }
    public NodeTwo getNext(){
        return this.next;
    }
    public String getStrData(){
        return this.strData;
    }
    //实现节点的添加
    //第一次调用(Link发出)： this = Link.rootNode
    //第二次调用（NodeTwo递归）：  this = Link.root.next
    //。。。一直递归
    public void addNode(NodeTwo newNode){
        if (this.next == null){      //当前节点的下一个
            this.next = newNode;
        }
        else {     //当前节点之后还存在有节点
            //当前节点的下一个节点继续保存
            this.next.addNode(newNode);
        }
    }
    //第一次调用（Link） this = Link.root
    //第二次调用（Node） this = Link.rot.next
    public void printNode(){
        System.out.println(this.strData);//输出当前节点数据
        if (this.next != null){ //现在还有下一个节点
            this.next.printNode();
        }
    }
}

/**
 * 负责数据的设置和输出
 * 需要进行node类对象的关系处理
 */
class Link{
    public Link(){
    }
    private NodeTwo rootNode; //根节点

    //增加数据
    public void addData(String strData){
        //为了可以确定先后关系，需要在NodeTwo类中包含data关系
        NodeTwo newNode = new NodeTwo(strData);
        //保存当前数据的时候还没有根节点
        if (this.rootNode == null){
            this.rootNode = newNode;  //将新的节点设置为根节点
        }
        else {    //根节点已经存在
            //从root节点之后找到合适的位置
            this.rootNode.addNode(newNode);
        }
    }
    //输出数据
    public void print(){
        if (this.rootNode != null){
            this.rootNode.printNode();
        }
    }
}
