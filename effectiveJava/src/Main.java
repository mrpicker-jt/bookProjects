public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println("Hello World!");
//        Integer[] data = {5, 3, 7, 2, 4, 6, 9, 1, null, null, null, null, null, 8, 10};
////        printCorrectNum(data, 0);
////        System.out.println();
////        printErrNum(data, 0);
        new B();
        Class<?> aClass = Class.forName(B.class.getName());
        aClass.newInstance();
    }

    private static void printCorrectNum(Integer[] data, int index) {
        Integer datum = data[index];
        if (datum == null) {
            return;
        }
        if (index * 2 + 1 < data.length) {
            printCorrectNum(data, index * 2 + 1);
        }
        System.out.print(datum + ",");
        if (index * 2 + 2 < data.length) {
            printCorrectNum(data, index * 2 + 2);
        }
    }

    private static void printErrNum(Integer[] data, int index) {
        Integer datum = data[index];
        if (datum == null) {
            return;
        }
        System.out.print(datum + ",");
        if (index * 2 + 1 < data.length) {
            printCorrectNum(data, index * 2 + 1);
        }
        if (index * 2 + 2 < data.length) {
            printErrNum(data, index * 2 + 2);
        }
    }


    static class A {
        static int x = printInit("A Class Init");

        A() {
            System.out.println("A Constructor x:" + x);
        }

        protected static int printInit(String word) {
            System.out.println(word);
            return 47;
        }
    }

    static class B extends A {
        static int y = printInit("B Class Init");

        B() {
            System.out.println("B Constructor y:" + y);
        }
    }

}
