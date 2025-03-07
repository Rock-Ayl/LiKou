package normal40;

/**
 * @Author ayl
 * @Date 2025-02-28
 * 1525. 字符串的好分割数目
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s ，一个分割被称为 「好分割」 当它满足：将 s 分割成 2 个字符串 p 和 q ，它们连接起来等于 s 且 p 和 q 中不同字符的数目相同。
 * <p>
 * 请你返回 s 中好分割的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aacaba"
 * 输出：2
 * 解释：总共有 5 种分割字符串 "aacaba" 的方法，其中 2 种是好分割。
 * ("a", "acaba") 左边字符串和右边字符串分别包含 1 个和 3 个不同的字符。
 * ("aa", "caba") 左边字符串和右边字符串分别包含 1 个和 3 个不同的字符。
 * ("aac", "aba") 左边字符串和右边字符串分别包含 2 个和 2 个不同的字符。这是一个好分割。
 * ("aaca", "ba") 左边字符串和右边字符串分别包含 2 个和 2 个不同的字符。这是一个好分割。
 * ("aacab", "a") 左边字符串和右边字符串分别包含 3 个和 1 个不同的字符。
 * 示例 2：
 * <p>
 * 输入：s = "abcd"
 * 输出：1
 * 解释：好分割为将字符串分割成 ("ab", "cd") 。
 * 示例 3：
 * <p>
 * 输入：s = "aaaaa"
 * 输出：4
 * 解释：所有分割都是好分割。
 * 示例 4：
 * <p>
 * 输入：s = "acbadbaada"
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * s 只包含小写英文字母。
 * 1 <= s.length <= 10^5
 */
public class Code16 {

    public int numSplits(String s) {

        //缓存
        int[] leftArr = new int[123];
        int[] rightArr = new int[123];
        //不同字符统计
        int leftCount = 0;
        int rightCount = 0;
        //结果数量
        int result = 0;

        /**
         * 先装载一边全量
         */

        //循环
        for (int i = 0; i < s.length(); i++) {
            //获取key
            char key = s.charAt(i);
            //+1,如果是第一次出现
            if (++rightArr[key] == 1) {
                //+1不同字符
                rightCount++;
            }
        }

        /**
         * 平移计算结果
         */

        //循环
        for (int i = 0; i < s.length(); i++) {

            //获取key
            char key = s.charAt(i);

            /**
             * 左边增加
             */

            //+1,如果是第一次出现
            if (++leftArr[key] == 1) {
                //+1不同字符
                leftCount++;
            }

            /**
             * 右边减少
             */

            //-1,如果消失
            if (--rightArr[key] == 0) {
                //-1不同字符
                rightCount--;
            }

            /**
             * 本次结果
             */

            //如果是结果
            if (leftCount == rightCount) {
                //+1
                result++;
            }

        }

        //返回结果
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code16().numSplits("za"));
    }

}
