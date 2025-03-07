package easy9;

import java.util.Arrays;

/**
 * @Author 安永亮
 * @Date 2021-06-27
 * @Description 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 */
public class Code15 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //指针
        int p = nums1.length - 1;
        //循环1
        for (int i = 0; i < nums2.length; i++) {
            //放进去
            nums1[p--] = nums2[i];
        }
        //排个序
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        new Code15().merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

}
