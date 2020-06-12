


public class Example {


    String str = new String("hello");
    char[] ch = {'a', 'b'};

    public static void main1(String[] args) {
        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str + " and ");
        System.out.println(ex.ch);
    }

    private void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'c';
    }

}
