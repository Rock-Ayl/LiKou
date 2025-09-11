package normal46;

/**
 * @Author ayl
 * @Date 2025-09-11
 * 3029. 将单词恢复初始状态所需的最短时间 I
 * 算术评级: 4
 * 第 383 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1660
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的字符串 word 和一个整数 k 。
 * <p>
 * 在每一秒，你必须执行以下操作：
 * <p>
 * 移除 word 的前 k 个字符。
 * 在 word 的末尾添加 k 个任意字符。
 * 注意 添加的字符不必和移除的字符相同。但是，必须在每一秒钟都执行 两种 操作。
 * <p>
 * 返回将 word 恢复到其 初始 状态所需的 最短 时间（该时间必须大于零）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "abacaba", k = 3
 * 输出：2
 * 解释：
 * 第 1 秒，移除 word 的前缀 "aba"，并在末尾添加 "bac" 。因此，word 变为 "cababac"。
 * 第 2 秒，移除 word 的前缀 "cab"，并在末尾添加 "aba" 。因此，word 变为 "abacaba" 并恢复到始状态。
 * 可以证明，2 秒是 word 恢复到其初始状态所需的最短时间。
 * 示例 2：
 * <p>
 * 输入：word = "abacaba", k = 4
 * 输出：1
 * 解释：
 * 第 1 秒，移除 word 的前缀 "abac"，并在末尾添加 "caba" 。因此，word 变为 "abacaba" 并恢复到初始状态。
 * 可以证明，1 秒是 word 恢复到其初始状态所需的最短时间。
 * 示例 3：
 * <p>
 * 输入：word = "abcbabcd", k = 2
 * 输出：4
 * 解释：
 * 每一秒，我们都移除 word 的前 2 个字符，并在 word 末尾添加相同的字符。
 * 4 秒后，word 变为 "abcbabcd" 并恢复到初始状态。
 * 可以证明，4 秒是 word 恢复到其初始状态所需的最短时间。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 50
 * 1 <= k <= word.length
 * word仅由小写英文字母组成。
 */
public class Code9 {

    public int minimumTimeToInitialState(String word, int k) {

        /**
         * 构建前缀和
         */

        //前缀和
        int[] arr = new int[word.length()];
        //第一个
        arr[0] = word.charAt(0);
        //循环
        for (int i = 1; i < arr.length; i++) {
            //叠加
            arr[i] = arr[i - 1] + word.charAt(i);
        }

        /**
         * 计算结果
         */

        //最大操作次数
        int maxCount = word.length() / k + (word.length() % k != 0 ? 1 : 0);
        //循环
        for (int i = 1; i < maxCount; i++) {
            //拥有的
            int hadStart = (i * k);
            int hadEnd = word.length() - 1;
            //目标的
            int targetStart = 0;
            int targetEnd = hadEnd - hadStart;
            //如果hash值一样
            if (sum(arr, hadStart, hadEnd) == sum(arr, targetStart, targetEnd)) {
                //分别获取字符串
                String a = word.substring(hadStart, hadEnd + 1);
                String b = word.substring(targetStart, targetEnd + 1);
                //如果是结果
                if (a.equals(b)) {
                    //返回结果
                    return i;
                }
            }
        }
        //默认返回最大结果
        return maxCount;
    }

    //计算hash值
    private int sum(int[] arr, int start, int end) {
        //实现
        return arr[end] - (start == 0 ? 0 : arr[start - 1]);
    }

    public static void main(String[] args) {
        System.out.println(new Code9().minimumTimeToInitialState("abacaba", 3));
    }

}
