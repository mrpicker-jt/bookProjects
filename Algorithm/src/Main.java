import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // ArrayList Queue TreeSet HashMap

        NullPointerException nullPointerException;
        IndexOutOfBoundsException indexOutOfBoundsException;
        IOException ioException;
        RuntimeException runtimeException;
        Exception exception;

        System.out.println("Hello World!");
        B b = new B();
//        A a=null;
//        System.out.println(a.y);
    }

    static class A {
        static int x = printInit("A  class init");
        int y=0;
        A() {
            System.out.println("A constructor init");
        }

        protected static int printInit(String s) {
            System.out.println(s);
            return 47;
        }
    }

    static class B extends A {
        static int x = printInit("B  class init");

        B() {
            System.out.println("B constructor init");
        }
    }


}
