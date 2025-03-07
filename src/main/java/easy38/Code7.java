package easy38;

/**
 * @Author ayl
 * @Date 2024-09-01
 * 3270. 求出数字答案
 * 简单
 * 相关企业
 * 给你三个 正 整数 num1 ，num2 和 num3 。
 * <p>
 * 数字 num1 ，num2 和 num3 的数字答案 key 是一个四位数，定义如下：
 * <p>
 * 一开始，如果有数字 少于 四位数，给它补 前导 0 。
 * 答案 key 的第 i 个数位（1 <= i <= 4）为 num1 ，num2 和 num3 第 i 个数位中的 最小 值。
 * 请你返回三个数字 没有 前导 0 的数字答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num1 = 1, num2 = 10, num3 = 1000
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 补前导 0 后，num1 变为 "0001" ，num2 变为 "0010" ，num3 保持不变，为 "1000" 。
 * <p>
 * 数字答案 key 的第 1 个数位为 min(0, 0, 1) 。
 * 数字答案 key 的第 2 个数位为 min(0, 0, 0) 。
 * 数字答案 key 的第 3 个数位为 min(0, 1, 0) 。
 * 数字答案 key 的第 4 个数位为 min(1, 0, 0) 。
 * 所以数字答案为 "0000" ，也就是 0 。
 * <p>
 * 示例 2：
 * <p>
 * 输入： num1 = 987, num2 = 879, num3 = 798
 * <p>
 * 输出：777
 * <p>
 * 示例 3：
 * <p>
 * 输入：num1 = 1, num2 = 2, num3 = 3
 * <p>
 * 输出：1
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num1, num2, num3 <= 9999
 */
public class Code7 {

    //数字组装至数组
    private void set(int[] arr, int num) {
        //数组索引
        int index = arr.length - 1;
        //循环
        while (num > 0) {
            //记录,并进位
            arr[index--] = num % 10;
            //下一个
            num = num / 10;
        }
    }

    public int generateKey(int num1, int num2, int num3) {
        //缓存
        int[][] arr = new int[3][4];
        //组装
        set(arr[0], num1);
        set(arr[1], num2);
        set(arr[2], num3);
        //结果
        int result = 0;
        //循环1
        for (int j = 0; j < arr[0].length; j++) {
            //先翻倍
            result = result * 10;
            //初始化最小情况
            int min = arr[0][j];
            //循环2
            for (int i = 1; i < arr.length; i++) {
                //刷新最小值
                min = Math.min(min, arr[i][j]);
            }
            //累加
            result += min;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().generateKey(987, 879, 798));
    }

}
