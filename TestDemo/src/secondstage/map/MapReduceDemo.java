package map;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;

class ShopCar {
    private String pName;
    private int amout;
    private double price;

    public ShopCar(String pName, int amout, double price) {
        this.pName = pName;
        this.amout = amout;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getAmout() {

        return amout;
    }

    public String getpName() {

        return pName;
    }

}
public class MapReduceDemo {
    public static void main(String[] args) throws Exception {
        List<ShopCar> all = new ArrayList<>();
        all.add(new ShopCar("水壶", 15, 20));
        all.add(new ShopCar("水杯", 30, 10));
        all.add(new ShopCar("手镯", 15000, 20));
        DoubleSummaryStatistics doubleSummaryStatistics = all.stream().mapToDouble((shopCar -> shopCar.getAmout() * shopCar.getPrice())).summaryStatistics();
        System.out.println(doubleSummaryStatistics);
    }
}
