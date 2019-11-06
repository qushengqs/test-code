public class DeadLock {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        new Thread(() -> {
            try {
                resource1();
            } catch (InterruptedException ex) {

            }

        }).start();

        new Thread(()->{
            try{
                resource2();
            }catch (InterruptedException ex ){

            }
        }).start();
    }

    public static void resource1() throws InterruptedException {
        synchronized ("resource1") {
            System.out.println("获取资源1");
            Thread.sleep(1000);

            resource2();
        }
    }

    public static void resource2() throws InterruptedException {
        synchronized ("resource2") {
            System.out.println("获取资源2");
            Thread.sleep(1000);

            resource1();
        }
    }
}
