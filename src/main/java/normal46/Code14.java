package normal46;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-09-22
 * 3006. 找出数组中的美丽下标 I
 * 算术评级: 3
 * 第 380 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1480
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的字符串 s 、字符串 a 、字符串 b 和一个整数 k 。
 * <p>
 * 如果下标 i 满足以下条件，则认为它是一个 美丽下标：
 * <p>
 * 0 <= i <= s.length - a.length
 * s[i..(i + a.length - 1)] == a
 * 存在下标 j 使得：
 * 0 <= j <= s.length - b.length
 * s[j..(j + b.length - 1)] == b
 * |j - i| <= k
 * 以数组形式按 从小到大排序 返回美丽下标。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "isawsquirrelnearmysquirrelhouseohmy", a = "my", b = "squirrel", k = 15
 * 输出：[16,33]
 * 解释：存在 2 个美丽下标：[16,33]。
 * - 下标 16 是美丽下标，因为 s[16..17] == "my" ，且存在下标 4 ，满足 s[4..11] == "squirrel" 且 |16 - 4| <= 15 。
 * - 下标 33 是美丽下标，因为 s[33..34] == "my" ，且存在下标 18 ，满足 s[18..25] == "squirrel" 且 |33 - 18| <= 15 。
 * 因此返回 [16,33] 作为结果。
 * 示例 2：
 * <p>
 * 输入：s = "abcd", a = "a", b = "a", k = 4
 * 输出：[0]
 * 解释：存在 1 个美丽下标：[0]。
 * - 下标 0 是美丽下标，因为 s[0..0] == "a" ，且存在下标 0 ，满足 s[0..0] == "a" 且 |0 - 0| <= 4 。
 * 因此返回 [0] 作为结果。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= s.length <= 105
 * 1 <= a.length, b.length <= 10
 * s、a、和 b 只包含小写英文字母。
 */
public class Code14 {

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        //寻找索引
        List<Integer> aIndexList = findIndex(s, a);
        List<Integer> bIndexList = findIndex(s, b);
        //结果
        List<Integer> result = new ArrayList<>();
        //循环
        for (Integer aIndex : aIndexList) {
            //判断是否满足结果条件
            if (findNumber(bIndexList, 0, bIndexList.size() - 1, aIndex - k, aIndex + k)) {
                //记录
                result.add(aIndex);
            }
        }
        //返回
        return result;
    }

    //二分 寻找是否存在指定区间的数字
    private boolean findNumber(List<Integer> bIndexList, int start, int end, int targetStart, int targetEnd) {
        //如果越界
        if (start > end) {
            //过
            return false;
        }
        //如果只有一个
        if (start == end) {
            //返回
            return target(bIndexList.get(start), targetStart, targetEnd);
        }
        //如果没有距离
        if (start + 1 == end) {
            //返回
            return target(bIndexList.get(start), targetStart, targetEnd) ||
                    target(bIndexList.get(end), targetStart, targetEnd);
        }
        //计算中间节点
        int mid = (end - start) / 2 + start;
        //对应数字
        int midNumber = bIndexList.get(mid);
        //如果是
        if (target(midNumber, targetStart, targetEnd)) {
            //返回
            return true;
        }
        //如果更小
        if (midNumber < targetStart) {
            //右边继续
            return findNumber(bIndexList, mid + 1, end, targetStart, targetEnd);
        } else {
            //左边继续
            return findNumber(bIndexList, start, mid - 1, targetStart, targetEnd);
        }
    }

    //判断是否为目标
    private boolean target(int num, int targetStart, int targetEnd) {
        //判断
        return num >= targetStart && num <= targetEnd;
    }

    //寻找单词出现的节点
    private List<Integer> findIndex(String sentence, String word) {
        //目标hash
        int targetSum = 0;
        //循环
        for (char letter : word.toCharArray()) {
            //叠加hash
            targetSum += letter;
        }
        //初始化结果
        List<Integer> result = new ArrayList<>();
        //当前hash
        int hashSum = 0;
        //循环
        for (int i = 0; i < sentence.length(); i++) {
            //叠加hash
            hashSum += sentence.charAt(i);
            //如果有删减
            if (i - word.length() >= 0) {
                //删除hash
                hashSum -= sentence.charAt(i - word.length());
            }
            //如果一致
            if (i - word.length() >= -1 && hashSum == targetSum && equals(sentence, i, word) == true) {
                //记录
                result.add(i - word.length() + 1);
            }
        }
        //返回
        return result;
    }

    //判断是否一致
    private boolean equals(String sentence, int index, String word) {
        //单词索引
        int wordIndex = word.length() - 1;
        //循环
        while (wordIndex >= 0) {
            //如果不同
            if (word.charAt(wordIndex--) != sentence.charAt(index--)) {
                //过
                return false;
            }
        }
        //默认是
        return true;
    }

    public static void main(String[] args) {
        List<Integer> integers = new Code14().beautifulIndices("rinzbrrr", "nzb", "r", 2);
        System.out.println();
    }

}
