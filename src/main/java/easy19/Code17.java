package easy19;

import java.util.*;

/**
 * @Author ayl
 * @Date 2022-06-02
 * 2231. 按奇偶性交换后的最大数字
 * 给你一个正整数 num 。你可以交换 num 中 奇偶性 相同的任意两位数字（即，都是奇数或者偶数）。
 * <p>
 * 返回交换 任意 次之后 num 的 最大 可能值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 1234
 * 输出：3412
 * 解释：交换数字 3 和数字 1 ，结果得到 3214 。
 * 交换数字 2 和数字 4 ，结果得到 3412 。
 * 注意，可能存在其他交换序列，但是可以证明 3412 是最大可能值。
 * 注意，不能交换数字 4 和数字 1 ，因为它们奇偶性不同。
 * 示例 2：
 * <p>
 * 输入：num = 65875
 * 输出：87655
 * 解释：交换数字 8 和数字 6 ，结果得到 85675 。
 * 交换数字 5 和数字 7 ，结果得到 87655 。
 * 注意，可能存在其他交换序列，但是可以证明 87655 是最大可能值。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 109
 */
public class Code17 {

    public int largestInteger(int num) {
        //转化为str
        String str = String.valueOf(num);
        //转化为数组
        char[] arr = str.toCharArray();
        //单双记录数组
        int[] singleArr = new int[arr.length + 1];
        //单双
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        //循环
        for (int i = 0; i < arr.length; i++) {
            //当前
            int space = arr[i] - '0';
            //如果是偶数
            if (space % 2 == 0) {
                //组装
                two.add(space);
            } else {
                //组装
                one.add(space);
                //记录为单
                singleArr[i] = 1;
            }
        }
        //排序
        Collections.sort(one, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Collections.sort(two, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        //结果
        int result = 0;
        //迭代器
        Iterator<Integer> oneIter = one.iterator();
        Iterator<Integer> twoIter = two.iterator();
        //循环
        for (int i = 0; i < arr.length; i++) {
            //如果是单
            if (singleArr[i] == 1) {
                //拿一个
                result = result * 10 + oneIter.next();
            } else {
                //拿一个
                result = result * 10 + twoIter.next();
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().largestInteger(65875));
    }

}
