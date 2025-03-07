package normal;

/**
 * Created By Rock-Ayl on 2021-03-26
 * 365. 水壶问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * <p>
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * <p>
 * 你允许：
 * <p>
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 * <p>
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 * 通过次数29,380提交次数83,058
 */
public class Code20 {

    /**
     * 懒得优化了
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    public static boolean canMeasureWater(int x, int y, int z) {
        //如果太多了
        if (x + y < z) {
            //也不行
            return false;
        }
        //判0
        if (z == 0) {
            //可以
            return true;
        }
        //判0
        if (x == 0 || y == 0) {
            //如果另一个相同
            if (y == z || z == x) {
                //可以
                return true;
            } else {
                //不可以
                return false;
            }
        }
        //如果有1
        if (x == 1 || y == 1) {
            //绝对可以
            return true;
        }
        //如果条件相同
        if (x == y) {
            //如果结果也是倍数
            if (z % y == 0) {
                //可以
                return true;
            } else {
                //不可以
                return false;
            }
        }
        //如果是偶数,用2解决,如果不是,用1解决
        if (z % 2 == 0) {
            //最大最小
            int max = Math.max(x, y);
            int min = Math.min(x, y);
            //成
            int pro = max % min;
            //循环
            while (pro != 0) {
                max = min;
                min = pro;
                pro = max % min;
            }
            //如果最小公倍数大于2
            if (min > 2) {
                return false;
            }
            //默认可以
            return true;
        } else {
            //如果能整除
            if (x % y == 0 || y % x == 0) {
                //如果可以整除
                if (y % z == 0 || x % z == 0) {
                    //也算
                    return true;
                }
                //不可以
                return false;
            }
            //最大最小
            int max = Math.max(x, y);
            int min = Math.min(x, y);
            //成
            int pro = max % min;
            //循环
            while (pro != 0) {
                max = min;
                min = pro;
                pro = max % min;
            }
            //如果最小公倍数不为1
            if (min != 1) {
                return false;
            }
        }
        //可以
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canMeasureWater(23, 46, 12));
    }
}
