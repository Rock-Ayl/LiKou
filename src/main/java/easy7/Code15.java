package easy7;

import java.util.*;

/**
 * Created By Rock-Ayl on 2021-03-11
 * 1710. 卡车上的最大单元数
 * 请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
 * <p>
 * numberOfBoxesi 是类型 i 的箱子的数量。
 * numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
 * 整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
 * <p>
 * 返回卡车可以装载 单元 的 最大 总数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
 * 输出：8
 * 解释：箱子的情况如下：
 * - 1 个第一类的箱子，里面含 3 个单元。
 * - 2 个第二类的箱子，每个里面含 2 个单元。
 * - 3 个第三类的箱子，每个里面含 1 个单元。
 * 可以选择第一类和第二类的所有箱子，以及第三类的一个箱子。
 * 单元总数 = (1 * 3) + (2 * 2) + (1 * 1) = 8
 * 示例 2：
 * <p>
 * 输入：boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
 * 输出：91
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= boxTypes.length <= 1000
 * 1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
 * 1 <= truckSize <= 106
 */
public class Code15 {

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        //缓存1
        Set<Integer> set = new HashSet<>();
        //缓存2
        Map<Integer, Integer> map = new HashMap<>();
        //循环
        for (int[] boxType : boxTypes) {
            //个数
            int num = boxType[0];
            //尺寸
            int size = boxType[1];
            //记录尺寸
            set.add(size);
            int x;
            //如果存在尺寸
            if (map.containsKey(size)) {
                //取出之前的叠加
                num += map.get(size);
            }
            //记录对应个数
            map.put(size, num);
        }
        //初始化
        int[] arr = new int[set.size()];
        //位置
        int p = 0;
        //循环
        for (Integer integer : set) {
            //记录
            arr[p++] = integer;
        }
        //排序
        Arrays.sort(arr);
        //当前结果
        int result = 0;
        //当前个数
        int sunNum = 0;
        //循环
        for (int i = arr.length - 1; i >= 0; i--) {
            //取出当前最大单元
            int x = arr[i];
            //如果存在
            if (map.containsKey(x)) {
                //取出个数
                int thisSize = map.get(x);
                //如果可以整取
                if (thisSize + sunNum < truckSize) {
                    //计算并记录
                    result += thisSize * x;
                    //记录个数
                    sunNum += thisSize;
                } else {
                    //计算最后的结果
                    result += (truckSize - sunNum) * x;
                    //结束
                    break;
                }
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maximumUnits(
                new int[][]{
                        new int[]{184, 129}, new int[]{120, 503}, new int[]{116, 562}, new int[]{226, 615},
                        new int[]{492, 75}, new int[]{687, 650}, new int[]{16, 135}, new int[]{398, 492},
                        new int[]{348, 614}, new int[]{246, 441}},
                5725
        ));
    }
}
