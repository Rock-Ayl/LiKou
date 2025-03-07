package normal32;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2024-05-21
 * 1291. 顺次数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
 * <p>
 * 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输出：low = 100, high = 300
 * 输出：[123,234]
 * 示例 2：
 * <p>
 * 输出：low = 1000, high = 13000
 * 输出：[1234,2345,3456,4567,5678,6789,12345]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 10 <= low <= high <= 10^9
 */
public class Code1 {

    //根据位数、开始数字,输出本次生成数字
    private int number(int targetCount, int start) {
        //当前数字
        int number = start;
        //目标count
        int count = 1;
        //如果不够长度
        while (start < 9 && count++ < targetCount) {
            //进位
            number = number * 10 + ++start;
        }
        //如果长度不够
        if (count < targetCount) {
            //没有
            return -1;
        }
        //返回目标结果
        return number;
    }

    //计算数字的位数
    private int count(int number) {
        //位数
        int count = 0;
        //循环
        while (number > 0) {
            //进位
            number = number / 10;
            count++;
        }
        //返回
        return count;
    }

    public List<Integer> sequentialDigits(int low, int high) {
        //初始化
        List<Integer> result = new ArrayList<>();
        //计算位数
        int lowCount = count(low);
        int highCount = count(high);
        //循环
        while (lowCount <= highCount) {
            //循环
            for (int i = 1; i <= 9; i++) {
                //生成本次数字
                int number = number(lowCount, i);
                //如果有 and 如果满足这个条件
                if (number != -1 && low <= number && number <= high) {
                    //组装本次结果
                    result.add(number);
                }
            }
            //+1
            lowCount++;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        List<Integer> integers = new Code1().sequentialDigits(1000, 13000);
        System.out.println();
    }

}
