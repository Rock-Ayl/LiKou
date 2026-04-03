package normal51;

import java.lang.ref.PhantomReference;

/**
 * 2429. 最小异或
 * 算术评级: 5
 * 第 313 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1532
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个正整数 num1 和 num2 ，找出满足下述条件的正整数 x ：
 * <p>
 * x 的置位数和 num2 相同，且
 * x XOR num1 的值 最小
 * 注意 XOR 是按位异或运算。
 * <p>
 * 返回整数 x 。题目保证，对于生成的测试用例， x 是 唯一确定 的。
 * <p>
 * 整数的 置位数 是其二进制表示中 1 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num1 = 3, num2 = 5
 * 输出：3
 * 解释：
 * num1 和 num2 的二进制表示分别是 0011 和 0101 。
 * 整数 3 的置位数与 num2 相同，且 3 XOR 3 = 0 是最小的。
 * 示例 2：
 * <p>
 * 输入：num1 = 1, num2 = 12
 * 输出：3
 * 解释：
 * num1 和 num2 的二进制表示分别是 0001 和 1100 。
 * 整数 3 的置位数与 num2 相同，且 3 XOR 1 = 2 是最小的。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num1, num2 <= 109
 */
public class Code21 {

    public int minimizeXor(int num1, int num2) {
        //分别计算 置位数
        int oneCount = Integer.bitCount(num1);
        int twoCount = Integer.bitCount(num2);
        //如果相同
        if (oneCount == twoCount) {
            //返回
            return num1;
        }
        //如果左边小于右边
        if (oneCount < twoCount) {
            //如果左边大于右边
            return small(num1, oneCount, twoCount);
        } else {
            //如果右边大于左边
            return big(num1, oneCount, twoCount);
        }
    }

    //如果左边大于右边
    private int small(int num1, int oneCount, int twoCount) {
        //转为数字
        String binaryString = Integer.toBinaryString(num1);
        //字符串
        StringBuffer str = new StringBuffer(binaryString);
        //还剩下
        int had = twoCount - oneCount;
        //循环
        for (int i = str.length() - 1; i >= 0; i--) {
            //如果是0
            if (had > 0 && str.charAt(i) == '0') {
                //替换为1
                str.setCharAt(i, '1');
                //-1,如果到头了
                if (--had == 0) {
                    //跳出
                    break;
                }
            }
        }
        //左边
        StringBuffer left = new StringBuffer();
        //如果还有
        while (had-- > 0) {
            //叠加
            left.append('1');
        }
        //返回
        return Integer.parseInt((left.toString() + str.toString()), 2);
    }

    //如果右边大于左边
    private int big(int num1, int oneCount, int twoCount) {
        //转为数字
        String binaryString = Integer.toBinaryString(num1);
        //字符串
        StringBuffer str = new StringBuffer();
        //循环
        for (int i = 0; i < binaryString.length(); i++) {
            //如果还有
            if (binaryString.charAt(i) == '1' && twoCount > 0) {
                //使用1
                str.append('1');
                twoCount--;
            } else {
                //使用0
                str.append('0');
            }
        }
        //返回
        return Integer.parseInt(str.toString(), 2);
    }

    public static void main(String[] args) {
        System.out.println(new Code21().minimizeXor(1, 12));
    }

}