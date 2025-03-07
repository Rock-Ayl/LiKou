package normal25;

/**
 * @Author ayl
 * @Date 2023-10-30
 * LCR 191. 按规则计算统计结果
 * 中等
 * 349
 * 相关企业
 * 为了深入了解这些生物群体的生态特征，你们进行了大量的实地观察和数据采集。数组 arrayA 记录了各个生物群体数量数据，其中 arrayA[i] 表示第 i 个生物群体的数量。请返回一个数组 arrayB，该数组为基于数组 arrayA 中的数据计算得出的结果，其中 arrayB[i] 表示将第 i 个生物群体的数量从总体中排除后的其他数量的乘积。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arrayA = [2, 4, 6, 8, 10]
 * 输出：[1920, 960, 640, 480, 384]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 所有元素乘积之和不会溢出 32 位整数
 * arrayA.length <= 100000
 */
public class Code14 {

    public int[] statisticalResult(int[] arrayA) {
        //求和
        int sum = 1;
        //0的数量
        int zeroCount = 0;
        //上一个0的坐标
        int lastZeroIndex = -1;
        //循环
        for (int i = 0; i < arrayA.length; i++) {
            //当前数字
            int num = arrayA[i];
            //如果是0
            if (num == 0) {
                //记录0的数量,如果太多了
                if (++zeroCount > 1) {
                    //跳出
                    break;
                }
                //刷新0坐标
                lastZeroIndex = i;
            } else {
                //计算乘积
                sum *= num;
            }
        }
        //初始化结果
        int[] arrayB = new int[arrayA.length];
        //如果0特别多
        if (zeroCount > 1) {
            //直接返回
            return arrayB;
        }
        //如果0只有一个
        if (zeroCount == 1) {
            //计算唯一的结果
            arrayB[lastZeroIndex] = sum;
            //直接返回
            return arrayB;
        }
        //循环
        for (int i = 0; i < arrayB.length; i++) {
            //正常计算并组装
            arrayB[i] = sum / arrayA[i];
        }
        //返回
        return arrayB;
    }

    public int[] star(int[] arrayA) {
        int len = arrayA.length;
        if (len == 0) return new int[0];
        int[] arrayB = new int[len];
        arrayB[0] = 1;
        int tmp = 1;
        for (int i = 1; i < len; i++) {
            arrayB[i] = arrayB[i - 1] * arrayA[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            tmp *= arrayA[i + 1];
            arrayB[i] *= tmp;
        }
        return arrayB;
    }

    public int[] star2(int[] arrayA) {
        //判空
        if (arrayA.length == 0) {
            //过
            return arrayA;
        }
        //初始化
        int[] arrayB = new int[arrayA.length];
        int[] arrayB2 = new int[arrayA.length];
        //默认第一个节点
        arrayB[0] = 1;
        arrayB2[arrayB2.length - 1] = 1;
        //循环
        for (int i = 1; i < arrayA.length; i++) {
            //计算
            arrayB[i] = arrayB[i - 1] * arrayA[i - 1];
        }
        //循环
        for (int i = arrayA.length - 2; i >= 0; i--) {
            //计算
            arrayB2[i] = arrayB2[i + 1] * arrayA[i + 1];
        }
        //循环
        for (int i = 0; i < arrayB.length; i++) {
            //合并
            arrayB[i] = arrayB[i] * arrayB2[i];
        }
        //返回
        return arrayB;
    }

    public static void main(String[] args) {
        new Code14().star2(new int[]{2, 4, 6, 8, 10});
    }

}
