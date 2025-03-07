package easy7;

import java.util.HashSet;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2021-02-25
 * 575. 分糖果
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: candies = [1,1,2,2,3,3]
 * 输出: 3
 * 解析: 一共有三种种类的糖果，每一种都有两个。
 * 最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
 * 示例 2 :
 * <p>
 * 输入: candies = [1,1,2,3]
 * 输出: 2
 * 解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
 * 注意:
 * <p>
 * 数组的长度为[2, 10,000]，并且确定为偶数。
 * 数组中数字的大小在范围[-100,000, 100,000]内。
 */
public class Code1 {

    public static int distributeCandies(int[] candyType) {
        //缓存
        Set<Integer> set = new HashSet<>();
        //循环
        for (int i : candyType) {
            //记录
            set.add(i);
        }
        //糖果多少种
        int size = set.size();
        //如果大于总量一半了
        if (size > candyType.length / 2) {
            //最多这些
            return candyType.length / 2;
        } else {
            //返回
            return size;
        }
    }

    public static void main(String[] args) {
        System.out.println(distributeCandies(new int[]{1,1,2,3}));
    }

}
