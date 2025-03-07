package easy3;

/**
 * Created By Rock-Ayl on 2020-10-25
 * 485. 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 * <p>
 * 输入的数组只包含 0 和1。
 */
public class Code5 {

    public static int findMaxConsecutiveOnes(int[] nums) {
        //最大连续1数
        int maxSize = 0;
        //当前连续1数
        int thisSize = 0;
        //循环
        for (int num : nums) {
            //如果是1
            if (num == 1) {
                //当前叠加
                thisSize++;
            }
            //开始清算
            else {
                //如果更新了记录
                if (thisSize > maxSize) {
                    //更新
                    maxSize = thisSize;
                }
                //重置
                thisSize = 0;
            }
        }
        //结尾计算一下
        if (thisSize > maxSize) {
            //更新
            maxSize = thisSize;
        }
        //返回
        return maxSize;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }
}
