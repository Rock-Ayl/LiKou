package normal47;

/**
 * @Author ayl
 * @Date 2025-10-15
 * 1946. 子字符串突变后可能得到的最大整数
 * 算术评级: 4
 * 第 251 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1445
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 num ，该字符串表示一个大整数。另给你一个长度为 10 且 下标从 0  开始 的整数数组 change ，该数组将 0-9 中的每个数字映射到另一个数字。更规范的说法是，数字 d 映射为数字 change[d] 。
 * <p>
 * 你可以选择 突变  num 的任一子字符串。突变 子字符串意味着将每位数字 num[i] 替换为该数字在 change 中的映射（也就是说，将 num[i] 替换为 change[num[i]]）。
 * <p>
 * 请你找出在对 num 的任一子字符串执行突变操作（也可以不执行）后，可能得到的 最大整数 ，并用字符串表示返回。
 * <p>
 * 子字符串 是字符串中的一个连续序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = "132", change = [9,8,5,0,3,6,4,2,6,8]
 * 输出："832"
 * 解释：替换子字符串 "1"：
 * - 1 映射为 change[1] = 8 。
 * 因此 "132" 变为 "832" 。
 * "832" 是可以构造的最大整数，所以返回它的字符串表示。
 * 示例 2：
 * <p>
 * 输入：num = "021", change = [9,4,3,5,7,2,1,9,0,6]
 * 输出："934"
 * 解释：替换子字符串 "021"：
 * - 0 映射为 change[0] = 9 。
 * - 2 映射为 change[2] = 3 。
 * - 1 映射为 change[1] = 4 。
 * 因此，"021" 变为 "934" 。
 * "934" 是可以构造的最大整数，所以返回它的字符串表示。
 * 示例 3：
 * <p>
 * 输入：num = "5", change = [1,4,7,5,3,2,5,6,9,4]
 * 输出："5"
 * 解释："5" 已经是可以构造的最大整数，所以返回它的字符串表示。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num.length <= 105
 * num 仅由数字 0-9 组成
 * change.length == 10
 * 0 <= change[d] <= 9
 */
public class Code2 {

    public String maximumNumber(String num, int[] change) {
        //结果
        StringBuilder str = new StringBuilder();
        //索引
        int index = 0;
        //循环,寻找第一开始的位置
        while (index < num.length()) {
            //当前数字
            int number = num.charAt(index) - '0';
            //另一个数字
            int otherNumber = change[number];
            //如果更大,说明找到了
            if (otherNumber > number) {
                //循环
                while (otherNumber >= number) {
                    //组装
                    str.append(otherNumber);
                    //下一个
                    index++;
                    //如果到头了
                    if (index == num.length()) {
                        //结束
                        break;
                    }
                    number = num.charAt(index) - '0';
                    otherNumber = change[number];
                }
                //跳出
                break;
            } else {
                //组装并+1
                str.append(num.charAt(index++));
            }
        }
        //循环,寻找第一开始的位置
        while (index < num.length()) {
            //组装并+1
            str.append(num.charAt(index++));
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        //System.out.println(new Code2().maximumNumber("021", new int[]{9, 4, 3, 5, 7, 2, 1, 9, 0, 6}));
        //System.out.println(new Code2().maximumNumber("132", new int[]{9, 8, 5, 0, 3, 6, 4, 2, 6, 8}));
        //System.out.println(new Code2().maximumNumber("5", new int[]{1, 4, 7, 5, 3, 2, 5, 6, 9, 4}));
        System.out.println(new Code2().maximumNumber("214010", new int[]{6,7,9,7,4,0,3,4,4,7}));
    }

}
