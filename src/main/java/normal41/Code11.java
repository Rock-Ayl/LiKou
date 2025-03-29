package normal41;

/**
 * @Author ayl
 * @Date 2025-03-29
 * 949. 给定数字能组成的最大时间
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
 * <p>
 * 24 小时格式为 "HH:MM" ，其中 HH 在 00 到 23 之间，MM 在 00 到 59 之间。最小的 24 小时制时间是 00:00 ，而最大的是 23:59 。从 00:00 （午夜）开始算起，过得越久，时间越大。
 * <p>
 * 以长度为 5 的字符串，按 "HH:MM" 格式返回答案。如果不能确定有效时间，则返回空字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,4]
 * 输出："23:41"
 * 解释：有效的 24 小时制时间是 "12:34"，"12:43"，"13:24"，"13:42"，"14:23"，"14:32"，"21:34"，"21:43"，"23:14" 和 "23:41" 。这些时间中，"23:41" 是最大时间。
 * 示例 2：
 * <p>
 * 输入：arr = [5,5,5,5]
 * 输出：""
 * 解释：不存在有效的 24 小时制时间，因为 "55:55" 无效。
 * 示例 3：
 * <p>
 * 输入：arr = [0,0,0,0]
 * 输出："00:00"
 * 示例 4：
 * <p>
 * 输入：arr = [0,0,1,0]
 * 输出："10:00"
 * <p>
 * <p>
 * 提示：
 * <p>
 * arr.length == 4
 * 0 <= arr[i] <= 9
 */
public class Code11 {

    public String largestTimeFromDigits(int[] arr) {
        //最大
        int maxA = -1;
        int maxB = -1;
        int maxC = -1;
        int maxD = -1;
        //循环1
        for (int i = 0; i < arr.length; i++) {
            //循环2
            for (int j = 0; j < arr.length; j++) {
                //如果相同
                if (i == j) {
                    //本轮过
                    continue;
                }
                //循环3
                for (int k = 0; k < arr.length; k++) {
                    //如果相同
                    if (k == i || k == j) {
                        //本轮过
                        continue;
                    }
                    //循环4
                    for (int l = 0; l < arr.length; l++) {
                        //如果相同
                        if (l == i || l == j || l == k) {
                            //本轮过
                            continue;
                        }
                        //当前时间数字
                        int a = arr[i];
                        int b = arr[j];
                        int c = arr[k];
                        int d = arr[l];
                        //如果不是时间
                        if (check(a, b, c, d) == false) {
                            //本轮过
                            continue;
                        }
                        //如果没有最大值 or 对比更大
                        if (maxA == -1 || compareTo(maxA * 10 + maxB, maxC * 10 + maxD, a * 10 + b, c * 10 + d)) {
                            //覆盖最大值
                            maxA = a;
                            maxB = b;
                            maxC = c;
                            maxD = d;
                        }
                    }
                }
            }
        }
        //如果没有
        if (maxA == -1) {
            //过
            return "";
        }
        //返回
        return String.format("%s%s:%s%s", maxA, maxB, maxC, maxD);
    }

    //如果是时间
    private boolean check(int a, int b, int c, int d) {
        //如果超过23
        if (a * 10 + b > 23) {
            //过
            return false;
        }
        //如果超过60
        if (c * 10 + d > 59) {
            //过
            return false;
        }
        //默认是
        return true;
    }

    //对比
    private boolean compareTo(int maxLeft, int maxRight, int left, int right) {
        //如果小时更大
        if (left > maxLeft) {
            //更大
            return true;
        }
        //如果小时更小
        if (left < maxLeft) {
            //更小
            return false;
        }
        //如果分钟更大
        if (right > maxRight) {
            //更大
            return true;
        }
        //默认小
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().largestTimeFromDigits(new int[]{1, 2, 3, 4}));
    }

}
