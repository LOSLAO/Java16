




public class TestDemo {
    public static void main(String[] args) {
        System.out.println(10 > 20 && 10 / 0 == 0); // 打印 false
        System.out.println(10 < 20 || 10 / 0 == 0); // 打印 true
    }

    public static void main5(String[] args) {
        int a = 10;
        int b = 20;
        int c = 30;
        System.out.println(a < b || b < c);
    }
    public static void main4(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(a == b);
        System.out.println(a != b);
        System.out.println(a < b);
        System.out.println(a > b);
        System.out.println(a <= b);
        System.out.println(a >= b);
    }
    public static void main3(String[] args) {
        int i = 10;
        i = i++;
        System.out.println(i);//10
    }
    public static void main2(String[] args) {
        int a = 10;
        int b = ++a;//先加加，则a=11，则b=a=11;
        System.out.println(b);//11
        int c= a++;//先赋值再加加，则c=a=11, a = 12
        System.out.println(c);//11
    }
    public static void main1(String[] args) {
        int a = 10;
        int b = 0;
        System.out.println(a / b);


    }


}
