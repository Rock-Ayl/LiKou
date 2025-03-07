package easy21;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2022-07-10
 * 1013. 将数组分成和相等的三个部分
 * 给你一个整数数组 arr，只有可以将其划分为三个和相等的 非空 部分时才返回 true，否则返回 false。
 * <p>
 * 形式上，如果可以找出索引 i + 1 < j 且满足 (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1]) 就可以将数组三等分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 示例 2：
 * <p>
 * 输入：arr = [0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：arr = [3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= arr.length <= 5 * 104
 * -104 <= arr[i] <= 104
 */
public class Code2 {

    //计算
    public boolean count(int[] arr, int target) {
        //满足条件的数组列表
        int count = 0;
        //当前和
        int sum = 0;
        //循环
        for (int i = 0; i < arr.length; i++) {
            //当前
            int num = arr[i];
            //叠加
            sum += num;
            //如果是目标,并且不是最后一个
            if (sum == target && count < 3) {
                //进位
                count++;
                //初始化
                sum = 0;
            }
        }
        //默认过
        return sum == 0;
    }

    public boolean canThreePartsEqualSum(int[] arr) {
        //如果不满足等分3分
        if (arr.length < 3) {
            //过
            return false;
        }
        //求和
        int sum = Arrays.stream(arr).sum();
        //如果不能等分3分
        if (sum % 3 != 0) {
            //过
            return false;
        }
        //目标值
        int target = sum / 3;
        //计算并返回
        return count(arr, target);
    }

    public static void main(String[] args) {
        System.out.println(new Code2().canThreePartsEqualSum(new int[]{0, 0, 0, 0}));
    }

}
