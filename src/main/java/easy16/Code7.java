package easy16;

/**
 * @Author ayl
 * @Date 2021-12-09
 * 2027. 转换字符串的最少操作次数
 * 给你一个字符串 s ，由 n 个字符组成，每个字符不是 'X' 就是 'O' 。
 * <p>
 * 一次 操作 定义为从 s 中选出 三个连续字符 并将选中的每个字符都转换为 'O' 。注意，如果字符已经是 'O' ，只需要保持 不变 。
 * <p>
 * 返回将 s 中所有字符均转换为 'O' 需要执行的 最少 操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "XXX"
 * 输出：1
 * 解释：XXX -> OOO
 * 一次操作，选中全部 3 个字符，并将它们转换为 'O' 。
 * 示例 2：
 * <p>
 * 输入：s = "XXOX"
 * 输出：2
 * 解释：XXOX -> OOOX -> OOOO
 * 第一次操作，选择前 3 个字符，并将这些字符转换为 'O' 。
 * 然后，选中后 3 个字符，并执行转换。最终得到的字符串全由字符 'O' 组成。
 * 示例 3：
 * <p>
 * 输入：s = "OOOO"
 * 输出：0
 * 解释：s 中不存在需要转换的 'X' 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= s.length <= 1000
 * s[i] 为 'X' 或 'O'
 */
public class Code7 {

    public int minimumMoves(String s) {
        //次数
        int size = 0;
        //组
        char[] arr = s.toCharArray();
        //循环
        for (int i = 0; i < arr.length; i++) {
            //如果必须替换
            if (arr[i] == 'X') {
                //进2+1
                i = i + 2;
                //记录
                size++;
            }
        }
        //返回
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().minimumMoves("XXOX"));
    }

}
