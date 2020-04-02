
import java.util.Arrays;


public class TestDemo2 {

    //数组练习

    /**
     * 数组的拷贝
     * 1.for
     *
     * 2.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
     * Object-->是所有类的父类
     * src:源数组
     * srcPos:源数组的开始拷贝的下标
     * dest:目的数组
     * destPos:拷贝到目的数组的这个下标
     * length:拷贝多大
     *
     * 3. Arrays.copyOf(int[] original, int newLength )
     * 底层调用的方法是：System.arraycopy
     *
     * 4.了解：clone()-->Object
     *
     * 总结：
     * 以上四种拷贝方式 全部都是浅拷贝
     * 如果数组当中的元素是简单类型，那么它是深拷贝
     * 如果数组当中存放的是引用类型，那么他就是浅拷贝
     *
     * @param array
     * @return
     */

    public static int[] copyArray(int[] array) {
        int[] ret = new int[array.length];
        for (int i = 0; i < array.length ; i++) {
            ret[i] = array[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};

        int[] ret = array.clone();
        System.out.println(Arrays.toString(ret));

        /*int[] ret = Arrays.copyOf(array,array.length);
        System.out.println(Arrays.toString(ret));*/

        /*int[] dest = new int[array.length];
        //拷贝更快一点：native方法
        System.arraycopy(array, 0,dest, 0,array.length);
        System.out.println(Arrays.toString(dest));*/

        /*int[] ret = copyArray(array);
        System.out.println(Arrays.toString(ret));*/
    }

    //我们实现一个自己版本的数组转字符串
    public static String myTOString1(int[] array) {
        String ret = "[";
        for (int i = 0; i < array.length ; i++) {
            ret += array[i];
            if(i != array.length-1) {
                ret += ", ";
            }
        }
        ret += "]";
        return ret;
    }

    public static void main1(String[] args) {
        int[] array = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(array));
    }
}
