package easy22;

/**
 * @Author ayl
 * @Date 2022-09-04
 * 1925. 统计平方和三元组的数目
 * 一个 平方和三元组 (a,b,c) 指的是满足 a2 + b2 = c2 的 整数 三元组 a，b 和 c 。
 * <p>
 * 给你一个整数 n ，请你返回满足 1 <= a, b, c <= n 的 平方和三元组 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：2
 * 解释：平方和三元组为 (3,4,5) 和 (4,3,5) 。
 * 示例 2：
 * <p>
 * 输入：n = 10
 * 输出：4
 * 解释：平方和三元组为 (3,4,5)，(4,3,5)，(6,8,10) 和 (8,6,10) 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 250
 */
public class Code9 {

    public int countTriples(int n) {
        //第一个位置
        int firstP = n - 1;
        //结果
        int count = 0;
        //循环1
        for (int i = 1; i < firstP; i++) {
            //第一个
            int first = i * i;
            //循环2
            for (int j = i + 1; j < n; j++) {
                //和
                int sum = first + j * j;
                //循环3
                for (int k = j + 1; k <= n; k++) {
                    //当前
                    int num = k * k;
                    //如果是目标
                    if (num == sum) {
                        //结果+2
                        count += 2;
                        //结束
                        break;
                    } else if (num > sum) {
                        //结束本轮
                        break;
                    }
                }
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().countTriples(5));
    }

}
