package normal;

import java.util.*;

/**
 * Created By Rock-Ayl on 2020-08-07
 * 451. 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * 示例 1:
 * 输入:
 * "tree"
 * 输出:
 * "eert"
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 * 输入:
 * "cccaaa"
 * 输出:
 * "cccaaa"
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 * 输入:
 * "Aabb"
 * 输出:
 * "bbAa"
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 */
public class Code3 {

    public static String frequencySort(String s) {
        //记录
        Map<String, Integer> map = new HashMap<>();
        //分割
        char[] arrChar = s.toCharArray();
        //循环
        for (char anyone : arrChar) {
            //转换
            String thisOne = anyone + "";
            //如果存在
            if (map.containsKey(thisOne)) {
                //获取数据
                int num = map.get(thisOne);
                //叠加
                map.put(thisOne, (num + 1));
            } else {
                map.put(thisOne, 1);
            }
        }
        //开始组合
        Map<Integer, StringBuffer> putMap = new HashMap<>();
        //循环
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            //获取key
            String key = stringIntegerEntry.getKey();
            //获取值
            int value = stringIntegerEntry.getValue();
            //获取里面的组合值
            StringBuffer buf;
            //如果组合出现过该value
            if (putMap.containsKey(value)) {
                //获取
                buf = putMap.get(value);
            } else {
                //新建
                buf = new StringBuffer();
            }
            //组装
            for (int i = 0; i < value; i++) {
                //组装
                buf.append(key);
            }
            //再度存储
            putMap.put(value, buf);
        }
        //初始化返回值
        StringBuffer result = new StringBuffer();
        //准备排序
        List<Integer> sortList = new ArrayList<>();
        //循环
        for (Map.Entry<Integer, StringBuffer> integerStringBufferEntry : putMap.entrySet()) {
            //组装key
            sortList.add(integerStringBufferEntry.getKey());
        }
        //排序
        Collections.sort(sortList);
        //倒叙
        Collections.reverse(sortList);
        //循环
        for (Integer thisSortKey : sortList) {
            //获取值并按倒叙组装
            result.append(putMap.get(thisSortKey));
        }
        //返回
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("AsiosofjasoidjodajiojfoisoJOIJIJOjoijfsoiajjojJFOSJsjidosaj"));
    }
}
