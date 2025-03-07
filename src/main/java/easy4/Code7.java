package easy4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2020-12-09
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * 通过次数139,452提交次数200,469
 */
public class Code7 {

    public static List<List<Integer>> generate(int numRows) {
        //初始化三角
        List<List<Integer>> result = new ArrayList<>();
        //判空
        if (numRows == 0) {
            //缺省
            return result;
        }
        //初始化1行
        List<Integer> init = new ArrayList<>();
        //第一行初始化
        init.add(1);
        //记录
        result.add(init);
        //当前位置
        int p = 2;
        //循环
        while (p <= numRows) {
            //上一行
            List<Integer> lastList = result.get(result.size() - 1);
            //当前行
            List<Integer> thisList = new ArrayList<>();
            //循环
            for (int i = 0; i < p; i++) {
                //如果是两边
                if (i == 0 || i + 1 == p) {
                    //为1
                    thisList.add(1);
                } else {
                    //获取上一行左
                    int left = lastList.get(i - 1);
                    //获取上一行右
                    int right = lastList.get(i);
                    //求和
                    int sum = left + right;
                    //为0
                    thisList.add(sum);
                }
            }
            //记录
            result.add(thisList);
            //叠加
            p++;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (List<Integer> list : generate(5)) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
