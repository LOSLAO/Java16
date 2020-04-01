import java.util.Scanner;
import java.lang.Math;

public class HomeWork {

	// 输出一个整数的每一位.
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		if(n < 0) {
			System.out.println("-");
			n = -n;
		}
		while(n != 0) {
			int tmp = n % 10;
			System.out.println(tmp);
			n = n/10;
		}
	}

	//获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列。
	public static void main14(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for (int i = 31; i >= 1; i -= 2) {
			System.out.print (  ((n >>> i) & 1) + " "  );
		}

		System.out.println();

		for (int i = 30; i >= 0; i -= 2) {
			System.out.print (  ((n >>> i) & 1) + " "  );
		}

	}
	
	// 写一个函数返回参数二进制中 1 的个数 比如： 15 0000 1111 4 个 1
	//第二种方法
	public static void main13(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int count = 0;
		while(n != 0) {
			count++;
			n = n & (n-1);
		}
		System.out.println(count);
	}

	//第一种方法
	
	public static void main12(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int count = 0;
		while(n != 0) {
			if((n & 1) != 0) {
				count++;
			}
			n = n>>>1;
		}
		System.out.println(count);
	}

	//编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,密码错误， 可以重新输
    //入，最多输入三次。三次均错，则提示退出程序
    
    public static void main11(String[] args) {
    	Scanner scan = new Scanner(System.in);

    	int count = 3;
    	System.out.println("请输入正确的密码，您有三次机会!");
    	while(count != 0) {
    		System.out.println("请输入正确的密码:");
    		String password = scan.next();
    		if(password.equals("123456")) {
    			System.out.println("登陆成功!");
    			break;
    		}else {
    			count--;
    			System.out.println("登陆失败， 您还有 " + count + "次机会! ");
    		}
    	}
    }
   

	//求出0～999之间的所有“水仙花数”并输出。
	public static void main10(String[] args) {
		for (int i = 0; i <= 999999; i++) {
			int count = 0;
			int tmp = i;
			while(tmp != 0) {
				count++;
				tmp = tmp/10;
			}
			tmp = i;
			int sum = 0;
			while (tmp != 0) {
				sum += Math.pow(tmp%10,count);
				tmp = tmp/10;
			}
			if(sum == i) {
				System.out.println(sum + "是要找的数字！");
			}
		}

	}
	

	//编写程序数一下 1到 100 的所有整数中出现多少个数字9。
	public static void main9(String[] args) {
		int count = 0;
		for (int i = 1; i <= 100; i++) {
			if(i % 10 == 9) {
				count++;
			} else if(i / 10 == 9) {
				count++;
			  }
				
		}
		System.out.println("9的个数是: "+ count);

	}

	//计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
	public static void main8(String[] args) {
		double sum = 0;
		int flg = 1;
		for (int i = 1; i <= 100; i++ ) {
			sum = sum + 1.0/i * flg;
			flg = -flg;
		}
		System.out.println("输出sum "+ sum);
	}

	//求两个正整数的最大公约数
	public static void main7(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = a % b;
		while(c != 0) {
			a = b;
			b = c;
			c = a % b;
		}
		System.out.println("最大公约数是： "+ b);
	}

	////输出乘法口诀表
	public static void main6(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 1; i <= n ; i++ ) {
			for (int j = 1; j <= i ; j++ ) {
				System.out.print(i+"*"+j+"="+i*j +" ");
			}
			System.out.println();
		}
	}

	

	//输出 1000 - 2000 之间所有的闰年
	public static void main5(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for (int i = 1000; i <= n ; i++ ) {
			if(i%4 == 0 && i%100 != 0 || i%400 == 0) {
				System.out.println(i + " 是闰年 ");
			}
		}
	}

	//打印 1 - 100 之间所有的素数
	public static void main4(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for (int num = 1; num <= n ; num++ ) {
			int i;
			for (i = 2; i <= Math.sqrt(num); i++) {
				if(num % i == 0) {
					break;
				}
			}
			if(i > Math.sqrt(num)) {
				System.out.println(num + " 是素数 ");
			}
		}
	}
			

	//判定一个数字是否是素数
	//优化的方法
	public static void main3(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int i;
		for (i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0) {
				break;
			}
		}
		if(i > Math.sqrt(n)) {
			System.out.println(n + " 是素数 ");
		}
	}


	public static void main2(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int i;
		for (i = 2; i <= n/2; i++) {
			if(n % i == 0) {
				break;
			}
		}
		if(i > n/2) {
			System.out.println(n + " 是素数 ");
		}
	}


	//根据年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
	public static void main1(String[] args) {
		Scanner scan = new Scanner(System.in);
		int oldYear = scan.nextInt();

		if(oldYear <= 18) {
			System.out.println("少年");
		}else if (oldYear >= 19 && oldYear <= 28) {
			System.out.println("青年");
		}else if(oldYear >= 29 && oldYear <= 55) {
			System.out.println("中年");
		}else {
			System.out.println("老年");
		}
	}
}