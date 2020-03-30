import java.util.Scanner;
public class TestDemo4 {
	/**
	 * 递归：
	 * 1、求1-10的和。用递归解决。
	 * 1+2+3+4+5+6+7+8+9+10
	 * @param args [description]
	 */
	public static void main(String[] args) {
		int ret = fac(5);
		System.out.println(ret);
	}

	public static int fac(int n) {
		if(n == 1) {
			return 1;
		}
		return n * fac(n-1);
	}



	public static int sum(int n) {
		//n == 1就是终止条件
		/*if(n == 1) {
			return 1;
		}*/
		int tmp =  n + sum(n-1);
		return tmp;
	}


	public static int sum1(int n) {
		int ret = 0;
		for (int i=1;i <= n ; i++) {
			ret += i;
		}
		return ret;
	}
}