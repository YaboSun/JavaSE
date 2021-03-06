package simpleclass;

/**
 * 谁的构造函数就是调用谁的方法
 */
public class Test {
    public static void main(String[] args){
        //int[] a = {2,4,4};
        System.out.println(new B().getValue());
    }
    static class A{
        protected int value;
        public A(int v){
            setValue(v);
        }
        public void setValue(int value){
            this.value = value;
        }

        public int getValue() {
            try {
                value++;
                return value;
            }
            finally {
                this.setValue(value);
                System.out.println(value);
            }
        }
    }
    static class B extends A{
        public B(){
            super(5);
            setValue(getValue()-3);
        }

        @Override
        public void setValue(int value) {
            super.setValue(2*value);
        }
    }
}


