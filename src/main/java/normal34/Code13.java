package normal34;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2024-08-22
 * 3211. 生成不含相邻零的二进制字符串
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个正整数 n。
 * <p>
 * 如果一个二进制字符串 x 的所有长度为 2 的
 * 子字符串
 * 中包含 至少 一个 "1"，则称 x 是一个 有效 字符串。
 * <p>
 * 返回所有长度为 n 的 有效 字符串，可以以任意顺序排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 3
 * <p>
 * 输出： ["010","011","101","110","111"]
 * <p>
 * 解释：
 * <p>
 * 长度为 3 的有效字符串有："010"、"011"、"101"、"110" 和 "111"。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 1
 * <p>
 * 输出： ["0","1"]
 * <p>
 * 解释：
 * <p>
 * 长度为 1 的有效字符串有："0" 和 "1"。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 18
 */
public class Code13 {

    public List<String> validStrings(int n) {
        //初始化结果列表
        List<String> result = new ArrayList<>();
        //初始化字符串
        StringBuilder str = new StringBuilder();
        //实现
        next(result, str, n);
        //返回
        return result;
    }

    //递归
    private void next(List<String> list, StringBuilder str, int n) {
        //如果越界
        if (str.length() > n) {
            //过
            return;
        }
        //如果正好是结果
        if (str.length() == n) {
            //记录
            list.add(str.toString());
            //过
            return;
        }
        //无论如何,都可以组装1
        str.append(1);
        //递归
        next(list, str, n);
        //回溯
        str.deleteCharAt(str.length() - 1);
        //如果满足加0条件
        if (str.length() == 0 || str.charAt(str.length() - 1) == '1') {
            //组黄0
            str.append(0);
            //递归
            next(list, str, n);
            //回溯
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {

    }

}
