package easy23;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author ayl
 * @Date 2022-09-26
 * 6188. 按身高排序
 * 给你一个字符串数组 names ，和一个由 互不相同 的正整数组成的数组 heights 。两个数组的长度均为 n 。
 * <p>
 * 对于每个下标 i，names[i] 和 heights[i] 表示第 i 个人的名字和身高。
 * <p>
 * 请按身高 降序 顺序返回对应的名字数组 names 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：names = ["Mary","John","Emma"], heights = [180,165,170]
 * 输出：["Mary","Emma","John"]
 * 解释：Mary 最高，接着是 Emma 和 John 。
 * 示例 2：
 * <p>
 * 输入：names = ["Alice","Bob","Bob"], heights = [155,185,150]
 * 输出：["Bob","Alice","Bob"]
 * 解释：第一个 Bob 最高，然后是 Alice 和第二个 Bob 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == names.length == heights.length
 * 1 <= n <= 103
 * 1 <= names[i].length <= 20
 * 1 <= heights[i] <= 105
 * names[i] 由大小写英文字母组成
 * heights 中的所有值互不相同
 */
public class Code12 {

    public String[] sortPeople(String[] names, int[] heights) {
        //初始化位置数组
        Integer[] site = new Integer[names.length];
        //循环
        for (int i = 0; i < site.length; i++) {
            //初始化每个位置坐标
            site[i] = i;
        }
        //给位置们排序
        Arrays.sort(site, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //按照身高排序
                return heights[o2] - heights[o1];
            }
        });
        //初始化结果数组
        String[] result = new String[names.length];
        //循环
        for (int i = 0; i < site.length; i++) {
            //按照位置排序组装对应名字
            result[i] = names[site[i]];
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code12().sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170});
    }

}
