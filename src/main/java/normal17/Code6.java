package normal17;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2022-11-10
 * 986. 区间列表的交集
 * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
 * <p>
 * 返回这 两个区间列表的交集 。
 * <p>
 * 形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。
 * <p>
 * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
 * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * 示例 2：
 * <p>
 * 输入：firstList = [[1,3],[5,9]], secondList = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：firstList = [], secondList = [[4,8],[10,12]]
 * 输出：[]
 * 示例 4：
 * <p>
 * 输入：firstList = [[1,7]], secondList = [[3,10]]
 * 输出：[[3,7]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= firstList.length, secondList.length <= 1000
 * firstList.length + secondList.length >= 1
 * 0 <= starti < endi <= 109
 * endi < starti+1
 * 0 <= startj < endj <= 109
 * endj < startj+1
 */
public class Code6 {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        //初始化结果列表
        List<int[]> list = new ArrayList<>();
        //双指针
        int p1 = 0;
        int p2 = 0;
        //如果有情况
        while (p1 < firstList.length && p2 < secondList.length) {
            //获取二者
            int[] first = firstList[p1];
            int[] second = secondList[p2];
            //如果完全不相交
            if (first[1] < second[0] || second[1] < first[0]) {
                //判断左右大
                if (first[1] > second[1]) {
                    //进位
                    p2++;
                } else {
                    //进位
                    p1++;
                }
                //本轮过
                continue;
            }
            //如果只相交一个数
            if (first[1] == second[0] || second[1] == first[0]) {
                //判断左右大
                if (first[1] > second[1]) {
                    //组装本次结果
                    list.add(new int[]{second[1], second[1]});
                    //进位
                    p2++;
                    //更换
                    first[0] = second[1];
                } else {
                    //组装本次结果
                    list.add(new int[]{first[1], first[1]});
                    //进位
                    p1++;
                    //更换
                    second[0] = first[1];
                }
                //本轮过
                continue;
            }
            //相交多个数,判断左右大
            if (first[1] > second[1]) {
                //组装本次结果
                list.add(new int[]{Math.max(first[0], second[0]), second[1]});
                //进位
                p2++;
                //更换
                first[0] = second[1];
            } else if (second[1] > first[1]) {
                //组装本次结果
                list.add(new int[]{Math.max(first[0], second[0]), first[1]});
                //进位
                p1++;
                //更换
                second[0] = first[1];
            } else {
                //组装本次结果
                list.add(new int[]{Math.max(second[0], first[0]), first[1]});
                //进位
                p1++;
                p2++;
            }
        }
        //初始化
        int[][] result = new int[list.size()][2];
        //循环
        for (int i = 0; i < result.length; i++) {
            //组装
            result[i] = list.get(i);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code6().intervalIntersection(new int[][]{
                new int[]{3, 5},
                new int[]{9, 20}
        }, new int[][]{
                new int[]{4, 5},
                new int[]{7, 10},
                new int[]{11, 12},
                new int[]{14, 15},
                new int[]{16, 20}
        });
    }

}
