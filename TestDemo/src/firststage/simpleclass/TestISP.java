package firststage.simpleclass;

/**
 *主要是双向一对多问题的解决
 */
class Item{
    private int nItemID;
    private String strItemName;
    private String strItemDes;

    private SubItem[] subItems;
    private Product[] products;
    public Item(int nItemID,String strItemName,String strItemDes){
        this.nItemID = nItemID;
        this.strItemName = strItemName;
        this.strItemDes = strItemDes;
    }

    public void setSubItems(SubItem[] subItems) {
        this.subItems = subItems;
    }

    public SubItem[] getSubItems() {
        return subItems;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public Product[] getProducts() {
        return products;
    }

    public String getInfo(){
        return "栏目编号： " + this.nItemID + "栏目名称: " + this.strItemName + "描述： " + this.strItemDes;
    }
}

class SubItem{
    private int nSubIteID;
    private String strSubIteName;
    private String strSubIteDes;

    private Product[] products;
    private Item item;
    public SubItem(int nSubIteID,String strSubIteName,String strSubIteDes){
        this.nSubIteID = nSubIteID;
        this.strSubIteName = strSubIteName;
        this.strSubIteDes = strSubIteDes;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public Product[] getProducts() {
        return products;
    }

    public String getInfo(){
        return "子栏目编号: " + this.nSubIteID + " 子栏目名称: " + this.strSubIteName + " 子栏目描述: " + this.strSubIteDes;
    }
}

class Product{
    private int nProID;
    private String strProName;
    private double dProPrice;

    private Item item;
    private SubItem subItem;

    public Product(int nProID,String strProName,double dProPrice){
        this.nProID = nProID;
        this.strProName = strProName;
        this.dProPrice = dProPrice;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setSubItem(SubItem subItem) {
        this.subItem = subItem;
    }

    public SubItem getSubItem() {
        return subItem;
    }

    public String getInfo(){
        return "商品编号: " + this.nProID + " 商品名称: " + this.strProName + " 商品价格: " + this.dProPrice;
    }
}

public class TestISP {
    public static void main(String[] args){
        Item item = new Item(010,"食物","主要用于日常生活食物");
        SubItem subItem1 = new SubItem(001,"饮料","-");
        SubItem subItem2 = new SubItem(002,"面食","-");
        SubItem subItem3 = new SubItem(003,"水果","-");
        Product producta = new Product(201801,"可口可乐",2.5);
        Product productb = new Product(201802,"面包",3.5);
        Product productc = new Product(201803,"香蕉",4.5);

        subItem1.setItem(item);
        subItem2.setItem(item);
        subItem3.setItem(item);
        item.setSubItems(new SubItem[]{subItem1,subItem2,subItem3});
        producta.setItem(item);
        productb.setItem(item);
        productc.setItem(item);
        producta.setSubItem(subItem1);
        productb.setSubItem(subItem2);
        productc.setSubItem(subItem3);
        subItem1.setProducts(new Product[]{producta});
        subItem2.setProducts(new Product[]{productb});
        subItem3.setProducts(new Product[]{productc});
        item.setProducts(new Product[]{producta,productb,productc});

        System.out.println(item.getInfo());
        for (int i = 0; i < item.getSubItems().length; i++){
            System.out.println(item.getSubItems()[i].getInfo());
        }
        System.out.println("-----------");

        System.out.println(item.getInfo());
        for (int i = 0; i < item.getProducts().length; i++){
            System.out.println(item.getProducts()[i].getInfo());
        }
    }
}
