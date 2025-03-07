package normal6;

/**
 * @Author ayl
 * @Date 2021-08-28
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * 示例 4：
 * <p>
 * 输入：height = [1,2,1]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * n = height.length
 * 2 <= n <= 3 * 104
 * 0 <= height[i] <= 3 * 104
 */
public class Code15 {

    public int maxArea(int[] height) {
        //左右边距
        int left = 0, right = height.length - 1;
        //初始化左右选定的位置
        int a = left, b = right;
        //初始化面积
        int are = Math.min(height[a], height[b]) * (b - a);
        //开始压缩
        while (left < right) {
            //单签
            int x = height[a];
            int y = height[b];
            //谁小压缩谁
            if (x > y) {
                //右边移动
                right--;
                //如果可能更新
                if (height[right] > y) {
                    //计算新面积
                    int newAre = Math.min(x, height[right]) * (right - a);
                    //如果是新纪录
                    if (newAre > are) {
                        //刷新
                        are = newAre;
                    }
                    b = right;
                }
            } else {
                //左边移动
                left++;
                //如果可能更新
                if (height[left] > x) {
                    //计算新面积
                    int newAre = Math.min(height[left], y) * (b - left);
                    //如果是新纪录
                    if (newAre > are) {
                        //刷新
                        are = newAre;
                    }
                    a = left;
                }
            }
        }
        //返回结果
        return are;
    }

    public static void main(String[] args) {
        System.out.println(new Code15().maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}));
    }

}
