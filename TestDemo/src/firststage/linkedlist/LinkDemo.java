package firststage.linkedlist;
//每一个链表实际上是由多个节点组成
class Node{
    private String strData; //要保存的数据
    private Node next; //要保存的下一个节点
    //每一个node；类对象都必须保存有相应的数据
    public Node(String strData){
        this.strData = strData;
    }
    public void setNext(Node next){
        this.next = next;
    }
    public Node getNext(){
        return this.next;
    }
    public String getStrData(){
        return this.strData;
    }
}
public class LinkDemo {
    public static void main(String[] args){
        //第一步：准备出所有数据
        Node root = new Node("根节点");
        Node n1 = new Node("第一个子节点");
        Node n2 = new Node("第二个子节点");
        root.setNext(n1);
        n1.setNext(n2);

        //第二步： 取出所有数据
        print(root);
/*//第一种方法
        Node currentNode = root;//表示当前从根节点开始读取
        while (currentNode != null){//表示当前节点存在有数据
            System.out.println(currentNode.getStrData());
            //将下一个节点设置为当前节点
            currentNode = currentNode.getNext();
        }
*/
    }
    /**
     * 第二种方法
     * 使用递归的方法
     */
    public static void print(Node current){
        if (current == null){      //递归的结束条件
            return;
        }
        System.out.println(current.getStrData());
        print(current.getNext());
    }
}
