package normal36;

/**
 * @Author ayl
 * @Date 2024-10-20
 * LCR 014. 字符串的排列
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 * <p>
 * <p>
 * 注意：本题与主站 567 题相同： https://leetcode-cn.com/problems/permutation-in-string/
 */
public class Code10 {

    public boolean checkInclusion(String s1, String s2) {
        //缓存
        int[] arr = new int[27];
        //非0的数量
        int noZeroCount = 0;
        //循环
        for (char letter : s1.toCharArray()) {
            //+1记录
            if (++arr[letter - 'a'] == 1) {
                //+1
                noZeroCount++;
            }
        }
        //双指针
        int start = 0;
        int end = 0;
        //循环
        while (end < s2.length()) {
            //右边索引
            int endIndex = s2.charAt(end++) - 'a';
            //获取-1,如果是
            if (--arr[endIndex] == 0) {
                //-1
                noZeroCount--;
            }
            //如果是
            if (arr[endIndex] == -1) {
                //+1
                noZeroCount++;
            }
            //如果多了
            while (end - start > s1.length()) {
                //左边索引
                int startIndex = s2.charAt(start++) - 'a';
                //获取+1,如果是
                if (++arr[startIndex] == 0) {
                    //-1
                    noZeroCount--;
                }
                //如果是
                if (arr[startIndex] == 1) {
                    //+1
                    noZeroCount++;
                }
            }
            //如果正好
            if (end - start == s1.length() && noZeroCount == 0) {
                //返回
                return true;
            }
        }
        //默认没有
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code10().checkInclusion("ab", "eidbaooo"));
    }

}
