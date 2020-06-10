


public class ThreadDemo8 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("我在偷偷玩电脑呢");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                System.out.println("关电脑");
            }
        };
        t.start();
        Thread.sleep(5000);
        System.out.println("你妈回来了，快关电脑");
        t.interrupt();
    }
}
