import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by hadoop on 18-10-9
 */
class GenericMemoryCellTest {

    @Test
    void read() {
        GenericMemoryCell<String, Integer> genericMemoryCell = new GenericMemoryCell<>();
        genericMemoryCell.setStoredValue("test");
        System.out.println(genericMemoryCell.read());
    }
}