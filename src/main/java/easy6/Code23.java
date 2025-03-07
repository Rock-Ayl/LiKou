package easy6;

/**
 * Created By Rock-Ayl on 2021-02-21
 * 1652. 拆炸弹
 * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
 * <p>
 * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
 * <p>
 * 如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
 * 如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
 * 如果 k == 0 ，将第 i 个数字用 0 替换。
 * 由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
 * <p>
 * 给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
 * <p>
 * 示例 1：
 * <p>
 * 输入：code = [5,7,1,4], k = 3
 * 输出：[12,10,16,13]
 * 解释：每个数字都被接下来 3 个数字之和替换。解密后的密码为 [7+1+4, 1+4+5, 4+5+7, 5+7+1]。注意到数组是循环连接的。
 * 示例 2：
 * <p>
 * 输入：code = [1,2,3,4], k = 0
 * 输出：[0,0,0,0]
 * 解释：当 k 为 0 时，所有数字都被 0 替换。
 * 示例 3：
 * <p>
 * 输入：code = [2,4,9,3], k = -2
 * 输出：[12,5,6,13]
 * 解释：解密后的密码为 [3+9, 2+3, 4+2, 9+4] 。注意到数组是循环连接的。如果 k 是负数，那么和为 之前 的数字。
 */
public class Code23 {

    public static int[] decrypt(int[] code, int k) {
        //长度
        int size = code.length;
        //第一种
        if (k == 0) {
            //返回
            return new int[size];
        }
        //初始化结果
        int[] result = new int[size];
        //循环
        for (int i = 0; i < result.length; i++) {
            //和
            int sum = 0;
            //根据正负计算
            if (k > 0) {
                //位置
                int p = i;
                //该位置之前和的次数
                int num = k;
                //循环
                while (num > 0) {
                    //递增
                    p++;
                    //如果越界了
                    if (p == size) {
                        //回到最左边
                        p = 0;
                    }
                    //叠加
                    sum += code[p];
                    //递减
                    num--;
                }
            } else {
                //位置
                int p = i;
                //该位置之前和的次数
                int num = k;
                //循环
                while (num < 0) {
                    //递减
                    p--;
                    //如果越界了
                    if (p < 0) {
                        //回到最右边
                        p = size - 1;
                    }
                    //叠加
                    sum += code[p];
                    //递增
                    num++;
                }
            }
            //该位置结果
            result[i] = sum;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (int i : decrypt(new int[]{5, 7, 1, 4}, 3)) {
            System.out.println(i);
        }
    }

}
