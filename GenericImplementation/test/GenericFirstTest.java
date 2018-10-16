import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by hadoop on 18-10-9
 */
class GenericFirstTest {

    GenericFirst genericFirst = new GenericFirst();
    @Test
    void printList() {
        List<String> list = new ArrayList<String>();
        list.add("qqyumidi");
        list.add("corn");
        /**
         * 这里在编译时候没有问题，但是运行时候会出现class cast exception
         * 但是如果给泛型加上<>就可以在编译时候直接判断不符合
         */
        // list.add(100);
        genericFirst.printList(list);

    }
}