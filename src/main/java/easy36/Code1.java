package easy36;

/**
 * @Author ayl
 * @Date 2024-02-08
 * 3024. 三角形类型 II
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始长度为 3 的整数数组 nums ，需要用它们来构造三角形。
 * <p>
 * 如果一个三角形的所有边长度相等，那么这个三角形称为 equilateral 。
 * 如果一个三角形恰好有两条边长度相等，那么这个三角形称为 isosceles 。
 * 如果一个三角形三条边的长度互不相同，那么这个三角形称为 scalene 。
 * 如果这个数组无法构成一个三角形，请你返回字符串 "none" ，否则返回一个字符串表示这个三角形的类型。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,3,3]
 * 输出："equilateral"
 * 解释：由于三条边长度相等，所以可以构成一个等边三角形，返回 "equilateral" 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,5]
 * 输出："scalene"
 * 解释：
 * nums[0] + nums[1] = 3 + 4 = 7 ，大于 nums[2] = 5 。
 * nums[0] + nums[2] = 3 + 5 = 8 ，大于 nums[1] = 4 。
 * nums[1] + nums[2] = 4 + 5 = 9 ，大于 nums[0] = 3 。
 * 由于任意两边纸盒都大于第三边，所以可以构成一个三角形。
 * 因为三条边的长度互不相等，所以返回 "scalene" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums.length == 3
 * 1 <= nums[i] <= 100
 */
public class Code1 {

    public String triangleType(int[] nums) {
        //三边
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        //判断是否为三角形
        if (a + b <= c || a + c <= b || b + c <= a) {
            //不是三角形
            return "none";
        }
        //如果是三边相同
        if (a == b && b == c) {
            //等边三角形
            return "equilateral";
        }
        //两边相同
        if (a == b || b == c || a == c) {
            //直角三角形
            return "isosceles";
        }
        //默认
        return "scalene";
    }


}
