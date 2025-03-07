package normal3;

import java.util.*;

/**
 * Created By Rock-Ayl on 2021-05-05
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Code13 {

    //结果集
    List<List<Integer>> result = new ArrayList<>();

    //计算
    public void count(List<Integer> list, Stack<Integer> stack) {
        //如果没有要组装的了
        if (stack.size() == 0) {
            //记录
            result.add(list);
        }
        //循环
        for (Integer integer : stack) {
            //克隆
            List<Integer> newList = new ArrayList<>(list);
            //组装
            newList.add(integer);
            //克隆
            Stack<Integer> newStack = (Stack<Integer>) stack.clone();
            //删除
            newStack.remove(integer);
            //下一级
            count(newList, newStack);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        //初始化
        Stack<Integer> stack = new Stack<>();
        //循环
        for (int num : nums) {
            //组装
            stack.add(num);
        }
        //开始统计
        count(new ArrayList<>(), stack);
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (List<Integer> list : new Code13().permute(new int[]{1, 2, 3})) {
            for (Integer integer : list) {
                System.out.print(integer+",");
            }
            System.out.println();
        }
    }
}
