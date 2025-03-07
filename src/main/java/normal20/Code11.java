package normal20;

/**
 * @Author ayl
 * @Date 2023-05-13
 * 2433. 找出前缀异或的原始数组
 * 给你一个长度为 n 的 整数 数组 pref 。找出并返回满足下述条件且长度为 n 的数组 arr ：
 * <p>
 * pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
 * 注意 ^ 表示 按位异或（bitwise-xor）运算。
 * <p>
 * 可以证明答案是 唯一 的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：pref = [5,2,0,3,1]
 * 输出：[5,7,2,3,2]
 * 解释：从数组 [5,7,2,3,2] 可以得到如下结果：
 * - pref[0] = 5
 * - pref[1] = 5 ^ 7 = 2
 * - pref[2] = 5 ^ 7 ^ 2 = 0
 * - pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3
 * - pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1
 * 示例 2：
 * <p>
 * 输入：pref = [13]
 * 输出：[13]
 * 解释：pref[0] = arr[0] = 13
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= pref.length <= 105
 * 0 <= pref[i] <= 106
 */
public class Code11 {

    public int[] findArray(int[] pref) {
        //初始化
        int[] result = new int[pref.length];
        int[] cache = new int[pref.length];
        //初始化
        result[0] = pref[0];
        cache[0] = pref[0];
        //循环
        for (int i = 1; i < pref.length; i++) {
            //计算当前
            int num = cache[i - 1] ^ pref[i];
            //本次结果
            result[i] = num;
            //缓存
            cache[i] = num ^ cache[i - 1];
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code11().findArray(new int[]{5, 2, 0, 3, 1});
    }

}
