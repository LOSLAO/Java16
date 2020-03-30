import java.util.Scanner;
public class TestDemo2 {
	/**
	 * 实参和形参的关系
	 * 明白一个道理：
	 * 
	 * 在Java当中实际上 只有按值传递。
	 * 但是这个值，可以是普通的值  也可以是引用类型(指针-》保存地址)
	 * 
	 * @param args [description]
	 */
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		System.out.println(a+"：交换前："+b);
		swap(a,b);
		System.out.println(a+" "+b);
	}

	public static void swap(int a,int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}
}