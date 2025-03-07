package easy15;

/**
 * @Author ayl
 * @Date 2021-11-20
 * 941. 有效的山脉数组
 * 给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
 * <p>
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * <p>
 * arr.length >= 3
 * 在 0 < i < arr.length - 1 条件下，存在 i 使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：arr = [3,5,5]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：arr = [0,3,2,1]
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 104
 * 0 <= arr[i] <= 104
 */
public class Code5 {

    public boolean validMountainArray(int[] arr) {
        //最小值
        if (arr.length < 3) {
            //不是
            return false;
        }
        //是否为上坡
        boolean isUp = true;
        //上下坡数量
        int up = 0, down = 0;
        //循环
        for (int i = 0; i < arr.length - 1; i++) {
            //如果相等
            if (arr[i + 1] == arr[i]) {
                //肯定不是
                return false;
            }
            //如果是上
            if (isUp) {
                //如果不是上坡了
                if (arr[i + 1] < arr[i]) {
                    //更改
                    isUp = false;
                    //次数
                    down++;
                } else {
                    //次数
                    up++;
                }
            } else {
                //次数
                down++;
                //如果不是下坡了
                if (arr[i + 1] > arr[i]) {
                    //不是
                    return false;
                }
            }
        }
        //如果还是上坡
        if (isUp) {
            //肯定不是啦
            return false;
        } else {
            //如果没有上坡或下坡
            if (up == 0 || down == 0) {
                //过
                return false;
            }
        }
        //默认是
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().validMountainArray(new int[]{3, 5, 5}));
    }

}
