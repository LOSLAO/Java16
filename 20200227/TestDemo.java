
/*
1、Java的起源。历史。
2、Java的main方法。
   static：
3、标识符的定义：数字 字母 下划线 $
   不建议用_开头或者数字 $
4、int是4个字节-》1个字节8bit   4byte = 32bit;
bit  byte   kb  mb  gb  tb   pb
   8     1024
程序员节：10月24日

 */

public class TestDemo {

	public static void main(String[] args) {
		int a = 10;
		System.out.println(a);
		a = 99;
		System.out.println(a);
		System.out.println("=============");
		final int SIZE = 200;
		//SIZE = 100; error
		System.out.println(SIZE);

		final int SIZE2;
		SIZE2 = 100;
		//SIZE2 = 3300;error
		System.out.println(SIZE2);
	}

	public static void main10(String[] args) {
		int a = 10;
		{
			System.out.println(" {} " + a);
		}
		System.out.println(a);

	}

	public static void main9(String[] args) {
		//在屏幕上打印出   "hello"  \  ->转义  \"==>"
		String s = "\\hello\\";  // "hello"
		System.out.println(s);
	}

	public static void main8(String[] args) {
		//字符串类型  C：没有字符串类型的 char *p = "abcdef";
		//String 
		String s = "abcdef";
		System.out.println(s);//abcdef
		
		int a = 10;
		System.out.println("a = " + a);// a == 10

		int c = 20;
		System.out.println( a + c);//30
		System.out.println("a+c = " + a + c);//a+c = 1020
		System.out.println("a+c = " + (a + c));//

		System.out.println("a = " + a +",c = "+ c);

		
		System.out.println("a+c = " + a + " " + c);//a+c = 10 20

		//+  =>拼接  如果是(字符串 + 任意数据类型)-》整体字符串
		double d = 12.5;
		System.out.println("gaobo = " + d);//gaobo = 12.5
	}

	public static void main7(String[] args) {
		//布尔类型  boolean  JVM并没有规定其大小   只有两个取值
		//true  false   在Java当中 没有所谓的0就是假  非0就是真这个概念
		//Java里面真有一个那就是true  假只有一个那就是false
		//C : 弱类型语言    Java：强类型语言
		boolean b = true;
		System.out.println(b);
		
	}

	public static void main6(String[] args) {
		//短整型   short   2  -32768‬ -  32767
		short s = 32767;
		System.out.println(s);
		System.out.println(Short.MAX_VALUE);
	}

	public static void main5(String[] args) {
		//字节类型   byte   1  -2^7  -  2^7-1
		//-128   127
		//
		//总结来说，给变量赋值的时候，赋值的值不能够超过
		//其能够表达的范围
		
		byte b = 127;
		System.out.println(b);

		//如果进行直接赋值，就是把一个越界的数字给对应的类型
		//这种情况下会报错。
		int c = 214748364;
		System.out.println(c);

		int a = Integer.MAX_VALUE+1;
		System.out.println(a);
		System.out.println(Integer.MAX_VALUE+1);
	}


	public static void main4(String[] args) {
		//字符型    2     C: asscii字符集  Java：Unicode字符集
		char c = 'a';
		System.out.println(c);
		int d = c ; 
		System.out.println(d);

	}

	public static void main3(String[] args) {
		//单精度浮点类型   4   字面值
		float f = 12.5f;
		System.out.println(f);
		double a = 1.0D;
		System.out.println(a);
	}

	public static void main2(String[] args) {
		//双精度浮点类型   8
		double a = 1.0;
		double b = 2.0;
		//两个整型如果相除，并不会保存小数
		System.out.println(a/b);

		//double 小数其实在程序当中，其实存储方式不一样的。
		//需要精度。
		double c = 1.1;
		double d = 1.1;
		System.out.println(c*d);
		//以后写项目的时候，出现小数最好用double

	}

	public static void main1(String[] args) {
		int a = 10;//局部变量-》一定要初始化
		System.out.println("a = " + a);//a == 10
		
		long b = 20L;//8
		System.out.println("b = " + b);

		double d = 12.5;//8
		System.out.println("d = " + d);
	}
}

