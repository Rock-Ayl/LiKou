package easy16;

/**
 * @Author ayl
 * @Date 2021-12-03
 * 2078. 两栋颜色不同且距离最远的房子
 * 街上有 n 栋房子整齐地排成一列，每栋房子都粉刷上了漂亮的颜色。给你一个下标从 0 开始且长度为 n 的整数数组 colors ，其中 colors[i] 表示第  i 栋房子的颜色。
 * <p>
 * 返回 两栋 颜色 不同 房子之间的 最大 距离。
 * <p>
 * 第 i 栋房子和第 j 栋房子之间的距离是 abs(i - j) ，其中 abs(x) 是 x 的绝对值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：colors = [1,1,1,6,1,1,1]
 * 输出：3
 * 解释：上图中，颜色 1 标识成蓝色，颜色 6 标识成红色。
 * 两栋颜色不同且距离最远的房子是房子 0 和房子 3 。
 * 房子 0 的颜色是颜色 1 ，房子 3 的颜色是颜色 6 。两栋房子之间的距离是 abs(0 - 3) = 3 。
 * 注意，房子 3 和房子 6 也可以产生最佳答案。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：colors = [1,8,3,8,3]
 * 输出：4
 * 解释：上图中，颜色 1 标识成蓝色，颜色 8 标识成黄色，颜色 3 标识成绿色。
 * 两栋颜色不同且距离最远的房子是房子 0 和房子 4 。
 * 房子 0 的颜色是颜色 1 ，房子 4 的颜色是颜色 3 。两栋房子之间的距离是 abs(0 - 4) = 4 。
 * 示例 3：
 * <p>
 * 输入：colors = [0,1]
 * 输出：1
 * 解释：两栋颜色不同且距离最远的房子是房子 0 和房子 1 。
 * 房子 0 的颜色是颜色 0 ，房子 1 的颜色是颜色 1 。两栋房子之间的距离是 abs(0 - 1) = 1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == colors.length
 * 2 <= n <= 100
 * 0 <= colors[i] <= 100
 * 生成的测试数据满足 至少 存在 2 栋颜色不同的房子
 */
public class Code1 {

    public int maxDistance(int[] colors) {
        //最大
        int max = 0;
        //左边
        int left = colors[0];
        //循环
        for (int i = colors.length - 1; i > 0; i--) {
            //如果找到了
            if (colors[i] != left) {
                //刷新
                max = Math.max(max, i);
            }
        }
        //右边
        int right = colors[colors.length - 1];
        //循环
        for (int i = 0; i < colors.length - 1; i++) {
            //如果找到了
            if (colors[i] != left) {
                //刷新
                max = Math.max(max, colors.length - 1 - i);
            }
        }
        //默认
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code1().maxDistance(new int[]{4, 4, 4, 11, 4, 4, 11, 4, 4, 4, 4, 4}));
    }
}
