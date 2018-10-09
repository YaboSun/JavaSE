import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 18-10-9
 *
 * 泛型问题的引出--为什么需要泛型
 * 如下代码实现了一种最原始的泛型
 * 但是存在俩个问题
 */
public class GenericFirst {

    public void printList(List list) {
        for (int i = 0; i < list.size(); i++) {
            String name = (String) list.get(i);
            System.out.println("name:" + name);
        }
    }
}
