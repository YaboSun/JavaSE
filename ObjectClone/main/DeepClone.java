/**
 * Created by hadoop on 18-9-14
 */
public class DeepClone implements Cloneable{
    private int testPar;
    private DeepCloneSecond deepCloneSecond;

    public DeepCloneSecond getDeepCloneSecond() {
        return deepCloneSecond;
    }

    public void setDeepCloneSecond(DeepCloneSecond deepCloneSecond) {
        this.deepCloneSecond = deepCloneSecond;
    }

    public int getTestPar() {
        return testPar;
    }

    public void setTestPar(int testPar) {
        this.testPar = testPar;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        DeepClone deepClone = null;
        try {
            deepClone = (DeepClone)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        deepClone.deepCloneSecond = (DeepCloneSecond)deepCloneSecond.clone();
        return deepClone;
    }
}

class DeepCloneSecond implements Cloneable{
    /** 用于测试的第二个参数 */
    private String secondTestPar;

    public String getSecondTestPar() {
        return secondTestPar;
    }

    public void setSecondTestPar(String secondTestPar) {
        this.secondTestPar = secondTestPar;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        DeepCloneSecond dcs = null;
        try {
            dcs = (DeepCloneSecond)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return dcs;
    }
}
