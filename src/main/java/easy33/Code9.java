package easy33;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-09-11
 * 2848. 与车相交的点
 * 提示
 * 简单
 * 10
 * 相关企业
 * 给你一个下标从 0 开始的二维整数数组 nums 表示汽车停放在数轴上的坐标。对于任意下标 i，nums[i] = [starti, endi] ，其中 starti 是第 i 辆车的起点，endi 是第 i 辆车的终点。
 * <p>
 * 返回数轴上被车 任意部分 覆盖的整数点的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [[3,6],[1,5],[4,7]]
 * 输出：7
 * 解释：从 1 到 7 的所有点都至少与一辆车相交，因此答案为 7 。
 * 示例 2：
 * <p>
 * 输入：nums = [[1,3],[5,8]]
 * 输出：7
 * 解释：1、2、3、5、6、7、8 共计 7 个点满足至少与一辆车相交，因此答案为 7 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * nums[i].length == 2
 * 1 <= starti <= endi <= 100
 */
public class Code9 {

    public int numberOfPoints(List<List<Integer>> nums) {
        //排序
        nums.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                //如果第一个数字相同
                if (o1.get(0).equals(o2.get(0))) {
                    //用第二个数排序
                    return o1.get(1) - o2.get(1);
                } else {
                    //用第一个数排序
                    return o1.get(0) - o2.get(0);
                }
            }
        });
        //结果
        int sum = 0;
        //上一个列表,默认第一个
        List<Integer> lastList = nums.get(0);
        //循环
        for (int i = 1; i < nums.size(); i++) {
            //获取当前列表
            List<Integer> thisList = nums.get(i);
            //如果与之前的列表相交
            if (lastList.get(1) >= thisList.get(0)) {
                //二者合并
                lastList.set(1, Math.max(lastList.get(1), thisList.get(1)));
            } else {
                //记录断层的结果
                sum += lastList.get(1) - lastList.get(0) + 1;
                //替换为新列表
                lastList = thisList;
            }
        }
        //清算最后的列表
        sum += lastList.get(1) - lastList.get(0) + 1;
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().numberOfPoints(Arrays.asList(
                Arrays.asList(3, 6),
                Arrays.asList(1, 5),
                Arrays.asList(4, 7)
        )));
    }

}
