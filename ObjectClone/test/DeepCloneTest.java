import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by hadoop on 18-9-14
 */
class DeepCloneTest {

    @Test
    void cloneTest() {
        DeepCloneSecond deepCloneSecond = new DeepCloneSecond();
        deepCloneSecond.setSecondTestPar("深度克隆");
        DeepClone deepClone = new DeepClone();
        deepClone.setTestPar(12345);
        deepClone.setDeepCloneSecond(deepCloneSecond);

        try {
            DeepClone deepClone1 = (DeepClone)deepClone.clone();
            System.out.println("deepClone：" + deepClone.getTestPar() + ",测试参数2：" + deepClone.getDeepCloneSecond().getSecondTestPar());
            System.out.println("deepClone1：" + deepClone1.getTestPar() + ",测试参数2：" + deepClone.getDeepCloneSecond().getSecondTestPar());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}