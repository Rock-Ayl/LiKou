package normal22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-07-14
 * 剑指 Offer II 087. 复原 IP
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * <p>
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 * <p>
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 * <p>
 * 输入：s = "10203040"
 * 输出：["10.20.30.40","102.0.30.40","10.203.0.40"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 * <p>
 * <p>
 * 注意：本题与主站 93 题相同：https://leetcode-cn.com/problems/restore-ip-addresses/
 */
public class Code2 {

    //结果
    private List<String> result = new ArrayList<>();

    //list转为ip
    private String listToIp(LinkedList<Integer> list) {
        //初始化
        StringBuilder str = new StringBuilder();
        //循环
        for (Integer num : list) {
            //组装
            str.append(num);
            str.append(".");
        }
        //删除最后一个
        str.deleteCharAt(str.length() - 1);
        //返回
        return str.toString();
    }

    //递归实现
    private void next(char[] wordArr, int p, LinkedList<Integer> list) {
        //如果越界了
        if (p >= wordArr.length) {
            //如果当前满足条件
            if (list.size() == 4) {
                //转化为ip并记录
                this.result.add(listToIp(list));
            }
            //无论如何,结束
            return;
        }
        //当前数字
        int num = wordArr[p] - '0';

        /**
         * 第一次回溯,直接新数字
         */

        //组装
        list.addLast(num);
        //走下一级
        next(wordArr, p + 1, list);
        //回溯
        list.removeLast();

        /**
         * 判断第二次是否可行
         */

        //如果没有数字
        if (list.isEmpty()) {
            //过
            return;
        }
        //上一个数字
        int lastNum = list.getLast();
        //如果是0
        if (lastNum == 0) {
            //过
            return;
        }
        //计算出新数字
        int newNum = lastNum * 10 + num;
        //如果数字不合理
        if (newNum > 255) {
            //果
            return;
        }

        /**
         * 第二次回溯
         */

        //先删除
        list.removeLast();
        //记录新数字
        list.addLast(newNum);
        //走下一级
        next(wordArr, p + 1, list);
        //回溯
        list.removeLast();
        list.addLast(lastNum);
    }

    public List<String> restoreIpAddresses(String s) {
        //如果长度超了
        if (s.length() > 12) {
            //直接返回
            return this.result;
        }
        //递归实现
        next(s.toCharArray(), 0, new LinkedList<>());
        //返回结果
        return this.result;
    }

    public static void main(String[] args) {
        new Code2().restoreIpAddresses("255255255255");
    }

}
