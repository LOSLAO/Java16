


class A {
    public A(String str) {

    }
}


public class Test {
    public static void main(String[] args) {
        A classa = new A("he");
        A classb = new A("he");
        System.out.println(classa == classb);
    }
}
