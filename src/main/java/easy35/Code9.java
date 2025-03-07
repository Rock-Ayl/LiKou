package easy35;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-12-17
 * 2951. 找出峰值
 * 提示
 * 简单
 * 4
 * 相关企业
 * 给你一个下标从 0 开始的数组 mountain 。你的任务是找出数组 mountain 中的所有 峰值。
 * <p>
 * 以数组形式返回给定数组中 峰值 的下标，顺序不限 。
 * <p>
 * 注意：
 * <p>
 * 峰值 是指一个严格大于其相邻元素的元素。
 * 数组的第一个和最后一个元素 不 是峰值。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：mountain = [2,4,4]
 * 输出：[]
 * 解释：mountain[0] 和 mountain[2] 不可能是峰值，因为它们是数组的第一个和最后一个元素。
 * mountain[1] 也不可能是峰值，因为它不严格大于 mountain[2] 。
 * 因此，答案为 [] 。
 * 示例 2：
 * <p>
 * 输入：mountain = [1,4,3,8,5]
 * 输出：[1,3]
 * 解释：mountain[0] 和 mountain[4] 不可能是峰值，因为它们是数组的第一个和最后一个元素。
 * mountain[2] 也不可能是峰值，因为它不严格大于 mountain[3] 和 mountain[1] 。
 * 但是 mountain[1] 和 mountain[3] 严格大于它们的相邻元素。
 * 因此，答案是 [1,3] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= mountain.length <= 100
 * 1 <= mountain[i] <= 100
 */
public class Code9 {

    public List<Integer> findPeaks(int[] mountain) {
        //初始化结果
        List<Integer> result = new ArrayList<>();
        //循环
        for (int i = 1; i < mountain.length - 1; i++) {
            //如果是
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                //记录
                result.add(i);
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {

    }

}
