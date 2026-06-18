package normal54;

/**
 * 1007. 行相等的最少多米诺旋转
 * 算术评级: 5
 * 第 127 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1541
 * 相关标签
 * premium lock icon
 * 相关企业
 * 在一排多米诺骨牌中，tops[i] 和 bottoms[i] 分别代表第 i 个多米诺骨牌的上半部分和下半部分。（一个多米诺是两个从 1 到 6 的数字同列平铺形成的 —— 该平铺的每一半上都有一个数字。）
 * <p>
 * 我们可以旋转第 i 张多米诺，使得 tops[i] 和 bottoms[i] 的值交换。
 * <p>
 * 返回能使 tops 中所有值或者 bottoms 中所有值都相同的最小旋转次数。
 * <p>
 * 如果无法做到，返回 -1.
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
 * 输出：2
 * 解释：
 * 图一表示：在我们旋转之前， tops 和 bottoms 给出的多米诺牌。
 * 如果我们旋转第二个和第四个多米诺骨牌，我们可以使上面一行中的每个值都等于 2，如图二所示。
 * 示例 2：
 * <p>
 * 输入：tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
 * 输出：-1
 * 解释： 在这种情况下，不可能旋转多米诺牌使一行的值相等。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= tops.length <= 2 * 104
 * bottoms.length == tops.length
 * 1 <= tops[i], bottoms[i] <= 6
 */
public class Code12 {

    public int minDominoRotations(int[] tops, int[] bottoms) {

        /**
         * 寻找目标数字
         */

        //两种可能
        int firstNum = tops[0];
        int secondNum = bottoms[0];
        //两种可能上下的计数器
        int firstTopCount = 0;
        int firstBottomCount = 0;
        int secondTopCount = 0;
        int secondBottomCount = 0;
        //循环
        for (int i = 0; i < tops.length; i++) {
            //两个数字
            int top = tops[i];
            int bottom = bottoms[i];
            //如果第一个数字不可能了
            if (firstNum != 0 && top != firstNum && bottom != firstNum) {
                //覆盖
                firstNum = 0;
            } else {
                //叠加计数
                firstTopCount += top == firstNum ? 1 : 0;
                firstBottomCount += bottom == firstNum ? 1 : 0;
            }
            //如果第二个数字不可能了
            if (secondNum != 0 && top != secondNum && bottom != secondNum) {
                //覆盖
                secondNum = 0;
            } else {
                //叠加计数
                secondTopCount += top == secondNum ? 1 : 0;
                secondBottomCount += bottom == secondNum ? 1 : 0;
            }
        }

        /**
         * 计算结果
         */

        //如果数字1可以有结果
        if (firstNum != 0) {
            //返回
            return tops.length - Math.max(firstTopCount, firstBottomCount);
        }
        //如果数字2可以有结果
        if (secondNum != 0) {
            //返回
            return tops.length - Math.max(secondTopCount, secondBottomCount);
        }
        //默认-1
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}));
    }

}
