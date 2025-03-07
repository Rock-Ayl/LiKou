package easy4;

/**
 * Created By Rock-Ayl on 2020-12-26
 */
public class Code21 {

    public static boolean isBadVersion(int version) {
        //如果是大于等于4
        if (version >= 4) {
            //是坏版本
            return true;
        }
        //缺省
        return false;
    }

    public static int firstBadVersion(int n) {
        //判空
        if (n <= 1) {
            //缺省
            return n;
        }
        //左边
        int x = 1;
        //右边
        int y = n;
        //当前位置
        int p = n / 2;
        //循环
        while (x < y) {
            //判断是否为坏的版本
            if (isBadVersion(p)) {
                //右边更新
                y = p;
            } else {
                //左边更新
                x = p;
            }
            //计算中间位置
            p = (y - x) / 2 + x;
            //如果已经到头了
            if (p == x || p == y) {
                //判断是否为坏版本
                if (isBadVersion(x)) {
                    //返回
                    return x;
                }
                //判断是否为坏版本
                if (isBadVersion(y)) {
                    //返回
                    return y;
                }
            }
        }
        //返回结果
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(10));
    }
}
