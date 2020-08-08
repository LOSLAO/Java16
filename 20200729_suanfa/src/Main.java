import java.util.ArrayList;

public class Main {
    //汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
    //对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移
    //3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
    //解法1：
    //保存第一个，剩下的整体前移一个，第一个放在最后，完成一次移动，一次能移动，多次也可以
    public String LeftRotateString1(String str,int n) {
        if (str.length() == 0 || n == 0) {
            return str;
        }
        n %= str.length();
        char[] list = str.toCharArray();
        while (n > 0) {
            n--;
            LeftRotateStringHelper1(list);
        }
        return new String(list);
    }

    private void LeftRotateStringHelper1(char[] list) {
       char temp = list[0];
       int i = 0;
       for (; i < list.length - 1; i++) {
           list[i] = list[i+1];
       }
       list[i] = temp;
    }

    //解法二：局部逆置，在整体逆置
    public String LeftRotateString(String str,int n) {
        if (str.length() == 0 || n == 0) {
            return str;
        }
        n %= str.length();
        char[] list = str.toCharArray();
        Reverse1(list, 0, n-1);
        Reverse1(list, n, str.length() - 1);
        Reverse1(list, 0, str.length() - 1);
        return new String(list);
    }

    private void Reverse1(char[] list, int start, int end) {
        while (start < end) {
            char temp = list[start];
            list[start] = list[end];
            list[end] = temp;
            start++;
            end--;
        }
    }

    //公司最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇
    //感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把
    //句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助
    //他么？
    public String ReverseSentence(String str) {
        if (str.length() == 0 || str == null) {
            return str;
        }
        char[] list = str.toCharArray();
        int len = list.length;
        int i = 0;
        int j = i;
        while (i < len) {
            while (i < len && !Character.isSpace(list[i])) {
                i++;
            }
            Reverse1(list, j, i-1);
            while (i < len && Character.isSpace(list[i])) {
                i++;
            }
            j=i;
        }
        Reverse1(list, j, i-1);
        Reverse1(list, 0, i-1);
        return new String(list);
    }




}
