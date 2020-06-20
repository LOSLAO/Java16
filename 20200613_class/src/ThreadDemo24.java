


public class ThreadDemo24 {
    static class BlockingQueue {
        private int[] array = new int[1000];
        private volatile int head = 0;
        private volatile int tail = 0;
        //head和tail构成的是一个前闭后开区间
        //当两者重合的时候，可能是表示队列空，也可能是表示队列满
        //为了区分空还是满，就需要额外引入一个size来表示。
        private volatile int size = 0;

        //阻塞队列的基本操作：
        //1.入队列
        //2.出队列

        public void put(int value) throws InterruptedException {
            synchronized (this) {
                while (size == array.length) {
                    wait();
                }

                //把value放到队尾即可
                array[tail] = value;
                tail++;
                if (tail == array.length) {
                    tail = 0;
                }
                size++;

                notifyAll();
            }
        }

        //出队列
        public int take() throws InterruptedException {
            int ret = -1;
            synchronized (this) {
                while (size == 0) {
                    this.wait();
                }

                ret = array[head];
                head++;
                if (head == array.length) {
                    head = 0;
                }
                size--;

                notifyAll();
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue();
        // 搞两个线程, 分别模拟生产者和消费者.
        // 第一次, 让给消费者消费的快一些, 生产者生产的慢一些.
        // 此时就预期看到, 消费者线程会阻塞等待. 每次有新生产的元素的时候, 消费者才能消费
        // 第二次, 让消费者消费的慢一些, 生产者生产的快一些.
        // 此时就预期看到, 生产者线程刚开始的时候会快速的往队列中插入元素, 插入满了之后就会阻塞等待.
        // 随后消费者线程每次消费一个元素, 生产者才能生产新的元素.
        Thread producer = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    try {
                        blockingQueue.put(i);
                        System.out.println("生产元素：" + i);
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        producer.start();

        Thread consumer = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        int ret = blockingQueue.take();
                        System.out.println("消费元素: " + ret);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        consumer.start();
    }
}
