import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GAOBO
 * Date: 2020-03-21
 * Time: 8:33
 */
class Book {
    private String name;//书名
    private String author;//作者
    private int price;//价格

    private static int count = 0;

    static {
        /*this.name = "三国演义";
        this.author = "罗贯中";
        this.price = 12;
        在静态代码块当中  是不可以初始化普通的成员变量的  原因：static不依赖于对象的。
        */
        count = 199;
        System.out.println("静态代码块！");
    }

    {
        /*this.name = "三国演义";
        this.author = "罗贯中";
        this.price = 12;
        count = 99;*/
        System.out.println("实例代码块/构造代码块！");
    }

    public Book() {
        System.out.println("Book()");
    }

    public Book(String name, String author, int price) {
        this.name = name;
        this.author = author;
        this.price = price;
        System.out.println("Book(String,String,int)");
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("书名："+name + " 作者： "+author+" 价格： "+price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "书名：'" + name + '\'' +
                ", 作者：'" + author + '\'' +
                ", 价格：" + price +
                '}';
    }
}

public class TestDemo {

    public static void func(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static int sum(int a,int b) {
        return a+b;
    }

    public static int sum(int a,int b,int c) {
        return a+b+c;
    }

    //可变参数编程
    public static int sum(int... array) {
        int ret = 0;
        for (int x : array) {
            ret += x;
        }
        return ret;
    }

    

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println(sum(array));
        System.out.println(sum(new int[]{1, 2, 3, 4, 5, 6}));
        int ret = sum(1, 2, 3, 4, 5, 6);
        System.out.println(ret);
    }

    public static void main3(String[] args) {
        Book book = new Book("三国演义","罗贯中",90);
        //book.show();
        System.out.println(book);
        new Book().show();
        System.out.println("===============");
        String s = new Book().toString();
        System.out.println(s);
    }

    public static void main2(String[] args) {
        Book book = new Book();//实例化对象
        System.out.println(book.getName());

        System.out.println("===================");
        Book book2 = new Book();//实例化对象
    }

    public static void main1(String[] args) {
     /*   Book book = new Book();
        book.setName("bit");
        System.out.println(book.getName());
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();*/
    }
}
