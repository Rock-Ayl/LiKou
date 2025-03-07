package easy22;

/**
 * @Author ayl
 * @Date 2022-08-24
 * 2315. 统计星号
 * 给你一个字符串 s ，每 两个 连续竖线 '|' 为 一对 。换言之，第一个和第二个 '|' 为一对，第三个和第四个 '|' 为一对，以此类推。
 * <p>
 * 请你返回 不在 竖线对之间，s 中 '*' 的数目。
 * <p>
 * 注意，每个竖线 '|' 都会 恰好 属于一个对。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "l|*e*et|c**o|*de|"
 * 输出：2
 * 解释：不在竖线对之间的字符加粗加斜体后，得到字符串："l|*e*et|c**o|*de|" 。
 * 第一和第二条竖线 '|' 之间的字符不计入答案。
 * 同时，第三条和第四条竖线 '|' 之间的字符也不计入答案。
 * 不在竖线对之间总共有 2 个星号，所以我们返回 2 。
 * 示例 2：
 * <p>
 * 输入：s = "iamprogrammer"
 * 输出：0
 * 解释：在这个例子中，s 中没有星号。所以返回 0 。
 * 示例 3：
 * <p>
 * 输入：s = "yo|uar|e**|b|e***au|tifu|l"
 * 输出：5
 * 解释：需要考虑的字符加粗加斜体后："yo|uar|e**|b|e***au|tifu|l" 。不在竖线对之间总共有 5 个星号。所以我们返回 5 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 只包含小写英文字母，竖线 '|' 和星号 '*' 。
 * s 包含 偶数 个竖线 '|' 。
 */
public class Code5 {

    public int countAsterisks(String s) {
        //分割
        String[] arr = s.split("\\|");
        //指针
        int p = 0;
        //结果
        int count = 0;
        //如果有
        while (p < arr.length) {
            //循环
            for (char c : arr[p].toCharArray()) {
                //如果是
                if (c == '*') {
                    //记录
                    count++;
                }
            }
            //进位
            p = p + 2;
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().countAsterisks("|**|*|*|**||***||"));
    }
}
