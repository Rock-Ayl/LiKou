package normal48;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-11-18
 * 3447. 将元素分配给有约束条件的组
 * 算术评级: 6
 * 第 436 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1731
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 groups，其中 groups[i] 表示第 i 组的大小。另给你一个整数数组 elements。
 * <p>
 * 请你根据以下规则为每个组分配 一个 元素：
 * <p>
 * 如果 groups[i] 能被 elements[j] 整除，则下标为 j 的元素可以分配给组 i。
 * 如果有多个元素满足条件，则分配 最小的下标 j 的元素。
 * 如果没有元素满足条件，则分配 -1 。
 * 返回一个整数数组 assigned，其中 assigned[i] 是分配给组 i 的元素的索引，若无合适的元素，则为 -1。
 * <p>
 * 注意：一个元素可以分配给多个组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： groups = [8,4,3,2,4], elements = [4,2]
 * <p>
 * 输出： [0,0,-1,1,0]
 * <p>
 * 解释：
 * <p>
 * elements[0] = 4 被分配给组 0、1 和 4。
 * elements[1] = 2 被分配给组 3。
 * 无法为组 2 分配任何元素，分配 -1 。
 * 示例 2：
 * <p>
 * 输入： groups = [2,3,5,7], elements = [5,3,3]
 * <p>
 * 输出： [-1,1,0,-1]
 * <p>
 * 解释：
 * <p>
 * elements[1] = 3 被分配给组 1。
 * elements[0] = 5 被分配给组 2。
 * 无法为组 0 和组 3 分配任何元素，分配 -1 。
 * 示例 3：
 * <p>
 * 输入： groups = [10,21,30,41], elements = [2,1]
 * <p>
 * 输出： [0,1,0,1]
 * <p>
 * 解释：
 * <p>
 * elements[0] = 2 被分配给所有偶数值的组，而 elements[1] = 1 被分配给所有奇数值的组。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= groups.length <= 105
 * 1 <= elements.length <= 105
 * 1 <= groups[i] <= 105
 * 1 <= elements[i] <= 105
 */
public class Code2 {

    public int[] assignElements(int[] groups, int[] elements) {
        //结果
        int[] result = new int[groups.length];
        //默认-1
        Arrays.fill(result, -1);
        //最大值
        int max = 0;
        //次数
        int count = 0;
        //缓存
        List<Integer>[] groupMap = new List[100001];
        //循环
        for (int i = 0; i < groups.length; i++) {
            //获取数字
            int group = groups[i];
            //刷新最大
            max = Math.max(max, group);
            //如果不存在
            if (groupMap[group] == null) {
                //初始化
                groupMap[group] = new ArrayList<>();
                //+1
                count++;
            }
            //记录索引
            groupMap[group].add(i);
        }
        //走过的缓存
        int[] walked = new int[100001];
        //循环
        for (int i = 0; i < elements.length; i++) {
            //如果没有了
            if (count == 0) {
                //跳出
                break;
            }
            //当前节点
            int element = elements[i];
            //如果走过了
            if (++walked[element] > 1) {
                //本轮过
                continue;
            }
            //叠加分片
            int part = element;
            //循环满足
            while (element <= max) {
                //如果本次满足
                if (groupMap[element] != null) {
                    //循环索引
                    for (Integer index : groupMap[element]) {
                        //记录
                        result[index] = i;
                    }
                    //不再需要处理
                    groupMap[element] = null;
                    //-1
                    count--;
                }
                //下一个
                element += part;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().assignElements(new int[]{8, 4, 3, 2, 4}, new int[]{4, 2}));
    }

}
