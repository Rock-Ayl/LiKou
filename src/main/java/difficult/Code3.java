package difficult;

/**
 * @Author ayl
 * @Date 2021-07-16
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 */
public class Code3 {

    public int trap(int[] height) {
        //水
        int size = 0;
        //两边
        int i = 0, j = height.length - 1;
        //两边最小盛水
        int iMin = 0, jMin = 0;
        //循环
        while (i < j) {
            //当前左右载水量
            int x = height[i], y = height[j];
            //如果左边大
            if (x >= y) {
                //如果有水了
                if (y < jMin) {
                    //计算水
                    size += jMin - y;
                } else {
                    //刷新
                    jMin = y;
                }
                j--;
            } else {
                //如果有水了
                if (x < iMin) {
                    //计算水
                    size += iMin - x;
                } else {
                    //刷新
                    iMin = x;
                }
                i++;
            }
        }
        //返回
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

}
