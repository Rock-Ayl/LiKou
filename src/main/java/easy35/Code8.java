package easy35;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-12-10
 * <p>
 * LCR 180. 文件组合
 * 简单
 * 575
 * 相关企业
 * 待传输文件被切分成多个部分，按照原排列顺序，每部分文件编号均为一个 正整数（至少含有两个文件）。传输要求为：连续文件编号总和为接收方指定数字 target 的所有文件。请返回所有符合该要求的文件传输组合列表。
 * <p>
 * 注意，返回时需遵循以下规则：
 * <p>
 * 每种组合按照文件编号 升序 排列；
 * 不同组合按照第一个文件编号 升序 排列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 12
 * 输出：[[3, 4, 5]]
 * 解释：在上述示例中，存在一个连续正整数序列的和为 12，为 [3, 4, 5]。
 * 示例 2：
 * <p>
 * 输入：target = 18
 * 输出：[[3,4,5,6],[5,6,7]]
 * 解释：在上述示例中，存在两个连续正整数序列的和分别为 18，分别为 [3, 4, 5, 6] 和 [5, 6, 7]。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= target <= 10^5
 */
public class Code8 {

    //组装出结果
    private int[] setResult(int left, int right) {
        //初始化
        int[] arr = new int[right - left];
        //循环
        for (int i = left; i < right; i++) {
            //记录
            arr[i - left] = i;
        }
        //返回
        return arr;
    }

    public int[][] fileCombination(int target) {
        //初始化结果列表
        List<int[]> resultList = new ArrayList<>();
        //计算区间最大情况
        int rightMax = (target + 1) / 2;
        //左右区间
        int left = 1;
        int right = 1;
        //和
        int sum = 0;
        //如果理论上还有
        while (right <= rightMax) {
            //如果使用右边的
            if (sum + right <= target) {
                //加入队头
                sum += right++;
                //如果是结果
                if (sum == target) {
                    //记录结果
                    resultList.add(setResult(left, right));
                }
            } else {
                //减去队尾
                sum -= left++;
            }
        }
        //初始化结果
        int[][] resultArr = new int[resultList.size()][];
        //循环
        for (int i = 0; i < resultList.size(); i++) {
            //记录
            resultArr[i] = resultList.get(i);
        }
        //返回
        return resultArr;
    }

    public static void main(String[] args) {
        int[][] ints = new Code8().fileCombination(18);
        System.out.println();
    }

}
