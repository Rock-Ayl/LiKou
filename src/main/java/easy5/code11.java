package easy5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-01-11
 * 面试题 16.11. 跳水板
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * <p>
 * 返回的长度需要从小到大排列。
 * <p>
 * 示例 1
 * <p>
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： [3,4,5,6]
 * 解释：
 * 可以使用 3 次 shorter，得到结果 3；使用 2 次 shorter 和 1 次 longer，得到结果 4 。以此类推，得到最终结果。
 * 提示：
 * <p>
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 */
public class code11 {

    public static int[] divingBoard(int shorter, int longer, int k) {
        //判空
        if (k == 0) {
            //缺省
            return new int[]{};
        }
        //结果
        List<Integer> list = new ArrayList<>();
        //最小
        int min = shorter * k;
        //最大
        int max = longer * k;
        //从最小开始轮
        int thisNum = min;
        //差
        int dif = longer - shorter;
        //如果不存在长短
        if (dif == 0) {
            //随意一个
            dif = longer;
        }
        //如果没有到最大值
        while (thisNum <= max) {
            //记录
            list.add(thisNum);
            //叠加差值
            thisNum += dif;
        }
        //返回
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        for (int i : divingBoard(1, 2, 3)) {
            System.out.println(i);
        }
    }
}
