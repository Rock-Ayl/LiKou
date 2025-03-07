package easy;

/**
 * Created By Rock-Ayl on 2020-08-19
 * 1470. 重新排列数组
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * <p>
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,1,3,4,7], n = 3
 * 输出：[2,3,5,4,1,7]
 * 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,4,3,2,1], n = 4
 * 输出：[1,4,2,3,3,2,4,1]
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,2,2], n = 2
 * 输出：[1,2,1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 500
 * nums.length == 2n
 * 1 <= nums[i] <= 10^3
 */
public class Code11 {

    public static int[] shuffle2(int[] nums, int n) {
        //初始化
        int[] result = new int[2 * n];
        //初始化x
        int x = 0;
        //初始化y
        int y = n;
        //循环
        for (int i = 0; i < result.length; i++) {
            //偶数
            if (i % 2 == 0) {
                //是x
                result[i] = nums[x];
                //记录
                x++;
            } else {
                //是y
                result[i] = nums[y];
                //记录
                y++;
            }
        }
        //返回
        return result;
    }

    public static int[] shuffle(int[] nums, int n) {
        //初始化返回值
        int[] result = new int[n * 2];
        //初始化x、y 缓存
        int[] x = new int[n];
        int[] y = new int[n];
        //记录x、y
        for (int i = 0; i < n; i++) {
            x[i] = nums[i];
            y[i] = nums[i + n];
        }
        //x、y取值坐标
        int p = 0;
        //循环
        for (int i = 0; i < result.length; i = i + 2) {
            //存x
            result[i] = x[p];
            //存y
            result[i + 1] = y[p];
            //坐标向前
            p++;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (int i : shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)) {
            System.out.println(i);
        }
    }
}
