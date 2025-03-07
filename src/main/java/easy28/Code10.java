package easy28;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-02-20
 * 2570. 合并两个二维数组 - 求和法
 * 给你两个 二维 整数数组 nums1 和 nums2.
 * <p>
 * nums1[i] = [idi, vali] 表示编号为 idi 的数字对应的值等于 vali 。
 * nums2[i] = [idi, vali] 表示编号为 idi 的数字对应的值等于 vali 。
 * 每个数组都包含 互不相同 的 id ，并按 id 以 递增 顺序排列。
 * <p>
 * 请你将两个数组合并为一个按 id 以递增顺序排列的数组，并符合下述条件：
 * <p>
 * 只有在两个数组中至少出现过一次的 id 才能包含在结果数组内。
 * 每个 id 在结果数组中 只能出现一次 ，并且其对应的值等于两个数组中该 id 所对应的值求和。如果某个数组中不存在该 id ，则认为其对应的值等于 0 。
 * 返回结果数组。返回的数组需要按 id 以递增顺序排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
 * 输出：[[1,6],[2,3],[3,2],[4,6]]
 * 解释：结果数组中包含以下元素：
 * - id = 1 ，对应的值等于 2 + 4 = 6 。
 * - id = 2 ，对应的值等于 3 。
 * - id = 3 ，对应的值等于 2 。
 * - id = 4 ，对应的值等于5 + 1 = 6 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]]
 * 输出：[[1,3],[2,4],[3,6],[4,3],[5,5]]
 * 解释：不存在共同 id ，在结果数组中只需要包含每个 id 和其对应的值。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 200
 * nums1[i].length == nums2[j].length == 2
 * 1 <= idi, vali <= 1000
 * 数组中的 id 互不相同
 * 数据均按 id 以严格递增顺序排列
 */
public class Code10 {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        //结果缓存
        List<int[]> resultList = new ArrayList<>();
        //双指针
        int p = 0;
        int q = 0;
        //如果都有内容
        while (p < nums1.length && q < nums2.length) {
            //当前的
            int[] one = nums1[p];
            int[] two = nums2[q];
            //当前id
            int oneId = one[0];
            int twoId = two[0];
            //如果id相同
            if (oneId == twoId) {
                //记录二者和
                resultList.add(new int[]{oneId, one[1] + two[1]});
                //二者共同进位
                p++;
                q++;
            } else if (oneId > twoId) {
                //记录右边的
                resultList.add(new int[]{twoId, two[1]});
                //单独进位
                q++;
            } else {
                //记录左边的
                resultList.add(new int[]{oneId, one[1]});
                //单独进位
                p++;
            }
        }
        //如果左边还有内容
        while (p < nums1.length) {
            //记录左边的并进位
            resultList.add(new int[]{nums1[p][0], nums1[p++][1]});
        }
        //如果右边还有内容
        while (q < nums2.length) {
            //记录右边的并进位
            resultList.add(new int[]{nums2[q][0], nums2[q++][1]});
        }
        //返回结果
        return resultList.toArray(new int[resultList.size()][]);
    }

    public static void main(String[] args) {
        int[][] result = new Code10().mergeArrays(new int[][]{
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{4, 5}
        }, new int[][]{
                new int[]{1, 4},
                new int[]{3, 2},
                new int[]{4, 1}
        });
        System.out.println();
    }

}
