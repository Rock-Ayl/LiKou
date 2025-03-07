package easy2;

/**
 * Created By Rock-Ayl on 2020-10-19
 * 1446. 连续字符
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 * <p>
 * 请你返回字符串的能量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leetcode"
 * 输出：2
 * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 * 示例 2：
 * <p>
 * 输入：s = "abbcccddddeeeeedcba"
 * 输出：5
 * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
 * 示例 3：
 * <p>
 * 输入：s = "triplepillooooow"
 * 输出：5
 * 示例 4：
 * <p>
 * 输入：s = "hooraaaaaaaaaaay"
 * 输出：11
 * 示例 5：
 * <p>
 * 输入：s = "tourist"
 * 输出：1
 */
public class Code30 {

    public static int maxPower(String s) {
        //最长连续字符长度
        int size = 0;
        //上一个计算的字符连续长度
        int lastSize = 0;
        //上一个字符当前字符
        String lastStr = "";
        //循环
        for (char c : s.toCharArray()) {
            //转化为单个字符
            String str = c + "";
            //如果和上一个字符相同
            if (str.equals(lastStr)) {
                //连续递加
                lastSize++;
            }
            //如果不同，开始清算
            else {
                //如果是最长的字符
                if (lastSize > size) {
                    //记录
                    size = lastSize;
                }
                //归0
                lastSize = 0;
            }
            //记录
            lastStr = str;
        }
        //结尾开始清算
        if (lastSize > size) {
            //记录
            size = lastSize;
        }
        //返回
        return size + 1;
    }

    public static void main(String[] args) {
        System.out.println(maxPower("cc"));
    }
}
