package normal4;

/**
 * Created By Rock-Ayl on 2021-05-17
 */
public class Code3 {

    public int maximumSwap(int num) {
        //如果不需要交换
        if (num < 10) {
            //返回
            return num;
        }
        //转化为数组
        char[] arr = (num + "").toCharArray();
        //从第一位开始及坐标
        char first = arr[0];
        int p = 0;
        //后面的最大值及坐标
        char max = arr[1];
        int maxP = 1;
        //初始化后面
        for (int i = 2; i < arr.length; i++) {
            //如果最大值刷新了
            if (arr[i] >= max) {
                //刷新
                max = arr[i];
                maxP = i;
            }
        }
        //如果不满足交换条件
        while (p < arr.length) {
            //如果满足条件
            if (max > first) {
                //交换
                arr[p] = max;
                arr[maxP] = first;
                //结果
                int sum=0;
                //新的数
                StringBuilder std = new StringBuilder();
                //循环
                for (char i : arr) {
                    //组装
                    std.append(i);
                }
                //返回
                return Integer.valueOf(std.toString());
            }
            //+1
            p++;
            //重新刷
            first = arr[p];
            //如果到了最大值的位置
            if (p == maxP) {
                //刷新最大值
                max = '0';
                //初始化后面
                for (int i = maxP + 1; i < arr.length; i++) {
                    //如果最大值刷新了
                    if (arr[i] >= max) {
                        //刷新
                        max = arr[i];
                        maxP = i;
                    }
                }
                //如果还是之前的位置
                if (p == maxP) {
                    //结束
                    break;
                }
            }
        }
        //返回默认
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().maximumSwap(99901));
    }

}
