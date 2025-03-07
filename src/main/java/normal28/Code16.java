package normal28;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2024-02-01
 * 面试题 16.16. 部分排序
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 * <p>
 * 示例：
 * <p>
 * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * 输出： [3,9]
 * 提示：
 * <p>
 * 0 <= len(array) <= 1000000
 */
public class Code16 {

    public int[] subSort(int[] array) {
        //判空
        if (array.length < 2) {
            //过
            return new int[]{-1, -1};
        }
        //栈
        Stack<Integer> stack = new Stack<>();
        //左右区间
        int left = -1;
        int right = -1;
        //默认
        int max = array[0];
        //循环
        for (int i = 1; i < array.length; i++) {
            //当前
            int num = array[i];
            //如果是有序的
            if (max <= num) {
                //记录坐标
                stack.push(i);
                //刷新最大值
                max = num;
                //本轮过
                continue;
            }
            //先更新右边距
            right = i;
            //递归,如果前面有 and 比当前的还大
            while (stack.isEmpty() == false && array[stack.peek()] > num) {
                //删除之
                stack.pop();
            }
            //如果空
            if (stack.isEmpty()) {
                //左边距=0
                left = 0;
            } else {
                //当前左边距
                int thisLeft = stack.peek() + 1;
                //刷新左边距
                left = left == -1 ? thisLeft : Math.min(thisLeft, left);
            }
        }
        //返回
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        for (int i : new Code16().subSort(new int[]{5, 3, 1, 7, 9})) {
            System.out.println(i);
        }
    }
}
