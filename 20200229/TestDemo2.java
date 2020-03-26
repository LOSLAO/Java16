
public class TestDemo2 {

	public static void main(String[] args) {
        int i = 10;
        i = i++;//c:11 java:10
        System.out.println(i);//11
    }

	public static void main5(String[] args) {
        int i = 10;
        int a = ++i;//i = i+1;a = i;
        System.out.println(a);//11
        System.out.println(i);//11
    }

	public static void main4(String[] args) {
        int i = 10;
        int a = i++;//a = i; i = i+1;
        System.out.println(a);//10
        System.out.println(i);//11
    }



	public static void main3(String[] args) {
        System.out.println(5/0);
		//-1
	}

	public static void main2(String[] args) {
        System.out.println(10%3);//1
		System.out.println(10%-3);//1
		System.out.println(-10%3);//-1
		System.out.println(-10%-3);//-1
	}

	public static void main1(String[] args) {
        System.out.println(5/2);//2
		System.out.println(5.0/2);//2.5
		System.out.println(5/2.0);//2.5
		System.out.println(5.0/2.0);//2.5
	}
}