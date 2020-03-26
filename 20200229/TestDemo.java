

public class TestDemo {

	public static void main8(String[] args) {
		//short char
		short sh = 10;
		char ch = '高';
		//sh = (short)ch;
		ch = sh;
	}

	public static void main7(String[] args) {
		//byte char
		byte b = 10;
		char ch = '高';
		//char ch2 = 9;建议字符就是字符，不建议用整型
		ch = 
	}

	public static void main6(String[] args) {
		//String -> int
		String s1 = "12";
		int a = Integer.parseint(str);
		System.out.println(a);

	}


	public static void main5(String[] args) {
		//int -> String
		int a = 10;
		String s1 = a + "";
		System.out.println(s1);
		//String.valueOf->>将参数转化为字符串
		String s2 = String.valueOf(a);
		System.out.println(s2);

	}

	public static void main4(String[] args) {
		int a = 10;
		long b = 12L;
		long c = a+b;
		System.out.println(c);
	}

	public static void main3(String[] args) {
		byte a = 10;
		byte b = 12;
		byte c = (byte)(a+b);
		System.out.println(c);
	}

	public static void main2(String[] args) {
		int a = 10;
		boolean b = true;
		//a = b;
		//b = a;
		System.out.println(b);
	}

	public static void main1(String[] args) {
		int a = 10;
		double b = 12.5;
		//a = (int)b;
		b = a;
		System.out.println(b);
	}

	public static void main(String[] args) {
		int a = 10;
		long b = 20L;
		//a = (int)b;
		b = a;
		System.out.println(b);
	}
		
}