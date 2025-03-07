package easy5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-01-21
 * 119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 * <p>
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class Code21 {

    public static List<Integer> getRow(int rowIndex) {
        rowIndex++;
        //初始化三角
        List<List<Integer>> result = new ArrayList<>();
        //初始化1行
        List<Integer> init = new ArrayList<>();
        //第一行初始化
        init.add(1);
        //记录
        result.add(init);
        //当前位置
        int p = 2;
        //循环
        while (p <= rowIndex) {
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
        return result.get(rowIndex - 1);
    }

    public static void main(String[] args) {
        for (Integer integer : getRow(10)) {
            System.out.println(integer);
        }
    }
}
