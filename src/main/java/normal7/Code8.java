package normal7;

/**
 * @Author ayl
 * @Date 2021-09-06
 * 1395. 统计作战单位数
 * n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
 * <p>
 * 每 3 个士兵可以组成一个作战单位，分组规则如下：
 * <p>
 * 从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
 * 作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中  0 <= i < j < k < n
 * 请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：rating = [2,5,3,4,1]
 * 输出：3
 * 解释：我们可以组建三个作战单位 (2,3,4)、(5,4,1)、(5,3,1) 。
 * 示例 2：
 * <p>
 * 输入：rating = [2,1,3]
 * 输出：0
 * 解释：根据题目条件，我们无法组建作战单位。
 * 示例 3：
 * <p>
 * 输入：rating = [1,2,3,4]
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == rating.length
 * 3 <= n <= 1000
 * 1 <= rating[i] <= 10^5
 * rating 中的元素都是唯一的
 */
public class Code8 {

    public int numTeams(int[] rating) {
        //次数
        int size = 0;
        //循环1
        for (int i = 0; i < rating.length; i++) {
            //当前
            int a = rating[i];
            //循环2
            for (int j = i; j < rating.length; j++) {
                //当前
                int b = rating[j];
                //如果相同
                if (a == b) {
                    //过
                    continue;
                }
                //排序
                boolean sort;
                //排序
                if (a > b) {
                    //倒叙
                    sort = true;
                } else {
                    //正序
                    sort = false;
                }
                for (int k = j; k < rating.length; k++) {
                    //获取数
                    int c = rating[k];
                    //如果是倒叙
                    if (sort) {
                        //如果是
                        if (b > c) {
                            //记录
                            size++;
                        }
                    } else {
                        //如果是
                        if (b < c) {
                            //记录
                            size++;
                        }
                    }
                }
            }
        }
        //返回
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().numTeams(new int[]{2, 5, 3, 4, 1}));
    }

}
