package normal7;

import java.util.*;

/**
 * @Author ayl
 * @Date 2021-09-01
 * 565. 数组嵌套
 * 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
 * <p>
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: A = [5,4,0,3,1,6,2]
 * 输出: 4
 * 解释:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 * <p>
 * 其中一种最长的 S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 * <p>
 * <p>
 * 提示：
 * <p>
 * N是[1, 20,000]之间的整数。
 * A中不含有重复的元素。
 * A中的元素大小在[0, N-1]之间。
 */
public class Code3 {

    //全局
    int max = 0;
    int[] nums;
    //记录map
    Map<Integer, Integer> map;

    public void move(int p, LinkedList<Integer> list, Set<Integer> set) {
        //如果存在
        if (set.contains(p)) {
            //刷新最大长度
            max = Math.max(list.size(), max);
            //参数
            int time = 1;
            //循环
            while (list.size() > 0) {
                //记录下一个
                map.put(list.pop(), time++);
            }
            //结束
            return;
        }
        //如果之前走过了
        if (map.containsKey(p)) {
            //之后的
            int other = map.get(p);
            //刷新最大长度
            max = Math.max(list.size() + other, max);
            //参数
            int time = 1 + other;
            //循环
            while (list.size() > 0) {
                //记录下一个
                map.put(list.pop(), time++);
            }
            //结束
            return;
        }
        //记录走过了
        set.add(p);
        //下一步的位置
        int next = nums[p];
        //记录
        list.push(next);
        //下一步
        move(next, list, set);
    }

    public int arrayNesting(int[] nums) {
        //全局
        this.nums = nums;
        this.map = new HashMap<>(nums.length);
        //循环
        for (int i = 0; i < nums.length; i++) {
            //如果之前走过了
            if (this.map.containsKey(i)) {
                //过
                continue;
            }
            //不断下一步
            move(i, new LinkedList(), new HashSet<>());
        }
        //返回
        return this.max;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}));
    }
}
