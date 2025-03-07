package normal17;

/**
 * @Author ayl
 * @Date 2022-12-09
 * 1769. 移动所有球到每个盒子所需的最小操作数
 * 有 n 个盒子。给你一个长度为 n 的二进制字符串 boxes ，其中 boxes[i] 的值为 '0' 表示第 i 个盒子是 空 的，而 boxes[i] 的值为 '1' 表示盒子里有 一个 小球。
 * <p>
 * 在一步操作中，你可以将 一个 小球从某个盒子移动到一个与之相邻的盒子中。第 i 个盒子和第 j 个盒子相邻需满足 abs(i - j) == 1 。注意，操作执行后，某些盒子中可能会存在不止一个小球。
 * <p>
 * 返回一个长度为 n 的数组 answer ，其中 answer[i] 是将所有小球移动到第 i 个盒子所需的 最小 操作数。
 * <p>
 * 每个 answer[i] 都需要根据盒子的 初始状态 进行计算。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：boxes = "110"
 * 输出：[1,1,3]
 * 解释：每个盒子对应的最小操作数如下：
 * 1) 第 1 个盒子：将一个小球从第 2 个盒子移动到第 1 个盒子，需要 1 步操作。
 * 2) 第 2 个盒子：将一个小球从第 1 个盒子移动到第 2 个盒子，需要 1 步操作。
 * 3) 第 3 个盒子：将一个小球从第 1 个盒子移动到第 3 个盒子，需要 2 步操作。将一个小球从第 2 个盒子移动到第 3 个盒子，需要 1 步操作。共计 3 步操作。
 * 示例 2：
 * <p>
 * 输入：boxes = "001011"
 * 输出：[11,8,5,4,3,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == boxes.length
 * 1 <= n <= 2000
 * boxes[i] 为 '0' 或 '1'
 */
public class Code16 {

    public int[] minOperations(String boxes) {
        //长度
        int[] result = new int[boxes.length()];
        //循环
        for (int i = 0; i < result.length; i++) {
            //数量
            int count = 0;
            //双指针
            int left = i - 1;
            int right = i + 1;
            //循环
            while (left >= 0) {
                //本次走的次数
                count += (i - left) * (boxes.charAt(left) - '0');
                //继续递减
                left--;
            }
            //循环
            while (right < result.length) {
                //本次走的次数
                count += (right - i) * (boxes.charAt(right) - '0');
                //继续递增
                right++;
            }
            //记录该位置结
            result[i] = count;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code16().minOperations("110");
    }
}
