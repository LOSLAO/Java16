import java.util.Scanner;
public class TestDemo3 {
	/**
	 * 面试问题：
	 * 重载(overlaod):
	 * 重写(override):
	 * 重载和重写有什么区别？
	 *
	 * 重载-->  一个类当中
	 * 1、方法名相同 
	 * 2、参数列表不相同(参数的个数或者参数的类型)
	 * 3、返回值不做要求
	 * @param args [description]
	 */
	
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int ret = add(a,b);
		System.out.println("两个数的和是：" + ret);

		/*double c = 12.5;
		double d = 13.4;
		double ret2 = add(c,d);
		System.out.println("两个数的和是：" + ret2);*/
	}

	public static int add(int a,int b) {
		return a+b;
	}

	/*public static long add(int a,int b) {
		return a+b;
	}*/

	public static int add(int a,int b,int c) {
		return a+b+c;
	}

	public static double add(double a,double b) {
		return a+b;
	}

	

}