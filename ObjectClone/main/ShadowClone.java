/**
 * Created by hadoop on 18-9-14
 */
public class ShadowClone implements Cloneable{
    private int testPra;

    public int getTestPra() {
        return testPra;
    }

    public void setTestPra(int testPra) {
        this.testPra = testPra;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ShadowClone shadowClone = null;
        try {
            shadowClone = (ShadowClone)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return shadowClone;
    }
}
