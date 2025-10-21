package normal47;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-10-21
 * 面试题 17.18. 最短超串
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
 * <p>
 * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
 * small = [1,5,9]
 * 输出：[7,10]
 * 示例 2：
 * <p>
 * 输入：
 * big = [1,2,3]
 * small = [4]
 * 输出：[]
 * 提示：
 * <p>
 * big.length <= 100000
 * 1 <= small.length <= 100000
 */
public class Code7 {

    public int[] shortestSeq(int[] big, int[] small) {

        /**
         * 构建 small 相关
         */

        //匹配的 small 当前数量
        int smallMatchCount = 0;
        //small数量缓存
        Map<Integer, Integer> smallCountMap = new HashMap<>();
        //循环
        for (int num : small) {
            //初始化
            smallCountMap.put(num, 0);
        }

        /**
         * 计算
         */

        //结果长度
        int matchLength = Integer.MAX_VALUE;
        //结果开始位置
        int matchStart = 0;
        //开始索引
        int start = 0;
        //循环
        for (int i = 0; i < big.length; i++) {

            /**
             * 右移动
             */

            //当前数字
            Integer num = big[i];
            //获取数字对应数量
            Integer count = smallCountMap.get(num);
            //如果不是small相关
            if (count == null) {
                //本轮过
                continue;
            }
            //如果第一次加入
            if (++count == 1) {
                //总数+1
                smallMatchCount++;
            }
            //覆盖count
            smallCountMap.put(num, count);

            /**
             * 如果满足,收缩
             */

            //如果达到目标匹配
            while (smallMatchCount == smallCountMap.size()) {
                //获取最左边数量
                Integer startCount = smallCountMap.get(big[start]);
                //如果无法收缩
                if (startCount != null && startCount.equals(1)) {
                    //直接跳出
                    break;
                } else {
                    //如果有count
                    if (startCount != null) {
                        //计算收缩
                        smallCountMap.put(big[start++], startCount - 1);
                    } else {
                        //直接收缩
                        start++;
                    }
                }
            }

            /**
             * 记录结果
             */

            //如果满足结果
            if (smallMatchCount == smallCountMap.size()) {
                //长度
                int length = i - start + 1;
                //如果结果更小
                if (length < matchLength) {
                    //记录
                    matchLength = length;
                    matchStart = start;
                }
            }

        }

        /**
         * 返回结果
         */

        //如果没有结果
        if (matchLength == Integer.MAX_VALUE) {
            //过
            return new int[]{};
        }
        //返回
        return new int[]{matchStart, matchStart + matchLength - 1};
    }

    public static void main(String[] args) {
        int[] ints = new Code7().shortestSeq(
                new int[]{7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7},
                new int[]{1, 5, 9}
        );
        System.out.println();
    }

}
