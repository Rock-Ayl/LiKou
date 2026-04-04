package easy42;

import javafx.scene.control.Alert;

/**
 * 3884. 双端字符匹配
 * 算术评级: 1
 * 第 495 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1161
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的字符串 s，其中只包含小写英文字母。
 * <p>
 * 返回最小的下标 i，使得 s[i] == s[n - i - 1]。
 * <p>
 * 如果不存在这样的下标，返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "abcacbd"
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * 在下标 i = 1 处，s[1] 和 s[5] 的值均为 'b'。
 * <p>
 * 没有更小的下标满足条件，因此答案是 1。
 * <p>
 * 示例 2：
 * <p>
 * 输入： s = "abc"
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * ​​​​​​​在下标 i = 1 处，左右对应位置重合，因此字符均为 'b'。
 * <p>
 * 没有更小的下标满足条件，因此答案是 1。
 * <p>
 * 示例 3：
 * <p>
 * 输入： s = "abcdab"
 * <p>
 * 输出： -1
 * <p>
 * 解释：
 * <p>
 * ​​​​​​​对于每个下标 i，位置 i 和 n - i - 1 的字符均不相同。
 * <p>
 * 因此，不存在有效下标，答案是 -1。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == s.length <= 100
 * s 仅包含小写英文字母。
 */
public class Code22 {

    public int firstMatchingIndex(String s) {
        //双指针
        int left = 0;
        int right = s.length() - 1;
        //循环
        while (left <= right) {
            //如果满足
            if(s.charAt(left) == s.charAt(right)){
                //返回
                return left;
            }
            //下一个
            left++;
            right--;
        }
        //默认
        return -1;
    }

    public static void main(String[] args) {

    }
}
