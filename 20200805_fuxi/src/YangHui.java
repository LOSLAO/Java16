import java.util.ArrayList;
import java.util.List;

public class YangHui {
    public List<List<Integer>> generate(int numRows) {
        //杨辉三角的特点：
        //1.第一行固定，就是1
        //2.第二行也固定，两个1
        //3.第i行，收尾元素都是1
        //4.第i行有第i个元素
        //5.对于第i行来说，第j列的值是i-1行j-1列的值加上i-1行j列
        //的值
        if (numRows <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        //1.先准备第一行，就只有一个元素
        List<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if (numRows == 1) {
            return result;
        }
        //2.第二行只有两个元素都是1
        List<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if (numRows == 2) {
            return result;
        }
        //3.第i行有第i列
        //  （i，j) = (i-1,j)+(i-1, j-1)
        //   第一个元素和最后一个元素都是1
        for (int row = 3; row <= numRows; row++) {
            //如果想知道row行的情况，需要先知道row-1行的内容
            List<Integer> prevLine = result.get(row-1-1);
            //此处的row-1代表上一行，再减一是下标，因为是从1开始数的
            List<Integer> curLine = new ArrayList<>();
            curLine.add(1);
            for (int col = 2; col < row; col++) {
                //第row行应该有row列，下面这个循环相当于循环了row-2次
                //第一列和最后一列都是1，不参与循环
                int curNum = prevLine.get(col-1-1) + prevLine.get(col-1);
                curLine.add(curNum);
            }
            //最后处理该行的最后一个1
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }
}
