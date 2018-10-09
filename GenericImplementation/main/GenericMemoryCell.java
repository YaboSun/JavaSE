/**
 * Created by hadoop on 18-10-9
 *
 * 来自《数据结构与算法分析 java语言描述》
 */
public class GenericMemoryCell<AnyType, Anytype> {
    private AnyType storedValue;

    public AnyType getStoredValue() {
        return storedValue;
    }

    public void setStoredValue(AnyType storedValue) {
        this.storedValue = storedValue;
    }

    public AnyType read() {
        return storedValue;
    }
}
