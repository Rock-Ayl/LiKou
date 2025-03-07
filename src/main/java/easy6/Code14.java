package easy6;

/**
 * Created By Rock-Ayl on 2021-02-11
 * 1732. 找到最高海拔
 * 有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。自行车手从海拔为 0 的点 0 开始骑行。
 * <p>
 * 给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：gain = [-5,1,5,0,-7]
 * 输出：1
 * 解释：海拔高度依次为 [0,-5,-4,1,1,-6] 。最高海拔为 1 。
 * 示例 2：
 * <p>
 * 输入：gain = [-4,-3,-2,-1,4,3,2]
 * 输出：0
 * 解释：海拔高度依次为 [0,-4,-7,-9,-10,-6,-3,-1] 。最高海拔为 0 。
 * <p>
 * 提示：
 * <p>
 * n == gain.length
 * 1 <= n <= 100
 * -100 <= gain[i] <= 100
 */
public class Code14 {

    public static int largestAltitude(int[] gain) {
        //当前海拔最高
        int max = 0;
        //当前
        int p = 0;
        //循环
        for (int i : gain) {
            //计算
            p += i;
            //计算最高
            max = Math.max(p, max);
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-5, 1, 5, 0, -7}));
    }
}
