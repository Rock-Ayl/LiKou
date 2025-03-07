package easy23;

/**
 * @Author ayl
 * @Date 2022-09-21
 * 1534. 统计好三元组
 * 给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。
 * <p>
 * 如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。
 * <p>
 * 0 <= i < j < k < arr.length
 * |arr[i] - arr[j]| <= a
 * |arr[j] - arr[k]| <= b
 * |arr[i] - arr[k]| <= c
 * 其中 |x| 表示 x 的绝对值。
 * <p>
 * 返回 好三元组的数量 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
 * 输出：4
 * 解释：一共有 4 个好三元组：[(3,0,1), (3,0,1), (3,1,1), (0,1,1)] 。
 * 示例 2：
 * <p>
 * 输入：arr = [1,1,2,2,3], a = 0, b = 0, c = 1
 * 输出：0
 * 解释：不存在满足所有条件的三元组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= arr.length <= 100
 * 0 <= arr[i] <= 1000
 * 0 <= a, b, c <= 1000
 */
public class Code7 {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        //结果
        int count = 0;
        //循环1
        for (int i = 0; i < arr.length; i++) {
            //第一个
            int first = arr[i];
            //循环2
            for (int j = i + 1; j < arr.length; j++) {
                //第二个
                int second = arr[j];
                //如果前两个不满足
                if (Math.abs(first - second) > a) {
                    //过
                    continue;
                }
                //循环3
                for (int k = j + 1; k < arr.length; k++) {
                    //第三个
                    int third = arr[k];
                    //如果前两个满足 and 一、三满足
                    if (Math.abs(second - third) <= b && Math.abs(first - third) <= c) {
                        //+1
                        count++;
                    }
                }
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().countGoodTriplets(new int[]{3, 0, 1, 1, 9, 7}, 7, 2, 3));
    }
}
