import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by hadoop on 18-10-9
 */
class GenericFirstTest {

    GenericFirst genericFirst = new GenericFirst();
    @Test
    void printList() {
        List list = new ArrayList();
        list.add("qqyumidi");
        list.add("corn");
        // list.add(100); 这里在编译时候没有问题，但是运行时候会出现class cast exception
        genericFirst.printList(list);
    }
}