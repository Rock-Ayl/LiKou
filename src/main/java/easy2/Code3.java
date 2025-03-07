package easy2;

/**
 * Created By Rock-Ayl on 2020-09-21
 * 1304. 和为零的N个唯一整数
 * 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：[-7,-1,1,3,4]
 * 解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：[-1,0,1]
 * 示例 3：
 * <p>
 * 输入：n = 1
 * 输出：[0]
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 */
public class Code3 {

    public static int[] sumZero(int n) {
        //是否为基数
        boolean isCardinality;
        //判断是基数还是偶数
        if (n % 2 != 0) {
            //基数
            isCardinality = true;
        } else {
            //偶数
            isCardinality = false;
        }
        //初始化
        int[] arr = new int[n];
        //初始化左右位置、对应的num
        int l, r, lN, rN;
        //基础处理逻辑
        if (isCardinality) {
            //最中间的位置
            int z = n / 2;
            //初始化该位置为0
            arr[z] = 0;
            //初始化位置、num
            l = z;
            r = z;
            lN = 1;
            rN = -1;
        }
        //偶数处理逻辑
        else {
            //初始化位置、num
            l = (n / 2) - 1;
            r = n / 2;
            lN = 1;
            rN = -1;
        }
        //循环
        while (l < (n - 1)) {
            //叠加
            l++;
            r--;
            //赋值
            arr[l] = lN;
            arr[r] = rN;
            //叠加
            lN++;
            rN--;
        }
        //返回
        return arr;
    }

    public static void main(String[] args) {
        for (int i : sumZero(10)) {
            System.out.println(i);
        }
    }
}
