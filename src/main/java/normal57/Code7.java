package normal57;

/**
 * 788. 旋转数字
 * 算术评级: 3
 * 第 73 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1397
 * 相关标签
 * premium lock icon
 * 相关企业
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 * <p>
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 * <p>
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释:
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 * <p>
 * <p>
 * 提示：
 * <p>
 * N 的取值范围是 [1, 10000]。
 */
public class Code7 {

    public int rotatedDigits(int n) {
        //次数
        int count = 0;
        //循环
        for (int i = 1; i <= n; i++) {
            //计算本次
            count += count(i);
        }
        //返回
        return count;
    }

    //是与不是
    private static final int[] arr = new int[]{0, 1, 5, -1, -1, 2, 9, -1, 8, 6};

    //该字段是不是
    private int count(int n) {
        //另一个数字
        int other = 0;
        //倍率
        int otherHit = 1;
        //当前数字
        int num = n;
        //循环
        while (num > 0) {
            //获取当前数字
            int part = num % 10;
            //如果无效
            if (arr[part] == -1) {
                //直接返回
                return 0;
            }
            //叠加
            other += arr[part] * otherHit;
            //更新倍率
            otherHit *= 10;
            //更新当前位
            num = num / 10;
        }
        //如果相同
        if (other == n) {
            //不是
            return 0;
        }
        //默认是
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().rotatedDigits(10));
    }

}
