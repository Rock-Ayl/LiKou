package normal4;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-07-09
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Code15 {

    //结果
    List<List<Integer>> result = new ArrayList<>();
    //组
    int[] arr;
    int k;

    public void dfs(List<Integer> list, int p) {
        //如果满足条件了
        if (list.size() == k) {
            //记录
            result.add(new ArrayList<>(list));
        }
        //循环
        for (int i = p; i < arr.length; i++) {
            //当前数字
            int num = arr[i];
            //组装
            list.add(num);
            //下一级
            dfs(list, i + 1);
            //删除最后一个
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        //组
        this.arr = new int[n];
        //指针
        int p = arr.length - 1;
        //循环
        while (n > 0) {
            //组装
            arr[p--] = n--;
        }
        //不断组装
        dfs(new ArrayList<>(), 0);
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (List<Integer> list : new Code15().combine(4, 2)) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }

}
