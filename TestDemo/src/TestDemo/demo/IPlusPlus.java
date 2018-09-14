package demo;

public class IPlusPlus {
    public static void main(String[] args) {
        IPlusPlus inc = new IPlusPlus();
        int i = 0;
        inc.fermin(i);
        i= ++ i;
        System.out.println(i);

    }
    int fermin(int i){
        i++;
        ++i;
        return i;
    }
}
