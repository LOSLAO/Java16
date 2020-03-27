import java.util.Scanner;

/**
 * 逻辑控制
 * 在任何的语言，他的构成，逻辑。
 * 顺序结构-》没问题的   过
 * 分支结构-》没问题的   过
 * if     switch
 * 循环结构
 */

public class TestDemo2 {
	/**
	 * switch (表达式) { case  break   }
	 * switch:开关
	 * 墙裂建议：如果没有特殊的需求
	 * 每个case后面最好加上一个break
	 * 
	 * 问题：
	 * 不能做switch的参数的有哪些类型？
	 * byte  short  int   char   String   枚举  
	 * 
	 * long  boolean  double  float 不可以
	 * @param args [description]
	 */

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//int n = scan.nextInt();
		long n = 10L;
		switch (n) {
			case 8:
			   System.out.println("3");
			   break;
			/*case 'a':
			   System.out.println("1");
			   break;//直到遇到下一个break才会结束*/
			case 7:
			   System.out.println("2");
			   break;
			default :
				System.out.println("输入有误！");
			   break;
		}
	}

	public static void main7(String[] args) {
		int x = 10;
		int y = 10;
		if (x == 20) {
			if (y == 10) {
				System.out.println("aaa");
			}
			else{
				System.out.println("bbb");
			}
		}

	}

	/**
	 * 闰年:
	 * 如果他可以整除4但是不能被100整除
	 * 或者可以被400整除
	 * 一旦和数学沾边：脑子就懵了  
	 * 最大公约数
	 * @param args [description]
	 */
	public static void main6(String[] args) {
		Scanner scan = new Scanner(System.in);
		int year = scan.nextInt();
		if((year%4==0) && (year%100!=0) || (year%400==0)) {
			System.out.println("当前"+year+"是闰年！");
		}
	}


	public static void main5(String[] args) {
		Scanner scan = new Scanner(System.in);
		//循环读取  怎么停下来：
		//1.ctr+c   中断
		//2.ctr+z   正常停止
		while (scan.hasNext()) {
			int n = scan.nextInt();
			if(n > 0) {
				System.out.println("当前数字是正数！");
			}else if(n < 0){
				System.out.println("当前数字是负数！");
			}else {
				System.out.println("当前数字是0！");
			}
		}
	}

	/**
	 * 读入一个数字，判断该数字是奇数还是偶数
	 * @param args [description]
	 */
	public static void main4(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		if(n % 2 == 0) {
			System.out.println("当前数字是偶数！");
		}else {
			System.out.println("当前数字是奇数！");
		}

	}

	public static void main3(String[] args) {
		int a = 10;
		if(a == 20) {
			System.out.println("a == 10");//1
			System.out.println("a == 10!");//2
		}else { 
			System.out.println("else");//3    4
		}
	}

	public static void main2(String[] args) {
		int a = 10;
		//在C语言里面：0是假  非0是真 
		//但是在java里面，真就是true  假就是false
		if(a == 20) {
			//两个等号
			System.out.println("a == 20");
		}else if(a == 8){
			System.out.println("a == 8");
		}else {
			System.out.println("a != 8 && a != 20");
		}

	}

	public static void main1(String[] args) {
		//顺序结构
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		System.out.println("4");
		System.out.println("5");
	}

}