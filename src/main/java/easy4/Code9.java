package easy4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2020-12-11
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 * <p>
 * 输入: n = 10, m = 17
 * 输出: 2
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 */
public class Code9 {

    public static int lastRemaining(int n, int m) {
        //排队
        List<Integer> nums = new ArrayList<>();
        //计数
        int x = 0;
        //循环
        while (x < n) {
            //加入
            nums.add(x++);
        }
        //长度
        int size = nums.size();
        //位置
        int p = 0;
        //循环
        while (nums.size() > 1) {
            //获取m并获取位置
            int mp = m + p;
            //循环
            while (size < mp) {
                //减去
                mp -= size;
            }
            //计算删除位置
            int thisP = mp - 1;
            //删除
            nums.remove(thisP);
            //记录
            p = thisP;
            //重置
            size = nums.size();
        }
        //返回
        return nums.get(0);
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(10, 17));
    }
}
