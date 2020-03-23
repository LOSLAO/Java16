
/*

块注释
1、每个java文件当中只能有一个public类，且
这个类名，一定要和文件名相同。

2、编码-》文本当中utf-8编码 

   javac  ->  默认是以GBK进行编码

javac -encoding utf-8 HelloWorld.java

3、java的main函数，
有一个参数：String[] args-》数组-》字符串数组
作用是什么？百度考过一个问题：
回答：命令行参数  当在运行java程序的时候，
java HelloWorld     gaobo is cool
运行时命令行参数

4、
System.out.println();输出语句，输出且换行
System.out.print();  输出不换行
System.out.printf("%d",10); 格式化输出

5、为什么main函数是用static关键字修饰的？比较难得！
类和对象

6、编码格式-》《阿里巴巴规约手册》

7、正式面试的时候-》写代码-》全程观看你写代码的规范。
   类名-》大驼峰-》Test -》HelloWorld

8、System.out.println("HelloWorld");
    双引号引起来的就是一个字符串

通过main函数-》
1.了解程序的执行
2.了解程序的编码规范

数据类型和运算符
1、变量和类型
变量：肯定会占用我的内存。
变量名：-》标识符

2、《阿里巴巴规约手册》-》
标识符构成-》数字，字母，下划线，$
a.数字-》不能开头
b.变量名-》采用小驼峰命名规则-》maxNum
c.虽然下划线和$符可以开头，
但是《阿里巴巴规约手册》指出，不建议开头。

合法但是不合理

3、定义的局部变量，如果没有给初始值，老铁啊！
那么java是不能够编译通过滴！！
int num;
System.out.println(num);//程序编译不能通过。
体现了Java的安全性

4、int->整型-》4个字节-》32 bit位
            -2^31 -> 2^31-1

    long->长整型-》8个字节-》64bit
            -2^63 -> 2^63-1

 */

/*
块注释
 */

/**
 *
 *文档注释
 * 
 */
//行注释 
class Test {
	
}

public class HelloWorld {

	public static void main(String[] args) {

		long num = 10L;
		System.out.println(num);

		System.out.println(Long.MAX_VALUE+1);
		System.out.println(Long.MIN_VALUE);
		 
		/*
		int num = 0;//变量-》局部变量-》
		System.out.println(num);
		//Integer.MAX_VALUE  能够拿到int类型的最大值
		System.out.println(Integer.MAX_VALUE+1);
		//System.out.println(Integer.MIN_VALUE);

		   ctr+shift+/ 取消一样的方式
		int ____ = 20;//变量-》局部变量-》
		System.out.println(____);
		int __ = 30;//变量-》局部变量-》
		System.out.println(__);*/
	}

	/*
	public static void main(String[] args) {
		//打印args数组当中的数据
		for(int i = 0;i < args.length;i++) {
			System.out.print(args[i]+" ");
		}

		System.out.println("HelloWorld");
	}
	*/

}
