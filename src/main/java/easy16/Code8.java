package easy16;

import java.util.*;

/**
 * @Author ayl
 * @Date 2021-12-10
 * 2094. 找出 3 位偶数
 * 给你一个整数数组 digits ，其中每个元素是一个数字（0 - 9）。数组中可能存在重复元素。
 * <p>
 * 你需要找出 所有 满足下述条件且 互不相同 的整数：
 * <p>
 * 该整数由 digits 中的三个元素按 任意 顺序 依次连接 组成。
 * 该整数不含 前导零
 * 该整数是一个 偶数
 * 例如，给定的 digits 是 [1, 2, 3] ，整数 132 和 312 满足上面列出的全部条件。
 * <p>
 * 将找出的所有互不相同的整数按 递增顺序 排列，并以数组形式返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [2,1,3,0]
 * 输出：[102,120,130,132,210,230,302,310,312,320]
 * 解释：
 * 所有满足题目条件的整数都在输出数组中列出。
 * 注意，答案数组中不含有 奇数 或带 前导零 的整数。
 * 示例 2：
 * <p>
 * 输入：digits = [2,2,8,8,2]
 * 输出：[222,228,282,288,822,828,882]
 * 解释：
 * 同样的数字（0 - 9）在构造整数时可以重复多次，重复次数最多与其在 digits 中出现的次数一样。
 * 在这个例子中，数字 8 在构造 288、828 和 882 时都重复了两次。
 * 示例 3：
 * <p>
 * 输入：digits = [3,7,5]
 * 输出：[]
 * 解释：
 * 使用给定的 digits 无法构造偶数。
 * 示例 4：
 * <p>
 * 输入：digits = [0,2,0,0]
 * 输出：[200]
 * 解释：
 * 唯一一个不含 前导零 且满足全部条件的整数是 200 。
 * 示例 5：
 * <p>
 * 输入：digits = [0,0,0]
 * 输出：[]
 * 解释：
 * 构造的所有整数都会有 前导零 。因此，不存在满足题目条件的整数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public class Code8 {

    //结果set
    Set<Integer> setResult = new HashSet<>();

    //中间
    public void mid(List<Integer> list, int p) {
        //循环
        for (int i = 0; i < list.size(); i++) {
            //当前
            int num = list.get(i);
            //删除
            list.remove(i);
            //记录
            this.setResult.add(p + num * 10);
            //回溯
            list.add(i, num);
        }
    }

    //第一个
    public void first(List<Integer> list, int p) {
        //循环
        for (int i = 0; i < list.size(); i++) {
            //当前
            int num = list.get(i);
            //如果不是0,满足第一个
            if (num != 0) {
                //删除
                list.remove(i);
                //计算下一步
                mid(list, p + num * 100);
                //回溯
                list.add(i, num);
            }
        }
    }

    //缓存
    Set<Integer> setLast = new HashSet<>();

    //最后
    public void last(List<Integer> list) {
        //循环
        for (int i = 0; i < list.size(); i++) {
            //当前
            int num = list.get(i);
            //如果是偶数,满足最后一个条件
            if (num % 2 == 0) {
                //如果走过了
                if (setLast.contains(num)) {
                    //过
                    continue;
                }
                //删除
                list.remove(i);
                //计算下一步
                first(list, num);
                //回溯
                list.add(i, num);
                //记录缓存
                setLast.add(num);
            }
        }
    }

    public int[] findEvenNumbers(int[] digits) {
        //列表
        List<Integer> list = new ArrayList<>();
        //循环
        for (int digit : digits) {
            //组装
            list.add(digit);
        }
        //开始从最后计算
        last(list);
        //结果
        int[] arrResult = new int[setResult.size()];
        //指针
        int p = 0;
        //循环
        for (Integer integer : setResult) {
            //组装
            arrResult[p++] = integer;
        }
        //排序
        Arrays.sort(arrResult);
        //返回
        return arrResult;
    }

    public static void main(String[] args) {
        for (int evenNumber : new Code8().findEvenNumbers(new int[]{2, 1, 3, 0})) {
            System.out.println(evenNumber);
        }
    }

}
