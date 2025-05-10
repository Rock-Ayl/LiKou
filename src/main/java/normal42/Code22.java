package normal42;

/**
 * @Author ayl
 * @Date 2025-05-11
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：left = 5, right = 7
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：left = 0, right = 0
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：left = 1, right = 2147483647
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= left <= right <= 231 - 1
 */
public class Code22 {

    public int rangeBitwiseAnd(int left, int right) {

        /**
         * 特殊情况处理
         */

        //如果相同
        if (left == right) {
            //直接返回
            return right;
        }
        //如果有0
        if (left < 1 || right < 1) {
            //过
            return 0;
        }

        /**
         * 计算二者转为二进制后,长度是否一致
         * 1. 如果一致: eg 100,110 则从前数所有连着的1,后续结果均为一
         * 2. 如果不一致: eg 1,10 则二者逻辑与必然为0
         */

        //位移0补完次数
        int count = 0;
        //第一次相同
        boolean firstSame = true;
        //第一次相同时,二者剩余的位移数字
        int firstNum = 0;
        //循环
        while (left > 1 && right > 1) {
            //如果此时不同,说明二者前缀不同
            if (left != right) {
                //+1
                count++;
            }
            //位移
            left = left >> 1;
            right = right >> 1;
            //如果第一次相同
            if (firstSame == true && left == right) {
                //记录二者第一次相同的前缀
                firstNum = left;
                //不准备再记录后续相同
                firstSame = false;
            }
        }
        //如果二进制长度不一样
        if (left != right) {
            //结果一定为0
            return 0;
        }

        /**
         * 如果长度一样,理论上存在前缀全是1的情况,按照firstNum补完后续位移0
         */

        //循环
        while (--count >= 0) {
            //补完位移0
            firstNum = firstNum << 1;
        }
        //返回
        return firstNum;
    }

    public static void main(String[] args) {
        System.out.println(new Code22().rangeBitwiseAnd(4, 5));
    }

}
