package easy39;

/**
 * @Author ayl
 * @Date 2024-12-20
 * 2381. 字母移位 II
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个小写英文字母组成的字符串 s 和一个二维整数数组 shifts ，其中 shifts[i] = [starti, endi, directioni] 。对于每个 i ，将 s 中从下标 starti 到下标 endi （两者都包含）所有字符都进行移位运算，如果 directioni = 1 将字符向后移位，如果 directioni = 0 将字符向前移位。
 * <p>
 * 将一个字符 向后 移位的意思是将这个字符用字母表中 下一个 字母替换（字母表视为环绕的，所以 'z' 变成 'a'）。类似的，将一个字符 向前 移位的意思是将这个字符用字母表中 前一个 字母替换（字母表是环绕的，所以 'a' 变成 'z' ）。
 * <p>
 * 请你返回对 s 进行所有移位操作以后得到的最终字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc", shifts = [[0,1,0],[1,2,1],[0,2,1]]
 * 输出："ace"
 * 解释：首先，将下标从 0 到 1 的字母向前移位，得到 s = "zac" 。
 * 然后，将下标从 1 到 2 的字母向后移位，得到 s = "zbd" 。
 * 最后，将下标从 0 到 2 的字符向后移位，得到 s = "ace" 。
 * 示例 2:
 * <p>
 * 输入：s = "dztz", shifts = [[0,0,0],[1,1,1]]
 * 输出："catz"
 * 解释：首先，将下标从 0 到 0 的字母向前移位，得到 s = "cztz" 。
 * 最后，将下标从 1 到 1 的字符向后移位，得到 s = "catz" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, shifts.length <= 5 * 104
 * shifts[i].length == 3
 * 0 <= starti <= endi < s.length
 * 0 <= directioni <= 1
 * s 只包含小写英文字母。
 */
public class Code8 {

    public String shiftingLetters(String s, int[][] shifts) {
        //数组
        int[] arr = new int[s.length() + 1];
        //循环
        for (int[] shift : shifts) {
            //计算偏移量
            arr[shift[0]] += shift[2] == 0 ? -1 : 1;
            arr[shift[1] + 1] += shift[2] == 0 ? 1 : -1;
        }
        //初始化结果
        StringBuilder str = new StringBuilder();
        //当前偏移量
        int other = 0;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //叠加当前偏移量,并修正
            other += arr[i];
            //字符转数字、叠加偏移量
            int num = s.charAt(i) - 'a' + other;
            //如果越界
            if (num >= 26) {
                //修正
                num = num % 26;
            }
            //如果越界
            if (num < 0) {
                //修正
                num = num + ((-num / 26 + (-num % 26 == 0 ? 0 : 1)) * 26);
            }
            //转为字符,组装结果
            str.append((char) (num + 'a'));
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code8().shiftingLetters("xuwdbdqik", new int[][]{
                new int[]{4, 8, 0},
                new int[]{4, 4, 0},
                new int[]{2, 4, 0},
                new int[]{2, 4, 0},
                new int[]{6, 7, 1},
                new int[]{2, 2, 1},
                new int[]{0, 2, 1},
                new int[]{8, 8, 0},
                new int[]{1, 3, 1}
        }));
    }

}
