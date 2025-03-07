package normal31;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2024-05-20
 * 1093. 大样本统计
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 我们对 0 到 255 之间的整数进行采样，并将结果存储在数组 count 中：count[k] 就是整数 k 在样本中出现的次数。
 * <p>
 * 计算以下统计数据:
 * <p>
 * minimum ：样本中的最小元素。
 * maximum ：样品中的最大元素。
 * mean ：样本的平均值，计算为所有元素的总和除以元素总数。
 * median ：
 * 如果样本的元素个数是奇数，那么一旦样本排序后，中位数 median 就是中间的元素。
 * 如果样本中有偶数个元素，那么中位数median 就是样本排序后中间两个元素的平均值。
 * mode ：样本中出现次数最多的数字。保众数是 唯一 的。
 * 以浮点数数组的形式返回样本的统计信息 [minimum, maximum, mean, median, mode] 。与真实答案误差在 10-5 内的答案都可以通过。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：count = [0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
 * 输出：[1.00000,3.00000,2.37500,2.50000,3.00000]
 * 解释：用count表示的样本为[1,2,2,2,3,3,3,3]。
 * 最小值和最大值分别为1和3。
 * 均值是(1+2+2+2+3+3+3+3) / 8 = 19 / 8 = 2.375。
 * 因为样本的大小是偶数，所以中位数是中间两个元素2和3的平均值，也就是2.5。
 * 众数为3，因为它在样本中出现的次数最多。
 * 示例 2：
 * <p>
 * 输入：count = [0,4,3,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
 * 输出：[1.00000,4.00000,2.18182,2.00000,1.00000]
 * 解释：用count表示的样本为[1,1,1,1,2,2,3,3,3,4,4]。
 * 最小值为1，最大值为4。
 * 平均数是(1+1+1+1+2+2+2+3+3+4+4)/ 11 = 24 / 11 = 2.18181818…(为了显示，输出显示了整数2.18182)。
 * 因为样本的大小是奇数，所以中值是中间元素2。
 * 众数为1，因为它在样本中出现的次数最多。
 * <p>
 * <p>
 * 提示：
 * <p>
 * count.length == 256
 * 0 <= count[i] <= 109
 * 1 <= sum(count) <= 109
 * count 的众数是 唯一 的
 */
public class Code20 {

    //二分找到目标值
    private double find(List<Integer> addList, List<Integer> addListNumList, int p) {
        //左右边界
        int left = 0;
        int right = addList.size() - 1;
        //循环
        while (true) {
            //如果缩小到极限了
            if (left + 1 >= right) {
                //如果左边是
                if (addList.get(left) >= p) {
                    //返回
                    return addListNumList.get(left);
                } else {
                    //返回
                    return addListNumList.get(right);
                }
            }
            //中间数字
            int mid = (right - left) / 2 + left;
            //如果是目标
            if (addList.get(mid) == p) {
                //返回
                return addListNumList.get(mid);
            }
            //如果是目标
            if (addList.get(mid) > p && addList.get(mid - 1) < p) {
                //返回
                return addListNumList.get(mid);
            }
            //判断大小,继续缩小范围
            if (addList.get(mid) > p) {
                //缩小范围
                right = mid;
            } else {
                //缩小范围
                left = mid;
            }
        }
    }

    //计算中位数
    private double countMedian(List<Integer> addList, List<Integer> addListNumList) {
        //获取总数量
        int allCount = addList.get(addList.size() - 1);
        //判断奇偶
        if (allCount % 2 == 0) {
            //找到2个值
            double one = find(addList, addListNumList, allCount / 2);
            double two = find(addList, addListNumList, allCount / 2 + 1);
            //计算并返回
            return (one + two) / 2D;
        } else {
            //找到目标并返回
            return find(addList, addListNumList, allCount / 2 + 1);
        }
    }

    public double[] sampleStats(int[] count) {
        //最小
        int minimum = -1;
        //最大
        int maximum = -1;
        //元素总和
        long allSum = 0;
        //单个元素最大的数量
        int maxCount = 0;
        //单个元素最大数量的数字
        int maxCountNumber = 0;
        //初始化累加数组,以及对应值
        List<Integer> addList = new ArrayList<>();
        List<Integer> addListNumList = new ArrayList<>();
        //循环
        for (int number = 0; number < count.length; number++) {
            //当前元素数量
            int thisCount = count[number];
            //如果没有
            if (thisCount == 0) {
                //本轮过
                continue;
            }
            //叠加累加值
            addList.add((addList.isEmpty() ? 0 : addList.get(addList.size() - 1)) + thisCount);
            addListNumList.add(number);
            //刷新最大值
            maximum = number;
            //如果不存在最小值
            if (minimum == -1) {
                //记录最小值
                minimum = number;
            }
            //叠加元素和
            allSum += ((long) number) * thisCount;
            //如果出现更大
            if (thisCount > maxCount) {
                //刷新单词元素最大情况
                maxCount = thisCount;
                maxCountNumber = number;
            }
        }
        //返回
        return new double[]{(double) minimum, (double) maximum, ((double) allSum) / addList.get(addList.size() - 1), countMedian(addList, addListNumList), (double) maxCountNumber};
    }

    public static void main(String[] args) {
        double[] result = new Code20().sampleStats(new int[]{0, 1, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        System.out.println();
    }

}
