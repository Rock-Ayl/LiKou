package easy37;

/**
 * @Author ayl
 * @Date 2024-07-07
 * 100336. 交替组 I
 * 简单
 * 相关企业
 * 提示
 * 给你一个整数数组 colors ，它表示一个由红色和蓝色瓷砖组成的环，第 i 块瓷砖的颜色为 colors[i] ：
 * <p>
 * colors[i] == 0 表示第 i 块瓷砖的颜色是 红色 。
 * colors[i] == 1 表示第 i 块瓷砖的颜色是 蓝色 。
 * 环中连续 3 块瓷砖的颜色如果是 交替 颜色（也就是说中间瓷砖的颜色与它 左边 和 右边 的颜色都不同），那么它被称为一个 交替 组。
 * <p>
 * 请你返回 交替 组的数目。
 * <p>
 * 注意 ，由于 colors 表示一个 环 ，第一块 瓷砖和 最后一块 瓷砖是相邻的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：colors = [1,1,1]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：colors = [0,1,0,0,1]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 交替组包括：
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= colors.length <= 100
 * 0 <= colors[i] <= 1
 */
public class Code18 {

    public int numberOfAlternatingGroups(int[] colors) {
        //次数
        int count = 0;
        //如果第一个是
        if (colors[0] != colors[colors.length - 1] && colors[0] != colors[1]) {
            //+1
            ++count;
        }
        //如果最后一个是
        if (colors[0] != colors[colors.length - 1] && colors[colors.length - 1] != colors[colors.length - 2]) {
            //+1
            ++count;
        }
        //循环
        for (int i = 1; i < colors.length - 1; i++) {
            //如果满足
            if (colors[i] != colors[i - 1] && colors[i] != colors[i + 1]) {
                //+1
                ++count;
            }
        }
        //返回结果
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code18().numberOfAlternatingGroups(new int[]{0, 1, 0, 0, 1}));
    }

}
