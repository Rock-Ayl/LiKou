package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2020-08-08
 * 412. Fizz Buzz
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * <p>
 * 示例：
 * <p>
 * n = 15,
 * <p>
 * 返回:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 */
public class Code6 {

    public static List<String> fizzBuzz(int n) {
        //初始化返回值
        List<String> list = new ArrayList<>();
        //如果是1
        if (n == 1) {
            //单独
            list.add(n + "");
            //返回
            return list;
        }
        //循环
        for (int i = 1; i <= n; i++) {
            int a = i % 3;
            int b = i % 5;
            //如果同时
            if (a == 0 && b == 0) {
                list.add("FizzBuzz");
            }
            //只有a
            else if (a == 0) {
                list.add("Fizz");
            }
            //只有b
            else if (b == 0) {
                list.add("Buzz");
            } else {
                list.add(i + "");
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }

}
