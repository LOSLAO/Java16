
import java.util.Scanner;
import java.io.IOException;
import java.util.Random;
public class TestDemo {

	public static void main(String[] args) {
		//每次产生随机数都是按照这个long类型数字产生的
		Random  random = new Random(1234);

		int rand = random.nextInt(100);//[0-100)->[0-99]

		System.out.println("rand : " + rand);
	}

	/**
	 * 猜数字的小游戏
	 *
	 * 
	 * @param args [description]
	 */
	public static void main5(String[] args) {
		Scanner scan = new Scanner(System.in);

		//1、生成一个随机数 Random
		Random  random = new Random();

		int rand = random.nextInt(100);//[0-100)->[0-99]

		while (true) {
			System.out.println("请输入你要猜的数字：");
			int num = scan.nextInt();
			if(num > rand) {
				System.out.println("你猜的数字大了");
			}else if (num == rand) {
				System.out.println("猜对了！");
				break;
			}else {
				System.out.println("你猜的数字小了");
			}
		}

		System.out.println("游戏结束了！");

	}


	/**
	 * 每日一题：
	 * 10个选择题，两个代码题，牛客网
	 * 全真模拟真实的笔试环境。
	 * 很多公司，都在线上进行笔试！！！
	 * 200--》卷子  网上-》需要熟悉网上的环境。
	 *
	 * 网上答题时候有很多注意事项：
	 * 代码要跑过，要完全匹配他的输入和输出。
	 * a b c d
	 * abcd
	 * IDEA  可以跑过  但是牛客跑不过
	 *
	 * 循环输入：
	 * 在网上答题的时候，人家背后自己会做这个事情 
	 * 你无需care
	 * 
	 * @param args [description]
	 */
	public static void main4(String[] args) {
		Scanner scan = new Scanner(System.in);
		//如果还有下一个就输出  循环输入
		while(scan.hasNext()) {
			int n = scan.nextInt();
			System.out.println("整型："+ n);
		}

		System.out.println("哈哈哈哈!");

	}


	/**
	 * 有关Scanner的注意事项：
	 * 1、使用之前需要导入包java.util.Scanner;
	 * 2、输入的内容一定要和当前的内容匹配。
	 * 3、
	 * @param args [description]
	 */
	public static void main3(String[] args) {
		//资源
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println("整型："+ n);
		String name = scan.nextLine();//遇到空格结束了
		System.out.println("姓名："+ name);

		scan.close();

		/*int n = scan.nextInt();
		System.out.println("整型："+ n);
		String name = scan.next();
		System.out.println("姓名："+ name);
		double d = scan.nextDouble();
		System.out.println("小数："+ d);*/
	}


	/**
	 * 不建议使用：
	 * 1、太麻烦
	 * 2、功能有局限性
	 * @param args [description]
	 */
	public static void main2(String[] args) {
		System.out.println("请输入一个字符：");
		try {
			char ch = (char)System.in.read();
			System.out.println(ch);
		}catch(IOException e) {
			System.out.println("程序发生异常了！");
		}

	}



	public static void main1(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		System.out.println("输出且换行！");
		System.out.print("输出但是不换行！");

		System.out.printf("%s\n","格式化输出！");
		System.out.printf("%d\n",n);
		System.out.printf("%x\n",100);//
	}
}