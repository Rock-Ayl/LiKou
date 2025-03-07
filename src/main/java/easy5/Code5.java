package easy5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created By Rock-Ayl on 2021-01-04
 * 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 */
public class Code5 {

    public static int[] plusOne(int[] digits) {
        //转化为List
        List<Integer> list = new ArrayList<>();
        //循环
        for (int digit : digits) {
            //插入
            list.add(digit);
        }
        //位置
        int p = list.size() - 1;
        //循环
        while (p >= 0) {
            //获取当前位置数
            int num = list.get(p);
            //如果是进位
            if (num == 9) {
                //清零
                list.set(p, 0);
                //如果已经是最后一位了
                if (p == 0) {
                    //首位插个1
                    list.add(0, 1);
                    //结束
                    break;
                } else {
                    //减一
                    p--;
                }
            } else if (num < 9) {
                //原位置+1
                list.set(p, num + 1);
                //结束
                break;
            } else {
                //结束
                break;
            }
        }
        //转回去,返回
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        for (int i : plusOne(new int[]{1,9,9})) {
            System.out.println(i);
        }
    }
}
