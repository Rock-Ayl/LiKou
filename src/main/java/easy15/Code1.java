package easy15;

/**
 * @Author ayl
 * @Date 2021-11-16
 * 1539. 第 k 个缺失的正整数
 * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 * <p>
 * 请你找到这个数组里第 k 个缺失的正整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,3,4,7,11], k = 5
 * 输出：9
 * 解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,3,4], k = 2
 * 输出：6
 * 解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 1 <= k <= 1000
 * 对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j]
 */
public class Code1 {

    public int findKthPositive(int[] arr, int k) {
        //当前次数
        int size = 0;
        //上一位
        int last = 0;
        //循环
        for (int i = 0; i < arr.length; i++) {
            //当前
            int num = arr[i];
            //如果不是自增
            if (last != num - 1) {
                //计算出缺少的个数,并叠加
                size += num - last - 1;
                //如果找到了
                if (size >= k) {
                    //返回结果
                    return num - 1 - (size - k);
                }
            }
            //更换上一个
            last = num;
        }
        //默认
        return arr[arr.length - 1] + (k - size);
    }

    public static void main(String[] args) {
        System.out.println(new Code1().findKthPositive(new int[]{1, 2, 3, 4}, 2));
    }

}
