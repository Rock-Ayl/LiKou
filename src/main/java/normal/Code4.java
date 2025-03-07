package normal;

/**
 * Created By Rock-Ayl on 2020-11-18
 * 面试题 16.01. 交换数字
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 * <p>
 * 示例：
 * <p>
 * 输入: numbers = [1,2]
 * 输出: [2,1]
 * 提示：
 * <p>
 * numbers.length == 2
 * 通过次数14,413提交次数17,314
 */
public class Code4 {

    public static int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] + numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] - numbers[1];
        return numbers;
    }

    public static void main(String[] args) {
        for (int i : swapNumbers(new int[]{3, 7})) {
            System.out.println(i);
        }
    }
}
