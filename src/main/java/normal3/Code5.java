package normal3;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created By Rock-Ayl on 2021-04-27
 * 423. 从英文中重建数字
 * 给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。
 * <p>
 * 注意:
 * <p>
 * 输入只包含小写英文字母。
 * 输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
 * 输入字符串的长度小于 50,000。
 * 示例 1:
 * <p>
 * 输入: "owoztneoer"
 * <p>
 * 输出: "012" (zeroonetwo)
 * 示例 2:
 * <p>
 * 输入: "fviefuro"
 * <p>
 * 输出: "45" (fourfive)
 */
public class Code5 {

    //剔除顺序  z=zero    u=four   w=two  g=eight   h=three  f=five   o=one  x=six  i=nine

    //基础字符
    Character[] charArr = new Character[]{'z', 'u', 'w', 'g', 'h', 'f', 'o', 'x', 'i', 's'};
    //单词
    String[] arr = new String[]{"zero", "four", "two", "eight", "three", "five", "one", "six", "nine", "seven"};
    //单词
    int[] numArr = new int[]{0, 4, 2, 8, 3, 5, 1, 6, 9, 7};

    public String originalDigits(String s) {
        //缓存
        Map<Character, Integer> map = new HashMap<>();
        //循环
        for (char c : s.toCharArray()) {
            //个数
            int size;
            //如果存在
            if (map.containsKey(c)) {
                //已有+1
                size = map.get(c) + 1;
            } else {
                //默认1
                size = 1;
            }
            //组装回去
            map.put(c, size);
        }
        //结果list
        List<Integer> list = new ArrayList<>();
        //循环
        for (int i = 0; i < charArr.length; i++) {
            //当前基础字符
            char character = charArr[i];
            //如果存在
            if (map.containsKey(character)) {
                //获取数量
                int num = map.get(character);
                //循环
                while (num > 0) {
                    //当前字母
                    String thisWord = arr[i];
                    //循环
                    for (char c : thisWord.toCharArray()) {
                        //记录
                        map.put(c, map.get(c) - 1);
                    }
                    //叠加
                    list.add(numArr[i]);
                    //递减
                    num--;
                }
            }
        }
        //排个序
        Collections.sort(list);
        //结果str
        StringBuffer str = new StringBuffer();
        //循环
        for (Integer integer : list) {
            //组装
            str.append(integer);
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code5().originalDigits("owoztneoer"));
    }

}
