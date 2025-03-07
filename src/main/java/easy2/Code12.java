package easy2;

/**
 * Created By Rock-Ayl on 2020-09-30
 * 1550. 存在连续三个奇数的数组
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,6,4,1]
 * 输出：false
 * 解释：不存在连续三个元素都是奇数的情况。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,34,3,4,5,7,23,12]
 * 输出：true
 * 解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。
 */
public class Code12 {

    public static boolean threeConsecutiveOdds(int[] arr) {
        //初始化奇数个数
        int a = 0;
        //循环
        for (int i : arr) {
            //判断是否为偶数
            if (i % 2 == 0) {
                //重置
                a = 0;
            } else {
                //叠加
                a++;
                //如果连续3次
                if (a == 3) {
                    //存在
                    return true;
                }
            }
        }
        //缺省不存在
        return false;
    }

    public static void main(String[] args) {
        System.out.println(threeConsecutiveOdds(new int[]{1, 3, 5}));
    }
}
