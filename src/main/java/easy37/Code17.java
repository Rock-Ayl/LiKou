package easy37;

/**
 * @Author ayl
 * @Date 2024-07-01
 * 3200. 三角形的最大高度
 * 简单
 * 相关企业
 * 提示
 * 给你两个整数 red 和 blue，分别表示红色球和蓝色球的数量。你需要使用这些球来组成一个三角形，满足第 1 行有 1 个球，第 2 行有 2 个球，第 3 行有 3 个球，依此类推。
 * <p>
 * 每一行的球必须是 相同 颜色，且相邻行的颜色必须 不同。
 * <p>
 * 返回可以实现的三角形的 最大 高度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： red = 2, blue = 4
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 上图显示了唯一可能的排列方式。
 * <p>
 * 示例 2：
 * <p>
 * 输入： red = 2, blue = 1
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * <p>
 * 上图显示了唯一可能的排列方式。
 * <p>
 * 示例 3：
 * <p>
 * 输入： red = 1, blue = 1
 * <p>
 * 输出： 1
 * <p>
 * 示例 4：
 * <p>
 * 输入： red = 10, blue = 1
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * <p>
 * 上图显示了唯一可能的排列方式。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= red, blue <= 100
 */
public class Code17 {

    //计算
    private int count(int one, int two) {
        //当前
        int result = 0;
        //是否使用第一个
        boolean right = true;
        //使用的数量
        int useCount = 1;
        //循环
        while (true) {
            //判断方向
            if (right) {
                //如果不够了
                if (useCount > one) {
                    //跳出
                    break;
                }
                //减去
                one -= useCount++;
            } else {
                //如果不够了
                if (useCount > two) {
                    //跳出
                    break;
                }
                //减去
                two -= useCount++;
            }
            //换个方向
            right = !right;
            //+1
            ++result;
        }
        //返回结果
        return result;
    }

    public int maxHeightOfTriangle(int red, int blue) {
        //两种可能,对比最大值
        return Math.max(count(red, blue), count(blue, red));
    }

    public static void main(String[] args) {
        System.out.println(new Code17().maxHeightOfTriangle(10, 1));
    }

}
