package fib;

public class Fib {
    int a = 0;
    int b = 1;

    public int fibonacci() {
        a = b;
        b = a + b;
        return a;
    }

    public static void main(String[] args) {
        Fib b = new Fib();
        System.out.println(b.fibonacci());
        System.out.println(b.fibonacci());
        System.out.println(b.fibonacci());
        System.out.println(b.fibonacci());
        System.out.println(b.fibonacci());
        System.out.println(b.fibonacci());
//        1
//        2
//        4
//        8
//        16
//        32
    }
}
