package normal6;

/**
 * @Author ayl
 * @Date 2021-08-20
 * 1750. 删除字符串两端相同字符后的最短长度
 * 给你一个只包含字符 'a'，'b' 和 'c' 的字符串 s ，你可以执行下面这个操作（5 个步骤）任意次：
 * <p>
 * 选择字符串 s 一个 非空 的前缀，这个前缀的所有字符都相同。
 * 选择字符串 s 一个 非空 的后缀，这个后缀的所有字符都相同。
 * 前缀和后缀在字符串中任意位置都不能有交集。
 * 前缀和后缀包含的所有字符都要相同。
 * 同时删除前缀和后缀。
 * 请你返回对字符串 s 执行上面操作任意次以后（可能 0 次），能得到的 最短长度 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ca"
 * 输出：2
 * 解释：你没法删除任何一个字符，所以字符串长度仍然保持不变。
 * 示例 2：
 * <p>
 * 输入：s = "cabaabac"
 * 输出：0
 * 解释：最优操作序列为：
 * - 选择前缀 "c" 和后缀 "c" 并删除它们，得到 s = "abaaba" 。
 * - 选择前缀 "a" 和后缀 "a" 并删除它们，得到 s = "baab" 。
 * - 选择前缀 "b" 和后缀 "b" 并删除它们，得到 s = "aa" 。
 * - 选择前缀 "a" 和后缀 "a" 并删除它们，得到 s = "" 。
 * 示例 3：
 * <p>
 * 输入：s = "aabccabba"
 * 输出：3
 * 解释：最优操作序列为：
 * - 选择前缀 "aa" 和后缀 "a" 并删除它们，得到 s = "bccabb" 。
 * - 选择前缀 "b" 和后缀 "bb" 并删除它们，得到 s = "cca" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 只包含字符 'a'，'b' 和 'c' 。
 */
public class Code13 {

    //全局
    String s;
    int left;
    int right;

    public void move() {
        //如果太小了
        if (right - left < 1) {
            //结束
            return;
        }
        //本次要删除的字符
        char space = s.charAt(left);
        //如果右边不是和左边一致的
        if (space != s.charAt(right)) {
            //结束
            return;
        }
        //如果未越界
        while (left < s.length() - 1) {
            //如果到头了
            if (s.charAt(++left) != space) {
                //结束
                break;
            }
        }
        //如果未越界
        while (right > 0) {
            //如果到头了
            if (s.charAt(--right) != space) {
                //结束
                break;
            }
        }
        //下一次
        move();
    }

    public int minimumLength(String s) {
        //全局
        this.s = s;
        this.left = 0;
        this.right = this.s.length() - 1;
        //不断删除
        move();
        //返回
        return Math.max(0, right - left + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Code13().minimumLength("bbbbbbbbbbbbbbbbbbb"));
    }

}
