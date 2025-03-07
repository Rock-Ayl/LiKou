package easy27;

/**
 * @Author ayl
 * @Date 2023-01-23
 * 2540. 最小公共值
 * 给你两个整数数组 nums1 和 nums2 ，它们已经按非降序排序，请你返回两个数组的 最小公共整数 。如果两个数组 nums1 和 nums2 没有公共整数，请你返回 -1 。
 * <p>
 * 如果一个整数在两个数组中都 至少出现一次 ，那么这个整数是数组 nums1 和 nums2 公共 的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3], nums2 = [2,4]
 * 输出：2
 * 解释：两个数组的最小公共元素是 2 ，所以我们返回 2 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2,3,6], nums2 = [2,3,4,5]
 * 输出：2
 * 解释：两个数组中的公共元素是 2 和 3 ，2 是较小值，所以返回 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 105
 * 1 <= nums1[i], nums2[j] <= 109
 * nums1 和 nums2 都是 非降序 的。
 */
public class Code5 {

    public int getCommon(int[] nums1, int[] nums2) {
        //双指针
        int left = 0;
        int right = 0;
        //如果满足可以继续走
        while (left < nums1.length && right < nums2.length) {
            //如果相同
            if (nums1[left] == nums2[right]) {
                //直接返回
                return nums1[left];
            }
            //判断左右最大
            if (nums1[left] > nums2[right]) {
                //进位
                right++;
            } else {
                //进位
                left++;
            }
        }
        //默认
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().getCommon(new int[]{1, 2, 3, 6}, new int[]{2, 3, 4, 5}));
    }

}
