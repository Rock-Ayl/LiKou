package easy;

import java.util.HashMap;

/**
 * Created By Rock-Ayl on 2020-09-05
 * 1528. 重新排列字符串
 * 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
 * <p>
 * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
 * <p>
 * 返回重新排列后的字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 * 输出："leetcode"
 * 解释：如图所示，"codeleet" 重新排列后变为 "leetcode" 。
 * 示例 2：
 * <p>
 * 输入：s = "abc", indices = [0,1,2]
 * 输出："abc"
 * 解释：重新排列后，每个字符都还留在原来的位置上。
 * 示例 3：
 * <p>
 * 输入：s = "aiohn", indices = [3,1,4,2,0]
 * 输出："nihao"
 * 示例 4：
 * <p>
 * 输入：s = "aaiougrt", indices = [4,0,2,6,7,3,1,5]
 * 输出："arigatou"
 * 示例 5：
 * <p>
 * 输入：s = "art", indices = [1,0,2]
 * 输出："rat"
 */
public class Code28 {

    public static String restoreString(String s, int[] indices) {
        //初始化返回值
        StringBuffer result = new StringBuffer();
        //分割
        char[] charArr = s.toCharArray();
        //初始化缓存
        HashMap<Integer, String> map = new HashMap<>();
        //循环
        for (int i = 0; i < indices.length; i++) {
            //记录
            map.put(indices[i], charArr[i] + "");
        }
        //循环
        for (int i = 0; i < indices.length; i++) {
            //组装
            result.append(map.get(i));
        }
        //返回
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
    }
}
