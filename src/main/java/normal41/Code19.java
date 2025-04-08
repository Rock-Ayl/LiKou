package normal41;

/**
 * @Author ayl
 * @Date 2025-04-08
 * 2165. 重排数字的最小值
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数 num 。重排 num 中的各位数字，使其值 最小化 且不含 任何 前导零。
 * <p>
 * 返回不含前导零且值最小的重排数字。
 * <p>
 * 注意，重排各位数字后，num 的符号不会改变。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 310
 * 输出：103
 * 解释：310 中各位数字的可行排列有：013、031、103、130、301、310 。
 * 不含任何前导零且值最小的重排数字是 103 。
 * 示例 2：
 * <p>
 * 输入：num = -7605
 * 输出：-7650
 * 解释：-7605 中各位数字的部分可行排列为：-7650、-6705、-5076、-0567。
 * 不含任何前导零且值最小的重排数字是 -7650 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * -1015 <= num <= 1015
 */
public class Code19 {

    public long smallestNumber(long num) {
        //拆解为数字
        int[] arr = parse(num);
        //如果是正数、负数,然后实现
        return num >= 0L ? left(arr) : -right(arr);
    }

    //正数实现
    private long left(int[] arr) {

        /**
         * 固定第一个数字
         */

        //首数字
        long newNumber = -1L;
        //循环
        for (int i = 1; i < arr.length; i++) {
            //如果存在
            if (arr[i] > 0) {
                //使用之
                arr[i]--;
                newNumber = i;
                //跳出
                break;
            }
        }
        //如果没有
        if (newNumber == -1L) {
            //结束
            return 0L;
        }

        /**
         * 不断填充后续
         */

        //循环
        for (int i = 0; i < arr.length; i++) {
            //循环
            while (arr[i] > 0) {
                //使用之
                arr[i]--;
                newNumber = newNumber * 10L + i;
            }
        }

        //返回结果
        return newNumber;
    }

    //负数实现
    private long right(int[] arr) {

        /**
         * 固定第一个数字
         */

        //首数字
        long newNumber = -1L;
        //循环
        for (int i = arr.length - 1; i >= 1; i--) {
            //如果存在
            if (arr[i] > 0) {
                //使用之
                arr[i]--;
                newNumber = i;
                //跳出
                break;
            }
        }
        //如果没有
        if (newNumber == -1L) {
            //结束
            return 0L;
        }

        /**
         * 不断填充后续
         */

        //循环
        for (int i = arr.length - 1; i >= 0; i--) {
            //循环
            while (arr[i] > 0) {
                //使用之
                arr[i]--;
                newNumber = newNumber * 10L + i;
            }
        }

        //返回结果
        return newNumber;
    }

    //抽取数字实现
    private int[] parse(long num) {
        //变为正数
        num = Math.abs(num);
        //计数数组
        int[] result = new int[10];
        //如果有前置
        while (num > 9) {
            //+1
            result[(int) (num % 10L)]++;
            //下一个
            num = num / 10L;
        }
        //个位数处理
        result[(int) num]++;
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code19().smallestNumber(-7605L));
    }

}
