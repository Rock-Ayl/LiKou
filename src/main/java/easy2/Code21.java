package easy2;

import java.util.Arrays;

/**
 * Created By Rock-Ayl on 2020-10-10
 * 1491. 去掉最低工资和最高工资后的工资平均值
 * 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
 * <p>
 * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：salary = [4000,3000,1000,2000]
 * 输出：2500.00000
 * 解释：最低工资和最高工资分别是 1000 和 4000 。
 * 去掉最低工资和最高工资以后的平均工资是 (2000+3000)/2= 2500
 * 示例 2：
 * <p>
 * 输入：salary = [1000,2000,3000]
 * 输出：2000.00000
 * 解释：最低工资和最高工资分别是 1000 和 3000 。
 * 去掉最低工资和最高工资以后的平均工资是 (2000)/1= 2000
 * 示例 3：
 * <p>
 * 输入：salary = [6000,5000,4000,3000,2000,1000]
 * 输出：3500.00000
 * 示例 4：
 * <p>
 * 输入：salary = [8000,9000,2000,3000,6000,1000]
 * 输出：4750.00000
 */
public class Code21 {

    public static double average(int[] salary) {
        //排序
        Arrays.sort(salary);
        //初始化和
        double sum = 0;
        //平均数
        int num = 0;
        //循环
        for (int i = 1; i < salary.length - 1; i++) {
            //累加
            sum = sum + salary[i];
            //+1
            num++;
        }
        //平均数
        return (sum / num);
    }

    public static void main(String[] args) {
        System.out.println(average(new int[]{4000, 3000, 1000, 2000}));
    }
}
