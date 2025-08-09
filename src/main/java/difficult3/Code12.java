package difficult3;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-08-09
 * 1220. 统计元音字母序列的数目
 * 算术评级: 5
 * 第 157 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 1730
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：
 * <p>
 * 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
 * 每个元音 'a' 后面都只能跟着 'e'
 * 每个元音 'e' 后面只能跟着 'a' 或者是 'i'
 * 每个元音 'i' 后面 不能 再跟着另一个 'i'
 * 每个元音 'o' 后面只能跟着 'i' 或者是 'u'
 * 每个元音 'u' 后面只能跟着 'a'
 * 由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：5
 * 解释：所有可能的字符串分别是："a", "e", "i" , "o" 和 "u"。
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：10
 * 解释：所有可能的字符串分别是："ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" 和 "ua"。
 * 示例 3：
 * <p>
 * 输入：n = 5
 * 输出：68
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2 * 10^4
 */
public class Code12 {

    public int countVowelPermutation(int n) {
        //结果
        int[] arr = new int[5];
        //下一个结果
        int[] nextArr = new int[5];
        //填充默认
        Arrays.fill(arr, 1);
        //指针
        int index = 1;
        //如果还不够
        while (index++ < n) {
            //全填充0
            Arrays.fill(nextArr, 0);
            //每个元音 'a' 后面都只能跟着 'e'
            nextArr[1] = (nextArr[1] + arr[0]) % 1000000007;
            //每个元音 'e' 后面只能跟着 'a' 或者是 'i'
            nextArr[0] = (nextArr[0] + arr[1]) % 1000000007;
            nextArr[2] = (nextArr[2] + arr[1]) % 1000000007;
            //每个元音 'i' 后面 不能 再跟着另一个 'i'
            nextArr[0] = (nextArr[0] + arr[2]) % 1000000007;
            nextArr[1] = (nextArr[1] + arr[2]) % 1000000007;
            nextArr[3] = (nextArr[3] + arr[2]) % 1000000007;
            nextArr[4] = (nextArr[4] + arr[2]) % 1000000007;
            //每个元音 'o' 后面只能跟着 'i' 或者是 'u'
            nextArr[2] = (nextArr[2] + arr[3]) % 1000000007;
            nextArr[4] = (nextArr[4] + arr[3]) % 1000000007;
            //每个元音 'u' 后面只能跟着 'a'
            nextArr[0] = (nextArr[0] + arr[4]) % 1000000007;
            //下一个
            for (int i = 0; i < nextArr.length; i++) {
                //覆盖
                arr[i] = nextArr[i];
            }
        }
        //结果
        int result = 0;
        //循环
        for (int num : arr) {
            //叠加
            result = (result + num) % 1000000007;
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().countVowelPermutation(144));
    }

}
