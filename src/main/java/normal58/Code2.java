package normal58;

/**
 * 1781. 所有子字符串美丽值之和
 * 算术评级: 4
 * 第 47 场双周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1715
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
 * <p>
 * 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
 * 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aabcb"
 * 输出：5
 * 解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。
 * 示例 2：
 * <p>
 * 输入：s = "aabcbaa"
 * 输出：17
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 */
public class Code2 {

    public int beautySum(String s) {
        //结果
        int sum = 0;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //数组
            int[] arr = new int[26];
            //最大
            int max = 1;
            //循环2
            for (int j = i; j < s.length(); j++) {
                //计算key
                int key = s.charAt(j) - 'a';
                //数组
                arr[key]++;
                //最大
                max = Math.max(max, arr[key]);
                //最小
                int min = Integer.MAX_VALUE;
                //循环
                for (int k = 0; k < arr.length; k++) {
                    //如果有
                    if (arr[k] > 0) {
                        //刷新
                        min = Math.min(min, arr[k]);
                    }
                }
                //本次结果
                sum += (max - min);
            }
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().beautySum("aabcb"));
    }

}
