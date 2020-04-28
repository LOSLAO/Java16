import java.util.ArrayList;
import java.util.List;

//杨辉三角
public class TestList {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0) {
            return result;
        }
        //处理第一行的情况，只有一个一
        ArrayList<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if(numRows == 1) {
            return result;
        }
        //处理第二行的情况 只有两个一
        ArrayList<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if(numRows == 2) {
            return result;
        }
        //第i行的规律
        //第一列和最后一列都是1
        //有第i行就有第i列；
        //i, j = (i - 1, j - 1) + (i - 1, j)
        for(int row = 3; row <= numRows; row++) {
            //构造第row行的内容，依赖于第row-1行的内容
            List<Integer> prevLine = result.get(row-1-1);
            List<Integer> curLine = new ArrayList<>();
            curLine.add(1);
            for(int col = 2; col <= row - 1; col++) {
                // 要计算 第 col 列的值, 需要知道上一行的 col - 1 列和 col 列.
                // 由于 col 是从 1 开始算的. 换算成 List 下标还得再 - 1
                int tmp1 = prevLine.get(col-1-1);
                int tmp2 = prevLine.get(col-1);
                curLine.add(tmp1+tmp2);
            }
            curLine.add(1);
            result.add(curLine);
        }
        return result;

    }
}
