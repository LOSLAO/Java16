import java.util.Scanner;
public class TestDemo {

	/**
	 * void:代表当前方法，没有返回值
	 * addSum：方法名；--》采用小驼峰-》addSum
	 * (int n) : 形式参数列表
	 *
	 * 注意事项：
	 * 1、实参给形参传递是按照值传递。
	 * 2、实参和形参的类型需要匹配。
	 * 3、参数的个数需要匹配
	 * 4、一般情况下，不建议在方法内进行直接的打印
	 * 5、返回值-》方法给你的一个响应。接收这个响应。
	 * 6、返回什么样的类型 ，需要用什么要的类型来接收他！
	 * 场景：8*（1到100的和）
	 * @param n [description]
	 */
	public static int addSum(int num) {
		int sum = 0;
		for (int i = 1;i <= num ; i++) {
			sum = sum +i;
		}
		//System.out.println(sum);只是输出，计算机根本没有保存下来这个值。
		return sum;//计算机已经记录了你当前的和  响应
	}

	//写一个方法：求两个数的最大值。
	//再写一个方法：求3个数的最大值。
	public static int max2(int a,int b) {
		/*int max = a >= b ? a : b;
		//表达式1 ?  表达式2 ： 表达式3
		return max;*/
		return a >= b ? a : b;
	}

	public static int max3(int a,int b,int c) {
		/*int m = max2(a,b);//a和b的最大值
		int n = max2(m,c);
		return n;*/
		/*int max = max2(max2(a,b),c);
		return max;*/
		return max2(max2(a,b),c);
	}
	/**
	 * 1!+2!+3!+4!+5!
	 * @param  n [description]
	 * @return   [description]
	 */
	public static int facSum1(int n) {
		int sum = 0;//存放阶乘和
		//产生每个数字
		for (int i = 1;i <= n ;i++ ) {
			//产生的每个数字i的阶乘
			int ret = 1;//每次存放的是每个数字的阶乘
			for (int j = 1;j <= i ;j++ ) {
				ret = ret*j;
			}
			sum = sum + ret;
		}
		return sum;
	}

	public static int facSum(int n) {
		int sum = 0;//存放阶乘和
		//产生每个数字
		for (int i = 1;i <= n ;i++ ) {
			//把每个数字的阶乘求出来  然后加起来
			sum = sum + fac(i);
		}
		return sum;
	}
	/**
	 * 求数字n的阶乘
	 * @param  n [description]
	 * @return   [description]
	 */
	public static int fac(int n) {
		int ret = 1;//每次存放的是每个数字的阶乘
		for (int j = 1;j <= n ;j++ ) {
			ret = ret*j;
		}
		return ret;
	}

	public static void function() {
		System.out.println("I am cool!" );
		return;
		//System.out.println("I am very cool!" );
		//不建议在return后边写其他的代码
	}


	public static void main(String[] args) {
		function();
	}

	public static void main1(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n1 = scan.nextInt();//10  回车
		//int n2 = scan.nextInt();//20
		int ret = facSum(n1);
		System.out.println("阶乘和 ："+ret);

		//int n3 = scan.nextInt();//20

		//int ret = max3(n1,n2,n3);
		//System.out.println("最大值："+ret);

		//main方法结束之后  整个程序就全部结束了  shift+tab <-   tab->
		//double n = 14.9;
		//int ret = addSum(n);
		///System.out.println(6/ret);
	}
}