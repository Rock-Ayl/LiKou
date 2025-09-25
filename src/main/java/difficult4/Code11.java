package difficult4;

import java.util.*;

/**
 * @Author ayl
 * @Date 2025-09-25
 * 1345. 跳跃游戏 IV
 * 算术评级: 8
 * 第 19 场双周赛
 * Q4
 * 同步题目状态
 * <p>
 * 1810
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
 * <p>
 * 每一步，你可以从下标 i 跳到下标 i + 1 、i - 1 或者 j ：
 * <p>
 * i + 1 需满足：i + 1 < arr.length
 * i - 1 需满足：i - 1 >= 0
 * j 需满足：arr[i] == arr[j] 且 i != j
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
 * <p>
 * 注意：任何时候你都不能跳到数组外面。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
 * 输出：3
 * 解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
 * 示例 2：
 * <p>
 * 输入：arr = [7]
 * 输出：0
 * 解释：一开始就在最后一个元素处，所以你不需要跳跃。
 * 示例 3：
 * <p>
 * 输入：arr = [7,6,9,6,9,6,9,7]
 * 输出：1
 * 解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 5 * 104
 * -108 <= arr[i] <= 1081345. 跳跃游戏 IV
 * 算术评级: 8
 * 第 19 场双周赛
 * Q4
 * 同步题目状态
 * <p>
 * 1810
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
 * <p>
 * 每一步，你可以从下标 i 跳到下标 i + 1 、i - 1 或者 j ：
 * <p>
 * i + 1 需满足：i + 1 < arr.length
 * i - 1 需满足：i - 1 >= 0
 * j 需满足：arr[i] == arr[j] 且 i != j
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
 * <p>
 * 注意：任何时候你都不能跳到数组外面。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
 * 输出：3
 * 解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
 * 示例 2：
 * <p>
 * 输入：arr = [7]
 * 输出：0
 * 解释：一开始就在最后一个元素处，所以你不需要跳跃。
 * 示例 3：
 * <p>
 * 输入：arr = [7,6,9,6,9,6,9,7]
 * 输出：1
 * 解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 5 * 104
 * -108 <= arr[i] <= 108
 */
public class Code11 {

    public int minJumps(int[] arr) {
        //索引缓存
        Map<Integer, Set<Integer>> indexMap = new HashMap<>();
        //循环
        for (int i = 0; i < arr.length; i++) {
            //当前数字
            int num = arr[i];
            //初始化
            indexMap.putIfAbsent(num, new HashSet<>());
            //记录
            indexMap.get(num).add(i);
        }
        //走路
        int[] walkedArr = new int[arr.length];
        //初始化起始位置
        walkedArr[0] = 1;
        //下一次集合,默认是起始位置
        Set<Integer> waledSet = new HashSet<>(Arrays.asList(0));
        //如果还没走到头
        while (waledSet.isEmpty() == false && walkedArr[walkedArr.length - 1] == 0) {
            //计算出下一次的步数
            int nextWalk = walkedArr[waledSet.stream().findFirst().get()] + 1;
            //下一级
            Set<Integer> nextWalkedSet = new HashSet<>();
            //循环
            for (Integer index : waledSet) {
                //计算出下一步
                List<Integer> nextList = next(walkedArr, nextWalk, index, arr, indexMap);
                //组装
                nextWalkedSet.addAll(nextList);
            }
            //下一级
            waledSet = nextWalkedSet;
        }
        //返回
        return walkedArr[walkedArr.length - 1] - 1;
    }

    //寻找所有可以走的下一个路径
    private List<Integer> next(int[] walkedArr, int nextWalk, int index, int[] arr, Map<Integer, Set<Integer>> indexMap) {
        //返回
        List<Integer> result = new ArrayList<>();
        //如果有左边 and 没走过
        if (index - 1 >= 0 && walkedArr[index - 1] == 0) {
            //组装
            result.add(index - 1);
            //记录
            walkedArr[index - 1] = nextWalk;
        }
        //如果有右边 and 没走过
        if (index + 1 < walkedArr.length && walkedArr[index + 1] == 0) {
            //组装
            result.add(index + 1);
            //记录
            walkedArr[index + 1] = nextWalk;
        }
        //获取集合
        Set<Integer> indexSet = indexMap.getOrDefault(arr[index], new HashSet<>());
        //循环所有相同索引
        for (Integer sameIndex : indexSet) {
            //如果没走过
            if (walkedArr[sameIndex] == 0) {
                //组装
                result.add(sameIndex);
                //记录
                walkedArr[sameIndex] = nextWalk;
            }
        }
        //不需要了
        indexMap.remove(arr[index]);
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().minJumps(new int[]{7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 11}));
    }

}
