package normal18;

/**
 * @Author ayl
 * @Date 2023-02-03
 * 2516. 每种字符至少取 K 个
 * 给你一个由字符 'a'、'b'、'c' 组成的字符串 s 和一个非负整数 k 。每分钟，你可以选择取走 s 最左侧 还是 最右侧 的那个字符。
 * <p>
 * 你必须取走每种字符 至少 k 个，返回需要的 最少 分钟数；如果无法取到，则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aabaaaacaabc", k = 2
 * 输出：8
 * 解释：
 * 从 s 的左侧取三个字符，现在共取到两个字符 'a' 、一个字符 'b' 。
 * 从 s 的右侧取五个字符，现在共取到四个字符 'a' 、两个字符 'b' 和两个字符 'c' 。
 * 共需要 3 + 5 = 8 分钟。
 * 可以证明需要的最少分钟数是 8 。
 * 示例 2：
 * <p>
 * 输入：s = "a", k = 1
 * 输出：-1
 * 解释：无法取到一个字符 'b' 或者 'c'，所以返回 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 仅由字母 'a'、'b'、'c' 组成
 * 0 <= k <= s.length
 */
public class Code19 {

    public int takeCharacters(String s, int k) {
        //最大可能
        int minLength = -1;
        //初始化
        int[] arr = new int[3];
        //指针
        int left = -1;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //记录当前数量
            arr[s.charAt(i) - 'a']++;
            //如果满足条件了
            if (arr[0] >= k && arr[1] >= k && arr[2] >= k) {
                //刷新可能性
                minLength = i + 1;
                //记录位置
                left = i;
                //跳出
                break;
            }
        }
        //如果到头了还没全
        if (minLength == -1) {
            //返回
            return minLength;
        }
        //右边结果
        int right = s.length() - 1;
        //滑动,如果左边可以删除
        while (left >= 0) {
            //先左边减
            arr[s.charAt(left--) - 'a']--;
            //如果此时不满足条件了,无线走
            while (arr[0] < k || arr[1] < k || arr[2] < k) {
                //再右边加
                arr[s.charAt(right--) - 'a']++;
            }
            //计算最终最小可能
            minLength = Math.min(minLength, left + s.length() - right);
        }
        //返回
        return minLength;
    }

    public static void main(String[] args) {
        System.out.println(new Code19().takeCharacters("aabaaaacaabc", 2));
    }

}
