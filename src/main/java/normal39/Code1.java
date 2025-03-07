package normal39;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-01-06
 * 1352. 最后 K 个数的乘积
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 请你实现一个「数字乘积类」ProductOfNumbers，要求支持下述两种方法：
 * <p>
 * 1. add(int num)
 * <p>
 * 将数字 num 添加到当前数字列表的最后面。
 * 2. getProduct(int k)
 * <p>
 * 返回当前数字列表中，最后 k 个数字的乘积。
 * 你可以假设当前列表中始终 至少 包含 k 个数字。
 * 题目数据保证：任何时候，任一连续数字序列的乘积都在 32-bit 整数范围内，不会溢出。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
 * [[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]
 * <p>
 * 输出：
 * [null,null,null,null,null,null,20,40,0,null,32]
 * <p>
 * 解释：
 * ProductOfNumbers productOfNumbers = new ProductOfNumbers();
 * productOfNumbers.add(3);        // [3]
 * productOfNumbers.add(0);        // [3,0]
 * productOfNumbers.add(2);        // [3,0,2]
 * productOfNumbers.add(5);        // [3,0,2,5]
 * productOfNumbers.add(4);        // [3,0,2,5,4]
 * productOfNumbers.getProduct(2); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
 * productOfNumbers.getProduct(3); // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
 * productOfNumbers.getProduct(4); // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
 * productOfNumbers.add(8);        // [3,0,2,5,4,8]
 * productOfNumbers.getProduct(2); // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32
 * <p>
 * <p>
 * 提示：
 * <p>
 * add 和 getProduct 两种操作加起来总共不会超过 40000 次。
 * 0 <= num <= 100
 * 1 <= k <= 40000
 */
public class Code1 {

    //前缀和列表
    private List<Integer> sumList = new ArrayList<>();

    public Code1() {

    }

    public void add(int num) {
        //如果是特殊情况
        if (num == 0) {
            //删除所有
            this.sumList.clear();
            //过
            return;
        }
        //如果没有内容
        if (this.sumList.isEmpty()) {
            //默认
            this.sumList.add(num);
            //过
            return;
        }
        //计算前缀乘积
        this.sumList.add(this.sumList.get(this.sumList.size() - 1) * num);
    }

    public int getProduct(int k) {
        //如果越界
        if (k > this.sumList.size()) {
            //过
            return 0;
        }
        //最后一个
        int end = this.sumList.get(this.sumList.size() - 1);
        //计算开始索引
        int startIndex = this.sumList.size() - k - 1;
        //计算并返回结果
        return startIndex < 0 ? end : (end / this.sumList.get(startIndex));
    }

    public static void main(String[] args) {

        Code1 code1 = new Code1();
        code1.add(3);
        code1.add(0);
        code1.add(2);
        code1.add(5);
        code1.add(4);
        System.out.println(code1.getProduct(2));
        System.out.println(code1.getProduct(3));
        System.out.println(code1.getProduct(4));
        code1.add(8);
        System.out.println(code1.getProduct(2));

    }

}
