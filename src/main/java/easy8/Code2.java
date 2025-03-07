package easy8;

/**
 * Created By Rock-Ayl on 2021-05-29
 * 605. 种花问题
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] 为 0 或 1
 * flowerbed 中不存在相邻的两朵花
 * 0 <= n <= flowerbed.length
 */
public class Code2 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //可以多种多少花
        int flowers = 0;
        //如果只有1
        if (flowerbed.length == 1) {
            //如果可能满足
            if (n < 2) {
                //如果可以种花
                if (flowerbed[0] == 0) {
                    //计算
                    flowers++;
                }
                //如果满足
                if (flowers >= n) {
                    //可以
                    return true;
                }
            }
            //默认
            return false;
        }
        //边界左
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            //写
            flowerbed[0] = 1;
            //记录
            flowers++;
        }
        //循环
        for (int i = 1; i < flowerbed.length - 1; i++) {
            //当可以种花时
            if (flowerbed[i] == 0) {
                //左右
                int a = flowerbed[i - 1];
                int b = flowerbed[i + 1];
                //如果左右均为0
                if (a == 0 && b == 0) {
                    //写
                    flowerbed[i] = 1;
                    //记录
                    flowers++;
                }
            }
        }
        //边界右
        if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
            //写
            flowerbed[flowerbed.length - 1] = 1;
            //记录
            flowers++;
        }
        //如果满足
        if (flowers >= n) {
            //可以
            return true;
        } else {
            //不可以
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code2().canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
    }

}
