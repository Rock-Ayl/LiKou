package normal3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-04-24
 * 845. 数组中的最长山脉
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * <p>
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * <p>
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * <p>
 * 如果不含有 “山脉” 则返回 0。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 * <p>
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 */
public class Code2 {

    public  int longestMountain(int[] arr) {
        //如果不构成山脉
        if (arr.length < 3) {
            //默认
            return 0;
        }
        //当前小山
        List<Integer> hills = new ArrayList<>();
        //当前坐标
        int p = 0;
        //中心坐标
        int center = 0;
        //上山的趋势
        boolean hillUp = true;
        //最长的山脉
        int maxLongSize = 0;
        //循环
        while (p < arr.length) {
            //当前位置,然后递增
            int space = arr[p++];
            //如果只是山的开始
            if (hills.size() == 0) {
                //直接组装
                hills.add(space);
            } else {
                //前一个位置
                int lastHill = hills.get(hills.size() - 1);
                //如果是上山的趋势
                if (hillUp) {
                    //如果开始矮了
                    if (space <= lastHill) {
                        //如果之前没有上山 或者相等,意味不构成山
                        if (hills.size() < 2 || space == lastHill) {
                            //清除之前的山
                            hills.clear();
                            //如果上一个可以作为他的开始
                            if (space > lastHill) {
                                //设立为第一个山
                                hills.add(lastHill);
                            }
                        } else {
                            //开始改为下山
                            hillUp = false;
                            //设立为中心坐标
                            center = hills.size() - 1;
                        }
                    }
                    //记录新山
                    hills.add(space);
                } else {
                    //如果开始高了
                    if (space >= lastHill) {
                        //如果记录刷新了
                        if (hills.size() > maxLongSize) {
                            //更新
                            maxLongSize = hills.size();
                        }
                        //清除之前的山
                        hills.clear();
                        //如果上一个可以作为他的开始
                        if (space > lastHill) {
                            //设立为第一个山
                            hills.add(lastHill);
                        }
                        //开始改为上山
                        hillUp = true;
                    }
                    //记录新山
                    hills.add(space);
                }
            }
        }
        //如果现在还能够组成个山,并且刷新了记录
        if (hillUp == false && hills.size() != center && hills.size() > maxLongSize) {
            //更新
            maxLongSize = hills.size();
        }
        //返回默认
        return maxLongSize;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().longestMountain(new int[]{8, 3, 7, 3, 4, 10, 1, 1, 2, 8}));
    }
}
