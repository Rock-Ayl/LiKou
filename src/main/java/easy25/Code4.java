package easy25;

/**
 * @Author ayl
 * @Date 2022-11-23
 * 944. 删列造序
 * 给你由 n 个小写字母字符串组成的数组 strs，其中每个字符串长度相等。
 * <p>
 * 这些字符串可以每个一行，排成一个网格。例如，strs = ["abc", "bce", "cae"] 可以排列为：
 * <p>
 * abc
 * bce
 * cae
 * 你需要找出并删除 不是按字典序升序排列的 列。在上面的例子（下标从 0 开始）中，列 0（'a', 'b', 'c'）和列 2（'c', 'e', 'e'）都是按升序排列的，而列 1（'b', 'c', 'a'）不是，所以要删除列 1 。
 * <p>
 * 返回你需要删除的列数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["cba","daf","ghi"]
 * 输出：1
 * 解释：网格示意如下：
 * cba
 * daf
 * ghi
 * 列 0 和列 2 按升序排列，但列 1 不是，所以只需要删除列 1 。
 * 示例 2：
 * <p>
 * 输入：strs = ["a","b"]
 * 输出：0
 * 解释：网格示意如下：
 * a
 * b
 * 只有列 0 这一列，且已经按升序排列，所以不用删除任何列。
 * 示例 3：
 * <p>
 * 输入：strs = ["zyx","wvu","tsr"]
 * 输出：3
 * 解释：网格示意如下：
 * zyx
 * wvu
 * tsr
 * 所有 3 列都是非升序排列的，所以都要删除。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == strs.length
 * 1 <= n <= 100
 * 1 <= strs[i].length <= 1000
 * strs[i] 由小写英文字母组成
 */
public class Code4 {

    public int minDeletionSize(String[] strs) {
        //结果
        int result = 0;
        //长度
        int length = strs[0].length();
        //跳出
        out:
        //循环1
        for (int i = 0; i < length; i++) {
            //初始化第一个
            char last = strs[0].charAt(i);
            //循环2
            for (int j = 1; j < strs.length; j++) {
                //当前
                char space = strs[j].charAt(i);
                //如果降序了
                if (space < last) {
                    //记录该结果
                    result++;
                    //本次过
                    continue out;
                }
                //更换
                last = space;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().minDeletionSize(new String[]{
                "rrjk",
                "furt",
                "guzm"
        }));
    }

}
