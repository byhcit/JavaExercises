package site.debug;

public class Debug05 {
    public static void main(String[] args) {
        test("thread-1");
        test("thread-2");
    }

    public static void  test(String threadName){
        new Thread(()-> System.out.println(Thread.currentThread().getName()),threadName).start();
    }
//public static void main(String[] args) {
//    test("Thread1");
//    test("Thread2");
//}
//    public static void test(String threadName) {
//        new Thread(
//                () -> System.out.println(Thread.currentThread().getName()),
//                threadName
//        ).start();
//    }
}
