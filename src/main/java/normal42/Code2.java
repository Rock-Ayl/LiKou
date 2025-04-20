package normal42;

import normal41.Code25;

import java.util.Arrays;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-04-20
 * LCR 035. 最小时间差
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= timePoints <= 2 * 104
 * timePoints[i] 格式为 "HH:MM"
 * <p>
 * <p>
 * 注意：本题与主站 539 题相同： https://leetcode-cn.com/problems/minimum-time-difference/
 */
public class Code2 {

    public int findMinDifference(List<String> timePoints) {

        /**
         * 特殊判定
         */

        //如果肯定有重复的
        if (timePoints.size() > 1440) {
            //过
            return 0;
        }

        /**
         * 记录索引
         */

        //缓存
        int[] arr = new int[2880];
        //循环
        for (String timePoint : timePoints) {
            //转为数字
            int num = parseToInt(timePoint);
            //+1,如果重复了
            if (++arr[num] == 2) {
                //返回
                return 0;
            }
            //+1,变成环
            ++arr[num + 1440];
        }

        /**
         * 取第一个时间
         */

        //上一个,默认不存在
        int lastIndex;
        //索引
        int index = 0;
        //循环
        while (arr[index] == 0) {
            //+1
            index++;
        }
        //记录上一个索引
        lastIndex = index;
        //+1
        index++;

        /**
         * 不短计算区间
         */

        //结果
        int min = Integer.MAX_VALUE;
        //循环
        while (index < 2220) {
            //如果是0
            if (arr[index] == 0) {
                //+1
                index++;
                //本轮过
                continue;
            }
            //计算距离,刷新最小结果
            min = Math.min(min, index - lastIndex);
            //记录并+1
            lastIndex = index++;
        }

        //返回
        return min;
    }

    //转为数字
    private int parseToInt(String timePoint) {
        //计算小时
        int hour = Integer.valueOf(timePoint.substring(0, 2));
        int minute = Integer.valueOf(timePoint.substring(3, 5));
        //返回
        return hour * 60 + minute;
    }

    public static void main(String[] args) {
        System.out.println(new Code25().findMinDifference(Arrays.asList("00:00", "23:59")));
    }

}
