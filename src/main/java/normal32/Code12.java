package normal32;

/**
 * @Author ayl
 * @Date 2024-06-04
 * LCP 08. 剧情触发时间
 * 中等
 * 相关标签
 * 相关企业
 * 在战略游戏中，玩家往往需要发展自己的势力来触发各种新的剧情。一个势力的主要属性有三种，分别是文明等级（C），资源储备（R）以及人口数量（H）。在游戏开始时（第 0 天），三种属性的值均为 0。
 * <p>
 * 随着游戏进程的进行，每一天玩家的三种属性都会对应增加，我们用一个二维数组 increase 来表示每天的增加情况。这个二维数组的每个元素是一个长度为 3 的一维数组，例如 [[1,2,1],[3,4,2]] 表示第一天三种属性分别增加 1,2,1 而第二天分别增加 3,4,2。
 * <p>
 * 所有剧情的触发条件也用一个二维数组 requirements 表示。这个二维数组的每个元素是一个长度为 3 的一维数组，对于某个剧情的触发条件 c[i], r[i], h[i]，如果当前 C >= c[i] 且 R >= r[i] 且 H >= h[i] ，则剧情会被触发。
 * <p>
 * 根据所给信息，请计算每个剧情的触发时间，并以一个数组返回。如果某个剧情不会被触发，则该剧情对应的触发时间为 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入： increase = [[2,8,4],[2,5,0],[10,9,8]] requirements = [[2,11,3],[15,10,7],[9,17,12],[8,1,14]]
 * <p>
 * 输出: [2,-1,3,-1]
 * <p>
 * 解释：
 * <p>
 * 初始时，C = 0，R = 0，H = 0
 * <p>
 * 第 1 天，C = 2，R = 8，H = 4
 * <p>
 * 第 2 天，C = 4，R = 13，H = 4，此时触发剧情 0
 * <p>
 * 第 3 天，C = 14，R = 22，H = 12，此时触发剧情 2
 * <p>
 * 剧情 1 和 3 无法触发。
 * <p>
 * 示例 2：
 * <p>
 * 输入： increase = [[0,4,5],[4,8,8],[8,6,1],[10,10,0]] requirements = [[12,11,16],[20,2,6],[9,2,6],[10,18,3],[8,14,9]]
 * <p>
 * 输出: [-1,4,3,3,3]
 * <p>
 * 示例 3：
 * <p>
 * 输入： increase = [[1,1,1]] requirements = [[0,0,0]]
 * <p>
 * 输出: [0]
 * <p>
 * 限制：
 * <p>
 * 1 <= increase.length <= 10000
 * 1 <= requirements.length <= 100000
 * 0 <= increase[i] <= 10
 * 0 <= requirements[i] <= 100000
 */
public class Code12 {

    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        //三种资源的数组
        int[] cArr = new int[increase.length + 1];
        int[] rArr = new int[increase.length + 1];
        int[] hArr = new int[increase.length + 1];
        //循环
        for (int i = 0; i < increase.length; i++) {
            //时间
            int day = i + 1;
            //叠加
            cArr[day] = increase[i][0] + cArr[i];
            rArr[day] = increase[i][1] + rArr[i];
            hArr[day] = increase[i][2] + hArr[i];
        }
        //初始化结果
        int[] result = new int[requirements.length];
        //循环所有目标
        for (int i = 0; i < requirements.length; i++) {
            //当前剧情触发数组
            int[] requirementArr = requirements[i];
            //尝试获取第一个
            int first = find(cArr, requirementArr[0]);
            //如果不可能触发
            if (first == -1) {
                //记录
                result[i] = -1;
                //本轮过
                continue;
            }
            //尝试获取第二个
            int second = find(rArr, requirementArr[1]);
            //如果不可能触发
            if (second == -1) {
                //记录
                result[i] = -1;
                //本轮过
                continue;
            }
            //尝试获取第三个
            int third = find(hArr, requirementArr[2]);
            //如果不可能触发
            if (third == -1) {
                //记录
                result[i] = -1;
                //本轮过
                continue;
            }
            //最小的侍卫可能
            result[i] = Math.max(Math.max(first, second), third);
        }
        //返回
        return result;
    }

    //寻找最近的目标值索引,如果不存在,返回-1
    private int find(int[] arr, int number) {
        //如果数字太大
        if (arr[arr.length - 1] < number) {
            //过
            return -1;
        }
        //如果是边界
        if (arr[0] >= number) {
            //返回
            return 0;
        }
        //递归实现
        return find(arr, number, 0, arr.length - 1);
    }

    //递归寻找最近的目标值索引
    private int find(int[] arr, int number, int left, int right) {
        //如果到头了
        if (left + 1 == right) {
            //如果是左边
            if (arr[left] >= number) {
                //如果前面的满足
                while (left > 0 && arr[left - 1] >= number) {
                    //继续走
                    --left;
                }
                //返回
                return left;
            } else {
                //返回
                return right;
            }
        }
        //计算中间索引
        int mid = (right - left) / 2 + left;
        //获取中间数字
        int midNumber = arr[mid];
        //判断方向
        if (midNumber > number) {
            //递归左边
            return find(arr, number, left, mid);
        } else {
            //递归右边
            return find(arr, number, mid, right);
        }
    }

    public static void main(String[] args) {
        int[] result = new Code12().getTriggerTime(new int[][]{
                new int[]{7, 4, 10},
                new int[]{0, 7, 3},
                new int[]{1, 6, 4},
                new int[]{7, 8, 3},
                new int[]{6, 9, 6},
                new int[]{10, 5, 10},
                new int[]{0, 9, 9},
                new int[]{9, 9, 3},
                new int[]{6, 4, 3},
                new int[]{0, 10, 3},
                new int[]{2, 4, 4},
                new int[]{2, 5, 0},
                new int[]{6, 1, 9},
                new int[]{5, 6, 7},
                new int[]{1, 5, 10},
                new int[]{5, 7, 8},
                new int[]{4, 2, 0}
        }, new int[][]{
                new int[]{46, 31, 92}
        });
        System.out.println();
    }

}
