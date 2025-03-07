package easy9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 安永亮
 * @Date 2021-06-21
 * @Description LCS 02. 完成一半题目
 * 有 N 位扣友参加了微软与力扣举办了「以扣会友」线下活动。主办方提供了 2*N 道题目，整型数组 questions 中每个数字对应了每道题目所涉及的知识点类型。
 * 若每位扣友选择不同的一题，请返回被选的 N 道题目至少包含多少种知识点类型。
 * <p>
 * 示例 1：
 * <p>
 * 输入：questions = [2,1,6,2]
 * <p>
 * 输出：1
 * <p>
 * 解释：有 2 位扣友在 4 道题目中选择 2 题。
 * 可选择完成知识点类型为 2 的题目时，此时仅一种知识点类型
 * 因此至少包含 1 种知识点类型。
 * <p>
 * 示例 2：
 * <p>
 * 输入：questions = [1,5,1,3,4,5,2,5,3,3,8,6]
 * <p>
 * 输出：2
 * <p>
 * 解释：有 6 位扣友在 12 道题目中选择题目，需要选择 6 题。
 * 选择完成知识点类型为 3、5 的题目，因此至少包含 2 种知识点类型。
 * <p>
 * 提示：
 * <p>
 * questions.length == 2*n
 * 2 <= questions.length <= 10^5
 * 1 <= questions[i] <= 1000
 */
public class Code9 {

    public int halfQuestions(int[] questions) {
        //缓存
        Map<Integer, Integer> map = new HashMap<>();
        //循环
        for (int question : questions) {
            //次数
            int size;
            //如果存在
            if (map.containsKey(question)) {
                //获取并+1
                size = map.get(question) + 1;
            } else {
                //初始化
                size = 1;
            }
            //记录
            map.put(question, size);
        }
        //组
        int[] arr = new int[map.size()];
        //指针
        int p = 0;
        //循环
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            //记录
            arr[p++] = integerIntegerEntry.getValue();
        }
        //排个序
        Arrays.sort(arr);
        //有多少人
        int n = questions.length / 2;
        //结果初始化
        int result = 0;
        //指针2
        int p2 = arr.length - 1;
        //开始循环
        while (n > 0) {
            //计算
            n -= arr[p2--];
            //多一种
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().halfQuestions(new int[]{1, 5, 1, 3, 4, 5, 2, 5, 3, 3, 8, 6}));
    }

}
