package normal11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2022-02-11
 * 1743. 从相邻元素对还原数组
 * 存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。
 * <p>
 * 给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui 和 vi 在 nums 中相邻。
 * <p>
 * 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i], nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。
 * <p>
 * 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：adjacentPairs = [[2,1],[3,4],[3,2]]
 * 输出：[1,2,3,4]
 * 解释：数组的所有相邻元素对都在 adjacentPairs 中。
 * 特别要注意的是，adjacentPairs[i] 只表示两个元素相邻，并不保证其 左-右 顺序。
 * 示例 2：
 * <p>
 * 输入：adjacentPairs = [[4,-2],[1,4],[-3,1]]
 * 输出：[-2,4,1,-3]
 * 解释：数组中可能存在负数。
 * 另一种解答是 [-3,1,4,-2] ，也会被视作正确答案。
 * 示例 3：
 * <p>
 * 输入：adjacentPairs = [[100000,-100000]]
 * 输出：[100000,-100000]
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums.length == n
 * adjacentPairs.length == n - 1
 * adjacentPairs[i].length == 2
 * 2 <= n <= 105
 * -105 <= nums[i], ui, vi <= 105
 * 题目数据保证存在一些以 adjacentPairs 作为元素对的数组 nums
 */
public class Code14 {

    public int[] restoreArray(int[][] adjacentPairs) {
        //初始化结果
        int[] result = new int[Math.max(adjacentPairs.length + 1, 2)];
        //缓存,记录每种出现次数,第二次删除,找到左右两边
        Set<Integer> countSet = new HashSet<>();
        //缓存,记录每个数字的相邻数字
        Map<Integer, Integer> nearMap = new HashMap<>();
        //循环
        for (int[] pairs : adjacentPairs) {
            //左右
            int left = pairs[0], right = pairs[1];
            //如果存在
            if (countSet.contains(left)) {
                //删除
                countSet.remove(left);
            } else {
                //加入
                countSet.add(left);
            }
            //如果存在
            if (countSet.contains(right)) {
                //删除
                countSet.remove(right);
            } else {
                //加入
                countSet.add(right);
            }
            //左右num取出来或初始化,并相加,组装回去
            nearMap.put(left, nearMap.getOrDefault(left, 0) + right);
            nearMap.put(right, nearMap.getOrDefault(right, 0) + left);
        }
        //是首还是尾
        boolean start = true;
        //遍历,无论如何,只会有两个(组装第一个和最后一个,因为二者特殊)
        for (Integer startAndEnd : countSet) {
            //如果是首
            if (start) {
                //组装首
                result[0] = startAndEnd;
            } else {
                //组装尾
                result[result.length - 1] = startAndEnd;
            }
            //转换
            start = !start;
        }
        //组装第二个(因为第二个也比较特殊)
        result[1] = nearMap.get(result[0]);
        //循环,剩下的
        for (int i = 2; i < result.length - 1; i++) {
            //左边的是
            int left = result[i - 1];
            //获取其靠近的两数之和,并开始减去额外的
            int num = nearMap.get(left) - result[i - 2];
            //记录这个靠近的
            result[i] = num;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code14().restoreArray(new int[][]{
                new int[]{1, 2},
                new int[]{3, 2},
                new int[]{3, 4}
        });
    }

}
