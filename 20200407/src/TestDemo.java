
import java.lang.reflect.Field;

//认识String类

public class TestDemo {
    public static void main(String[] args) {
        String str1 = "haha";
        String str2 = "HaHa";
        System.out.println(str1.equals(str2));//false
        System.out.println(str1.equalsIgnoreCase(str2));//true 忽略大小写
        System.out.println(str1.compareTo(str2));

    }

    public static void main8(String[] args) {
        char[] array = {'h', 'a', 'h', 'a'};
        String str = new String(array);
        //System.out.println(str);//haha
        char[] array2 = str.toCharArray();
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }
        System.out.println("===============");
        //charAt 获取到某个下表对应的字符
        //System.out.println(str.charAt(0));
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
    }

    public static void main7(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //通过反射修改String的值
        String str = "haha";
        //需要先根据“value”这个名字找到str中内部储存的value数组
        //1.获取到String对象的图纸（进一步了解到String里面的细节）
        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        //2.根据图纸找到str里面的value数组
        char[] value = (char[])field.get(str);
        //3.然后在修改这个数组的内容即可
        value[0] = 'a';
        System.out.println(str);
    }

    public static void main6(String[] args) {
        //字符串是不可变对象（对象的值不可改变）
        String str = "haha";
        str = "heihei";//这个修改 修改的是String引用中保存的地址，而不是修改字符串的值
        System.out.println(str);
    }

    public static void main5(String[] args) {
        String str1 = "haha";
        //intern方法 可以主动去池子中查找，看看当前这个String是否在池中存在
        //如果在池中不存在，就把这个String加入到池中
        //如果已经存在，就可以舍弃当前对象，直接获取到池中的对应对象的引用
        String str2 = new String("haha").intern();
        System.out.println(str1 == str2);//true
    }

    public static void main4(String[] args) {
        String str1 = "haha";
        String str2 = "haha";
        String str3 = "haha";
        String str4 = "haha";
        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
        System.out.println(str3 == str4);
    }

    public static void main3(String[] args) {
        String str1 = null;
        //System.out.println(str1.equals("haha"));
        System.out.println("haha".equals(str1));//更推荐这种写法
    }

    public static void main2(String[] args) {
        //字符串比较相等
        //对于引用类型来说 ==比较的是对象的身份（对比两个引用中保存的地址是否一样）
        String str1 = "haha";
        String str2 = new String("haha");
        String str3 = "haha";
        System.out.println(str1 == str2);//false
        System.out.println(str1 == str3);//true
        //要想比较内容(值），需要使用equals方法；
        System.out.println(str1.equals(str2));//true
        System.out.println(str1.equals(str3));//true
    }

    public static void main1(String[] args) {
        //创建String类
        String str1 = "haha";//更推荐
        String str2 = new String("haha");
        char[] buffer = {'a', 'b', 'c'};
        String strs = new String(buffer);
        System.out.println(str1);
    }
}
