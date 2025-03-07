package normal37;

/**
 * @Author ayl
 * @Date 2024-11-12
 * 640. 求解方程
 * 中等
 * 相关标签
 * 相关企业
 * 求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
 * <p>
 * 如果方程没有解或存在的解不为整数，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
 * <p>
 * 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: equation = "x+5-3+x=6+x-2"
 * 输出: "x=2"
 * 示例 2:
 * <p>
 * 输入: equation = "x=x"
 * 输出: "Infinite solutions"
 * 示例 3:
 * <p>
 * 输入: equation = "2x=x"
 * 输出: "x=0"
 * <p>
 * <p>
 * 提示:
 * <p>
 * 3 <= equation.length <= 1000
 * equation 只有一个 '='.
 * 方程由绝对值在 [0, 100]  范围内且无任何前导零的整数和变量 'x' 组成。
 */
public class Code8 {

    //拆分
    private int[] split(String sentence) {
        //补充一个+
        sentence = "+" + sentence;
        //x的数量
        int xCount = 0;
        //数字和
        int numSum = 0;
        //索引
        int index = 0;
        //循环
        while (index < sentence.length()) {
            //获取对应符号,这里 不是+就是-
            char symbol = sentence.charAt(index++);
            //数字
            int num = 0;
            //操作次数
            int count = 0;
            //循环
            while (true) {
                //操作+1
                count++;
                //结束了 or 下一个公式
                if (index >= sentence.length() || sentence.charAt(index) == '+' || sentence.charAt(index) == '-') {
                    //根据前置符号,记录本次和
                    numSum += symbol == '+' ? num : -num;
                    //跳出
                    break;
                }
                //如果是x
                if (sentence.charAt(index) == 'x') {
                    //修改下x数量
                    num = count == 1 ? 1 : num;
                    //根据前置符号,记录x的数量
                    xCount += symbol == '+' ? num : -num;
                    //跳出
                    break;
                }
                //叠加本次和
                num = num * 10 + (sentence.charAt(index) - '0');
                //下一个
                index++;
            }
        }
        //返回结果
        return new int[]{xCount, numSum};
    }

    public String solveEquation(String equation) {
        //拆分左右
        String[] arr = equation.split("=");
        //分别计算左右结果
        int[] leftResult = split(arr[0]);
        int[] rightResult = split(arr[1]);
        //左边的结果
        int leftXCount = leftResult[0];
        int leftNumSum = leftResult[1];
        //右边的结果
        int rightXCount = rightResult[0];
        int rightNumSum = rightResult[1];
        //计算最小情况
        int minXCount = Math.min(leftXCount, rightXCount);
        int minNumSum = Math.min(leftNumSum, rightNumSum);
        //清算
        leftXCount -= minXCount;
        rightXCount -= minXCount;
        leftNumSum -= minNumSum;
        rightNumSum -= minNumSum;
        //如果是特殊情况
        if (leftXCount == rightXCount) {
            //如果是特殊情况
            if (leftNumSum != rightNumSum) {
                //返回
                return "No solution";
            }
            //返回
            return "Infinite solutions";
        }
        //如果是特殊情况
        if (leftNumSum == rightNumSum) {
            //返回
            return "x=0";
        }
        //如果左边全空
        if (leftXCount == 0 && leftNumSum == 0) {
            //返回结果
            return "x=-" + rightNumSum / rightXCount;
        }
        //如果右边全空
        if (rightXCount == 0 && rightNumSum == 0) {
            //返回结果
            return "x=-" + leftNumSum / leftXCount;
        }
        //目标结果
        int target;
        //判断x在左边还是右边
        if (leftXCount > 0) {
            //计算目标结果
            target = rightNumSum / leftXCount;
        } else {
            //计算目标结果
            target = leftNumSum / rightXCount;
        }
        //返回
        return "x=" + target;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().solveEquation("0x=0"));
    }

}
