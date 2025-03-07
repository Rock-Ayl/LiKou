package easy26;

/**
 * @Author ayl
 * @Date 2022-12-20
 * 2269. 找到一个数字的 K 美丽值
 * 一个整数 num 的 k 美丽值定义为 num 中符合以下条件的 子字符串 数目：
 * <p>
 * 子字符串长度为 k 。
 * 子字符串能整除 num 。
 * 给你整数 num 和 k ，请你返回 num 的 k 美丽值。
 * <p>
 * 注意：
 * <p>
 * 允许有 前缀 0 。
 * 0 不能整除任何值。
 * 一个 子字符串 是一个字符串里的连续一段字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 240, k = 2
 * 输出：2
 * 解释：以下是 num 里长度为 k 的子字符串：
 * - "240" 中的 "24" ：24 能整除 240 。
 * - "240" 中的 "40" ：40 能整除 240 。
 * 所以，k 美丽值为 2 。
 * 示例 2：
 * <p>
 * 输入：num = 430043, k = 2
 * 输出：2
 * 解释：以下是 num 里长度为 k 的子字符串：
 * - "430043" 中的 "43" ：43 能整除 430043 。
 * - "430043" 中的 "30" ：30 不能整除 430043 。
 * - "430043" 中的 "00" ：0 不能整除 430043 。
 * - "430043" 中的 "04" ：4 不能整除 430043 。
 * - "430043" 中的 "43" ：43 能整除 430043 。
 * 所以，k 美丽值为 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 109
 * 1 <= k <= num.length （将 num 视为字符串）
 */
public class Code6 {

    public int divisorSubstrings(int num, int k) {
        //转化为字符串
        String value = String.valueOf(num);
        //结果
        int count = 0;
        //循环
        for (int i = k - 1; i < value.length(); i++) {
            //拆解为数字
            int thisNum = Integer.valueOf(value.substring(i - k + 1, i + 1));
            //如果是0
            if (thisNum == 0) {
                //本轮过
                continue;
            }
            //如果是
            if (num % thisNum == 0) {
                //记录
                count++;
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code6().divisorSubstrings(430043, 2));
    }

}
