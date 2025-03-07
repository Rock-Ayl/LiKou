package easy5;

/**
 * Created By Rock-Ayl on 2021-01-18
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class Code18 {

    public static String longestCommonPrefix(String[] strs) {
        //判空
        if (strs == null || strs.length == 0) {
            //缺省
            return "";
        }
        //初始化前缀
        StringBuffer prefix = new StringBuffer();
        //单词最短长度
        int minSize = strs[0].length();
        //循环
        for (int i = 1; i < strs.length; i++) {
            //计算最短长度
            minSize = Math.min(strs[i].length(), minSize);
        }
        all:
        //循环
        for (int i = 0; i < minSize; i++) {
            //当前字符
            char thisChar = strs[0].charAt(i);
            //循环
            for (int i1 = 1; i1 < strs.length; i1++) {
                //如果接下来的第一个不相同
                if (thisChar != strs[i1].charAt(i)) {
                    //中断
                    break all;
                }
            }
            //记录公共前缀
            prefix.append(thisChar);
        }
        //返回
        return prefix.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

}
