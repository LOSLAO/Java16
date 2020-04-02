import java.util.Arrays;

public class TestDemo {


    //数组作为方法的返回值
    //写一个方法, 将数组中的每个元素都 * 2

    public static void main(String[] args) {
        int[] array = {1,2,3};
        int[] output = transform(array);
        printArray(output);
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length ; i++) {
            System.out.println(array[i]);
        }
    }

    public static int[] transform(int[] array) {
        int[] ret = new int[array.length];
        for (int i = 0; i < array.length ; i++) {
            ret[i] = array[i] * 2;
        }
        return ret;
    }


    public static int[] func2() {
        int[] array = {1,2,3,4,5,6};
        return array;
    }

    public static void main8(String[] args) {
        int[] ret = func2();
        System.out.println(Arrays.toString(ret));
    }

    //认识 null
    public static void main7(String[] args) {
        int[] array = null;
        System.out.println(array);
    }

    //交换两个数字

    public static void swap(int[] array2) {
        int tmp = array2[0];
        array2[0] = array2[1];
        array2[1] = tmp;
    }

    public static void main6(String[] args) {
        int[] array = {10,20};
        System.out.println(array[0]+" "+array[1]);
        swap(array);
        System.out.println(array[0]+" "+array[1]);
    }


    public static void main5(String[] args) {

        int a = 10;
        int b = 20;
        System.out.println(a+" "+b);
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println(a+" "+b);
    }

    public static void print(int[] array) {
        array[1] = 999;
        for (int i = 0; i < array.length ; i++) {
            System.out.print(array[i] +" ");
        }
        System.out.println();
    }

    public static void main4(String[] args) {
        int[] array2 = {1,2,3,4,5,6,7,8,9,10};
        print(array2);
        System.out.println("=============");
        System.out.println(Arrays.toString(array2));
    }

    // 数组作为方法的参数
    public static void print1(int[] array) {
        for(int i = 0; i < array. length; i++) {
            System.out.print(array[i] +" ");
        }
        System.out.println();
    }
    public static void main3(String[] args) {

        int[] array2 = {1,2,3,4,5,6,7,8,9,10};
        print(array2);


    }

    //获取长度 & 访问元素
    public static void main2(String[] args) {

        int[] array2 = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(array2.length);
        System.out.println(array2[0]);
        array2[0] = 888;
        System.out.println(array2[0]);
    }

     //数组打印方式
    public static void main1(String[] args) {
        int[] array1 = new int[3];//定义，但是没有初始化，但是默认值为0

        int[] array2 = {1,2,3,4,5,6,7,8,9,10};//定义且初始化了一个数组，数组大小为10

        int[] array3 = new int[] {1,2,3,4,5,6,7};//定义且初始化了一个数组，数组大小为7

        for(int i = 0; i < array2. length; i++) {
            System.out.print(array2[i] +" ");
        }
        System.out.println();
        System.out.println("=======for each=======");

        for (int i : array2) {
            System.out.print(i+" ");
        }
        //将数组内容以字符串的形式输出
        System.out.println();
        System.out.println("=======将数组内容以字符串的形式输出=======");

        System.out.println(Arrays.toString(array2));

    }
}
