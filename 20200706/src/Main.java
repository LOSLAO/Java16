import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        int count = 0;
        while (scanner.hasNextLine()) {
            String str1 = scanner.nextLine();
            mapDispose(map, str1);
        }
        for (String string : map.keySet()) {
            count++;
            if (count > (map.size() - 8)) {
                System.out.println(string + " " + map.get(string));
            }
        }
    }

    private static void mapDispose(Map<String, Integer> map, String str) {
        String[] strArr = str.split("\\s");
        String[] nameArr = strArr[0].split("\\\\");
        int num = Integer.parseInt(strArr[1]);
        String name = nameArr[nameArr.length - 1];
        if (name.length() > 16) {
            name = name.substring(name.length() - 16);
        }
        String key = name + " " + num;
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }

    }

    //开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        while (scanner.hasNext()) {
            String str = scanner.next();
            int lineNum = scanner.nextInt();
            String[] arr = str.split("\\\\");
            String s = arr[arr.length - 1];
            if (s.length() > 16) {
                s = s.substring(s.length() - 16);
            }
            String key = s + " " + lineNum;
            int value = 1;
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, value);
            }
        }
        int count = 0;
        for (String string : map.keySet()) {
            count++;
            if (count > map.keySet().size() - 8) {
                System.out.println(string + " " + map.get(string));
            }
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] words = str.split("\\s");
        for (int i = words.length - 1; i > 0; i--) {
            System.out.print(words[i] + " ");
        }
        System.out.println(words[0]);
    }
    //给定一句英语，要求你编写程序，将句中所有单词的顺序颠倒输出
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] words = str.split("\\s");
        for (int i = words.length - 1; i > 0; i--) {
            System.out.print(words[i] + " ");
        }
        System.out.println(words[0]);
    }
}
