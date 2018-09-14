package simpleclass;

class Province{
    private int nProID;
    private String strProName;
    private City[] cities;

    public Province(int nProID,String strProName){
        this.nProID = nProID;
        this.strProName = strProName;
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }

    public City[] getCities() {
        return cities;
    }

    public String getInfo(){
        return "省份ID: "+this.nProID + " 省份名称: " + this.strProName;
    }
}
class City{
    private int nCityID;
    private String strCityName;
    private Province province;
    public City(int nCityID, String strCityName){
        this.nCityID = nCityID;
        this.strCityName = strCityName;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Province getProvince() {
        return province;
    }

    public String getInfo(){
        return "城市ID: " + this.nCityID + "城市名称: " + this.strCityName;
    }
}
public class TestProvinceCity {
    public static void main(String[] args){
        Province province = new Province(01,"湖北省");
        City city1 = new City(1,"武昌");
        City city2 = new City(2,"汉口");
        City city3 = new City(3,"汉阳");
        city1.setProvince(province);
        city2.setProvince(province);
        city3.setProvince(province);
        province.setCities(new City[]{city1,city2,city3});
        province.getInfo();
        System.out.println(city1.getProvince().getInfo());
        for (int i = 0; i < province.getCities().length; i++){
            System.out.println(province.getCities()[i].getInfo());
        }
    }
}
