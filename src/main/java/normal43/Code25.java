package normal43;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-06-14
 * 1202. 交换字符串中的元素
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 * <p>
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 * <p>
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 * 示例 2：
 * <p>
 * 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * 输出："abcd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[0] 和 s[2], s = "acbd"
 * 交换 s[1] 和 s[2], s = "abcd"
 * 示例 3：
 * <p>
 * 输入：s = "cba", pairs = [[0,1],[1,2]]
 * 输出："abc"
 * 解释：
 * 交换 s[0] 和 s[1], s = "bca"
 * 交换 s[1] 和 s[2], s = "bac"
 * 交换 s[0] 和 s[1], s = "abc"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s 中只含有小写英文字母
 */
public class Code25 {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        /**
         * 并查集分组
         */

        //并查集
        int[] arr = new int[s.length()];
        //循环
        for (int i = 0; i < arr.length; i++) {
            //初始化分组
            arr[i] = i;
        }
        //循环
        for (List<Integer> pair : pairs) {
            //并查集合并分组
            findAndSet(arr, pair.get(0), pair.get(1));
        }

        /**
         * 根据分组,分字母,排序
         */

        //分组缓存
        List<Character>[] groupMap = new List[s.length()];
        //循环
        for (int i = 0; i < arr.length; i++) {
            //获取分组
            int group = arr[i];
            //如果不是顶级节点
            if (arr[group] != group) {
                //梳理到顶级节点
                findAndSet(arr, arr[i], i);
                //更新
                group = arr[i];
            }
            //初始化列表
            if (groupMap[group] == null) {
                //初始化
                groupMap[group] = new ArrayList<>();
            }
            //记录字符
            groupMap[group].add(s.charAt(i));
        }
        //循环每个分组列表
        for (List<Character> groupList : groupMap) {
            //判空
            if (groupList != null) {
                //排序
                groupList.sort((a, b) -> a - b);
            }
        }

        /**
         * 计算结果
         */

        //索引缓存数组
        int[] groupIndexArr = new int[s.length()];
        //结果
        StringBuilder str = new StringBuilder();
        //循环
        for (int i = 0; i < arr.length; i++) {
            //获取分组
            int group = arr[i];
            //获取分组对应字符列表
            List<Character> charList = groupMap[group];
            //获取最近的
            Character letter = charList.get(groupIndexArr[group]++);
            //组装本次
            str.append(letter);
        }

        //返回结果
        return str.toString();
    }

    //并查集,寻找并合并分组
    private int findAndSet(int[] arr, int num1, int num2) {
        //递归计算最终头节点
        int root = arr[num1] == num1 ? num1 : findAndSet(arr, arr[num1], num1);
        //如果右边的不同分组
        if (arr[num2] != num2) {
            //递归右边的,同化
            findAndSet(arr, root, arr[num2]);
        }
        //记录本次头结点结果
        arr[num2] = root;
        //返回
        return root;
    }

    public static void main(String[] args) {
        System.out.println(new Code25().smallestStringWithSwaps("fqtvkfkt", Arrays.asList(
                Arrays.asList(2, 4),
                Arrays.asList(5, 7),
                Arrays.asList(1, 0),
                Arrays.asList(0, 0),
                Arrays.asList(4, 7),
                Arrays.asList(0, 3),
                Arrays.asList(4, 1),
                Arrays.asList(1, 3)
        )));
    }

}
