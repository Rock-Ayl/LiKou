package normal4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-05-20
 * 386. 字典序排数
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 * <p>
 * 例如，
 * <p>
 * 给定 n =13，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 * <p>
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 */
public class Code6 {

    //结果
    List<Integer> result;
    //全局
    int max;

    public void next(int num) {
        //如果超过最大长度了
        if (num > max) {
            //结束
            return;
        }
        //记录结果
        result.add(num);
        //从0开始+
        int add = 0;
        //循环
        while (add < 10) {
            //下一级
            next(num * 10 + add++);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        //全局
        max = n;
        //初始化结果长度
        result = new ArrayList<>(max);
        //循环
        for (int i = 1; i < 10; i++) {
            //下一级
            next(i);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code6().lexicalOrder(3000));
    }
}
