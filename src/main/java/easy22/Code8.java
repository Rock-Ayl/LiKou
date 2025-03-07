package easy22;

/**
 * @Author ayl
 * @Date 2022-09-03
 * 1720. 解码异或后的数组
 * 未知 整数数组 arr 由 n 个非负整数组成。
 * <p>
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 * <p>
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 * <p>
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：encoded = [1,2,3], first = 1
 * 输出：[1,0,2,1]
 * 解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
 * 示例 2：
 * <p>
 * 输入：encoded = [6,2,7,3], first = 4
 * 输出：[4,2,0,7,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 104
 * encoded.length == n - 1
 * 0 <= encoded[i] <= 105
 * 0 <= first <= 105
 */
public class Code8 {

    public int[] decode(int[] encoded, int first) {
        //初始化结果
        int[] result = new int[encoded.length + 1];
        //默认第一个
        result[0] = first;
        //循环
        for (int i = 1; i < result.length; i++) {
            //计算当前结果
            result[i] = encoded[i - 1] ^ result[i - 1];
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        new Code8().decode(new int[]{6, 2, 7, 3}, 4);
    }

}
