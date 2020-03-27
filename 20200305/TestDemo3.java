import java.util.Scanner;
/**
 * 循环：就是重复做一件事情
 * for
 * while
 * do while
 * 
 * foreach
 */
public class TestDemo3 {



	public static void main(String[] args) {

		//死循环
		/*while(true) {
			System.out.print ("16班的孩子很可爱！");
		}*/
		//表达式2是可以省略的  for循环的死循环
		/*for( ;  ; ) {
			System.out.print ("16班的孩子很可爱！");
		}*/
		//死循环
		do {
			System.out.print ("16班的孩子很可爱！");
		}while (true);
		/*int i = 0;
		do {
			System.out.print ("16班的孩子很可爱！");
			i++;
		}while (i >= 0);*/

		//ctr+shift+/
		/*
		for (int i = 1; i < 100; i++) 
		for (int k = 10;k <= 200; k++)
		for (int j = k; j <= k;j++ )
			if (j == 45)
				if()
		*/
			


		/*for(int i = 1;i <= 100;i++) {
			System.out.print (i + " ");
		}


		System.out.println ("=========");
		int i = 1;
		while(i <= 100) {
			System.out.print (i + " ");
			i++;
		}*/
	}

	/**
	 * 找到 100 - 200 中所有 3 的倍数
	 * @param args [description]
	 */
	public static void main7(String[] args) {
		int i = 100;
		while(i <= 200) {
			if(i % 3 != 0) {
				i++;
				continue;
			}
			System.out.println(i);
			i++;
		}
	}

	/**
	 * 找到 100 - 200 中第一个 3 的倍数
	 * @param args [description]
	 */
	public static void main6(String[] args) {
		int i = 100;
		while(i <= 200) {
			if(i % 3== 0) {
				System.out.println(i);
				break;
			}
			i++;
		}
	}

	/**
	 * break:结束所有循环      
	 * continue:结束本趟循环 
	 * 共同特性：一定要用在循环内
	 * switch() {  }  
	 * @param args [description]
	 */


	public static void main5(String[] args) {
		int a = 10;
		int i = 1;
		while (i <= a) {
			if( i == 2) {
				//break;
				continue;
			}
			System.out.println(i);
			i++;
		}
		
	}

	/**
	 * 求1！+2！+3！+4！+5！+......n! = ?
	 * @param args [description]
	 */
	public static void main4(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		//1!+2!+3! = 1+2 +6 = 9 
		int ret = 1;
		int j = 1;
		int sum = 0;
		while ( j <= n  ) {
			int i = 1;
			ret = 1;
			while (i <= j) {
				//求阶乘j!	
				ret = ret * i;
				i++;
			}

			sum = sum + ret;
			j++;
		}

		System.out.println("阶乘" + sum);
	}


	/**
	 * n的阶乘！
	 * 5  5*4*3*2*1
	 *
	 * 求1！+2！+3！+4！+5！+......n! = ?
	 * @param args [description]
	 */
	public static void main3(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int i = 1;//控制循环
		int ret = 1;//存放结果
		while (i <= n) {
			ret = ret * i;
			i++;
		}
		System.out.println("阶乘" + ret);
	}

	/**
	 * 1-100的和
	 * @param args [description]
	 */

	public static void main2(String[] args) {
		int i = 1;
		int sum = 0;
		while (i <= 100) {
			sum += i;//sum = sum+i;
			i++;
		}
		System.out.println("和 " +sum);

		//计算1-100偶数的和
		i = 2;
		int sumEve = 0;//偶数的和
		while(i <= 100) {
			sumEve += i;
			i += 2;
		}
		System.out.println("偶数的和 " + sumEve);
		
		//计算1-100奇数的和
		i = 1;
		int sumOdd = 0;//奇数的和
		while(i <= 100) {
			sumOdd += i;
			i += 2;
		}
		System.out.println("奇数的和 " + sumOdd);
	}

	/**
	 * while(表达式)  表达式-》布尔表达式
	 * {   循环体;    }
	 *
	 * 只打印1-10
	 * @param args [description]
	 */

	public static void main1(String[] args) {
		int num = 5;
		int i = 1;
		while(i <= num) {
			System.out.print(i+" ");
			i++;//i = i+1;
		}
	}

}
