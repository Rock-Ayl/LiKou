package easy30;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2023-04-29
 * 703. 数据流中的第 K 大元素
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * <p>
 * 请实现 KthLargest 类：
 * <p>
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 */
public class Code14 {

    //初始化
    private List<Integer> list;
    //第K个
    private int k;
    //上一次目标
    private Integer target;

    public Code14(int k, int[] nums) {
        this.k = k;
        this.list = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
    }

    public int add(int val) {
        //如果比上一个小
        if (target != null && target >= val) {
            //直接返回即可
            return target;
        }
        //如果有值
        if (this.list.size() > 0) {
            //覆盖最小的
            this.list.set(0, val);
        } else {
            //组装
            this.list.add(val);
        }
        //排序
        Collections.sort(list);
        //目标
        int target = list.get(list.size() - k);
        //记录
        this.target = target;
        //返回
        return target;
    }

}
