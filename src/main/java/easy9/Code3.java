package easy9;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 安永亮
 * @Date 2021-06-15
 * @Description 728. 自除数
 * 自除数 是指可以被它包含的每一位数除尽的数。
 * <p>
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * <p>
 * 还有，自除数不允许包含 0 。
 * <p>
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 注意：
 * <p>
 * 每个输入参数的边界满足 1 <= left <= right <= 10000。
 */
public class Code3 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        //结果
        List<Integer> list = new ArrayList<>();
        //从left开始
        int p = left;
        next:
        //循环
        while (p <= right) {
            //循环
            for (char c : (p + "").toCharArray()) {
                //数字
                int num = c - '0';
                //如果不是0 or 如果任一不符合
                if (num == 0 || p % num != 0) {
                    //下一个
                    p++;
                    //过
                    continue next;
                }
            }
            //记录符合的
            list.add(p);
            //下一个
            p++;
        }
        //返回
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().selfDividingNumbers(1, 22));
    }

}
