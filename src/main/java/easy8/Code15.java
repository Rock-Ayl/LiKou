package easy8;

/**
 * @Author 安永亮
 * @Date 2021-06-11
 * @Description 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 通过次数462,873提交次数888,980
 */
public class Code15 {

    public int climbStairs(int n) {
        //判空
        if (n == 1) {
            //返回
            return 1;
        }
        //组
        int[] arr = new int[n];
        //初始化
        int p = 2;
        arr[0] = 1;
        arr[1] = 2;
        //开始循环
        while (p < n) {
            //计算
            arr[p] = arr[p - 1] + arr[p - 2];
            //
            p++;
        }
        //结束
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Code15().climbStairs(10));
    }

}
