public class Test {
    public static void main(String[] args) {
        System.out.println("return value of getValue(): " +
                getValue());
    }

    private static int getValue() {
        try {
            return 0;
        } finally {
            return 1;
        }
    }
}
