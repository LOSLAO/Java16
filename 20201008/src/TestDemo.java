import java.util.ArrayList;
import java.util.List;

public class TestDemo {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("helloworld");
        System.out.println(stringBuffer.reverse());
    }

    public static void main1(String[] args) {
        String str = "helloworld";
        System.out.println(str.substring(5));
        System.out.println(str.substring(1, 5));
    }

    public List<List<Integer>> generate1(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if (numRows == 1) {
            return result;
        }
        List<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if (numRows == 2) {
            return result;
        }
        for (int cow = 3; cow <= numRows; cow++) {
            List<Integer> prevLine = result.get(cow - 1 - 1);
            List<Integer> curLine = new ArrayList<>();
            curLine.add(1);
            for (int col = 2; col < cow; col++) {
                int curNum = prevLine.get(col - 1) + prevLine.get(col - 1 - 1);
                curLine.add(curNum);
            }
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if (numRows == 1) {
            return result;
        }
        List<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if (numRows == 2) {
            return result;
        }
        for (int row = 3; row <= numRows; row++) {
            List<Integer> prevLine = result.get(row - 1 - 1);
            List<Integer> curLine = new ArrayList<>();
            curLine.add(1);
            for (int col = 2; col < row; col++) {
                int curNum = prevLine.get(col - 1) + prevLine.get(col - 1 - 1);
                curLine.add(curNum);
            }
            curLine.add(1);
            result.add(curLine);
        }

        return result;
    }
}
