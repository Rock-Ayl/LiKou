package normal31;

/**
 * @Author ayl
 * @Date 2024-04-18
 * 72. 编辑距离
 * 中等
 * 相关标签
 * 相关企业
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 * <p>
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 */
public class Code1 {

    private void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int num : ints) {
                System.out.print(num + ",");
            }
            System.out.println();
        }
    }

    public int minDistance(String word1, String word2) {
        //矩阵缓存
        int[][] arr = new int[word1.length() + 1][word2.length() + 1];
        //循环1
        for (int i = 1; i < arr.length; i++) {
            //初始化当前位置需要操作的次数
            arr[i][0] = i;
        }
        //循环2
        for (int j = 1; j < arr[0].length; j++) {
            //初始化当前位置需要操作的次数
            arr[0][j] = j;
        }
        //循环1
        for (int i = 1; i < arr.length; i++) {
            //循环2
            for (int j = 1; j < arr[0].length; j++) {
                //三种方案,来自三种情况
                int one = arr[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
                int two = arr[i - 1][j] + 1;
                int three = arr[i][j - 1] + 1;
                //选中三种最优中的一种
                arr[i][j] = Math.min(Math.min(one, two), three);
            }
        }
        //返回结果
        return arr[arr.length - 1][arr[0].length - 1];
    }

    public static void main(String[] args) {
        int i = new Code1().minDistance("plasma", "altruism");
        System.out.println();
    }

}
