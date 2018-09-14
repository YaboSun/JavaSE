package binarytree;

import java.util.Arrays;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(new Book("java",79.8));

        binaryTree.add(new Book("php",69.8));

        binaryTree.add(new Book("android",89.8));

        binaryTree.add(new Book("linux",99.8));

        Object[] object = binaryTree.toArray();
        System.out.println(Arrays.toString(object));
        for (int i = 0; i < object.length; i ++) {

        }
    }
}

class Book implements Comparable<Book> {
    private String title;
    private double price;

    public Book(String title,double price){
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "书名：" + this.title + " 价格：" + this.price;
    }

    @Override
    public int compareTo (Book o) {
        if (this.price > o.price) {
            return 1;
        }
        else if (this.price < o.price) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
class BinaryTree {
    private Node root; //定义根节点
    private int nCount; //保存元素个数
    private Object[] retData; //用于保存读取的数据
    private int foot; //表示数组脚表
    private class Node {
        private Comparable data; //排序的依据就是comparable
        private Node left;   //左子树
        private Node right;  //右子树
        public Node (Comparable data) {
            this.data = data;
        }

        /**
         * 新增节点
         * @param newNode
         */
        public void addNode (Node newNode){
            if (this.data.compareTo(newNode.data) < 0){
                if (this.left == null){
                    this.left = newNode;
                }
                else {
                    this.left.addNode(newNode);
                }
            }
            else {
                if (this.right == null){
                    this.right = newNode;
                }
                else {
                    this.right.addNode(newNode);
                }
            }
        }

        /**
         * 实现取出节点保存
         */
        public void toArrayNode() {
            if (this.left != null) {    //表示有左节点
                this.left.toArrayNode();
            }
            BinaryTree.this.retData[BinaryTree.this.foot ++] = this.data;
            if (this.right != null) {    //表示有右节点
                this.right.toArrayNode();
            }
        }
    }

    /**
     * 进行数据的增加
     * @param object
     */
    public void add(Object object) {
        Comparable comparable = (Comparable) object;  //必须变为Comparable才可以实现node的保存
        Node newNode = new Node(comparable);  //创建新的节点
        if (this.root == null){   //表示现在不存在根节点
            this.root = newNode;  //保存根节点
        }
        else {
            this.root.addNode(newNode);
        }
        this.nCount ++;
    }

    /**
     * 实现数据的取出
     * @return
     */
    public Object[] toArray() {
        if (this.root == null) {
            return null;
        }
        this.foot = 0;
        this.retData = new Object[this.nCount];
        this.root.toArrayNode();
        return this.retData;
    }

}