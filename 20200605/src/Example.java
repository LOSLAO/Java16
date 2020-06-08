


public class Example {



    public static void main3(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operate(a, b);
        System.out.println(a+ "." +b);

    }

    private static void operate(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
    }

    public static void main2(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("2");
            }
        });
        t.start();
        t.join();
        System.out.println("1");
    }

    String str = new String("good");
    char[]ch = {'a', 'b', 'c'};

    public static void main1(String[] args) {
        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str + "and");
        System.out.println(ex.ch);
    }

    private void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'g';
    }

}
