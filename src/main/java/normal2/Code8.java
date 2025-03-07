package normal2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-04-09
 * 93. 复原 IP 地址
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
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
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 */
public class Code8 {

    //结果集
    List<String> list = new ArrayList<>();

    public void next(String s, List<Integer> front) {
        //如果有长度
        if (s.length() > 0) {
            //如果首位是0
            if (s.charAt(0) == '0') {
                //新的front
                List<Integer> newFront = new ArrayList<>(front);
                //记录
                newFront.add(0);
                //递归
                next(s.substring(1), newFront);
                //结束
                return;
            }
        } else {
            //如果是结果了
            if (front.size() == 4) {
                //组装并记录
                list.add(front.get(0) + "." + front.get(1) + "." + front.get(2) + "." + front.get(3));
            }
            //结束
            return;
        }
        //如果是三位及以上
        if (s.length() > 2) {
            //转化
            Integer num = Integer.parseInt(s.substring(0, 3));
            //如果没有越界
            if (num < 256) {
                //新的front
                List<Integer> newFront = new ArrayList<>(front);
                //记录
                newFront.add(num);
                //递归
                next(s.substring(3), newFront);
            }
        }
        //如果是两位
        if (s.length() > 1) {
            //转化
            Integer num = Integer.parseInt(s.substring(0, 2));
            //新的front
            List<Integer> newFront = new ArrayList<>(front);
            //记录
            newFront.add(num);
            //递归
            next(s.substring(2), newFront);
        }
        //如果是一位
        if (s.length() > 0) {
            //转化
            int num = s.charAt(0) - '0';
            //新的front
            List<Integer> newFront = new ArrayList<>(front);
            //记录
            newFront.add(num);
            //递归
            next(s.substring(1), newFront);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        //如果不足或越界
        if (s.length() > 12 || s.length() < 4) {
            //返回
            return list;
        }
        //递归
        next(s, new ArrayList<>());
        //直接返回
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().restoreIpAddresses("101023"));
    }
}
