public class ThreadLocalTest {

    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        @Override
        public Integer initialValue() {
            return 0;
        }
    };

    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    private static class TestClient extends Thread {
        private ThreadLocalTest threadLocalTest;

        public TestClient(ThreadLocalTest threadLocalTest) {
            this.threadLocalTest = threadLocalTest;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("thread[" + Thread.currentThread().getName()
                        + "] sn[" + threadLocalTest.getNextNum() + "]");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        TestClient t1 = new TestClient(threadLocalTest);
        TestClient t2 = new TestClient(threadLocalTest);
        TestClient t3 = new TestClient(threadLocalTest);

        t1.start();
        t2.start();
        t3.start();
    }
}
