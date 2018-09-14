import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by hadoop on 18-9-14
 */
class ShadowCloneTest {

    @Test
    void cloneTest() {
        try {
            ShadowClone shadowClone1 = new ShadowClone();
            shadowClone1.setTestPra(12345);
            ShadowClone shadowClone2 = (ShadowClone)shadowClone1.clone();

            System.out.println("测试参数1：" + shadowClone1.getTestPra());
            System.out.println("测试参数2：" + shadowClone2.getTestPra());

            shadowClone2.setTestPra(54321);
            System.out.println("测试参数1：" + shadowClone1.getTestPra());
            System.out.println("测试参数2：" + shadowClone2.getTestPra());

            // assertTrue(shadowClone1 == shadowClone2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}