package easy42;

/**
 * 100999. 移除尾部元音字母
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给定一个由小写英文字母组成的字符串 s。
 * <p>
 * 返回移除字符串 s 尾部 所有元音字母 后得到的字符串。
 * <p>
 * 元音字母包括字符 'a'、'e'、'i'、'o' 和 'u'。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "idea"
 * <p>
 * 输出： "id"
 * <p>
 * 解释：
 * <p>
 * 移除 "idea" 后，得到字符串 "id"。
 * <p>
 * 示例 2：
 * <p>
 * 输入： s = "day"
 * <p>
 * 输出： "day"
 * <p>
 * 解释：
 * <p>
 * 字符串 "day" 尾部没有元音字母。
 * <p>
 * 示例 3：
 * <p>
 * 输入： s = "aeiou"
 * <p>
 * 输出： ""
 * <p>
 * 解释：
 * <p>
 * 移除 "aeiou" 后，得到字符串 ""。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 仅由小写英文字母组成。
 */
public class Code13 {

    public String trimTrailingVowels(String s) {
        //元音数组
        int[] arr = new int[]{1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        //索引
        int right = s.length() - 1;
        //字符串
        StringBuffer str = new StringBuffer();
        //循环
        while (right >= 0) {
            //如果不是元音
            if (arr[s.charAt(right) - 'a'] == 0) {
                //跳出
                break;
            }
            //下一个
            right--;
        }
        //循环
        for (int i = 0; i <= right; i++) {
            //组装
            str.append(s.charAt(i));
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code13().trimTrailingVowels("idea"));
    }

}
