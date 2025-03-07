package easy4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created By Rock-Ayl on 2020-12-21
 * 1002. 查找常用字符
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * <p>
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 */
public class Code16 {

    public static List<String> commonChars(String[] A) {
        //缓存1
        List<HashMap<Character, Integer>> list = new ArrayList<>();
        //循环
        for (String s : A) {
            //缓存2
            HashMap<Character, Integer> map = new HashMap<>();
            //循环
            for (char c : s.toCharArray()) {
                //如果存在
                if (map.containsKey(c)) {
                    //叠加
                    map.put(c, map.get(c) + 1);
                } else {
                    //初次
                    map.put(c, 1);
                }
            }
            //组装
            list.add(map);
        }
        //key出现几次算可以
        int size = A.length;
        //缓存2
        HashMap<Character, Integer> map2 = new HashMap();
        //循环1
        for (HashMap<Character, Integer> map1 : list) {
            //循环2
            for (Map.Entry<Character, Integer> characterIntegerEntry : map1.entrySet()) {
                //获取key
                Character x = characterIntegerEntry.getKey();
                //如果存在
                if (map2.containsKey(x)) {
                    //叠加
                    map2.put(x, map2.get(x) + 1);
                } else {
                    //初次
                    map2.put(x, 1);
                }
            }
        }
        //缓存3
        List<Character> list2 = new ArrayList<>();
        //循环
        for (Map.Entry<Character, Integer> characterIntegerEntry : map2.entrySet()) {
            //如果是常用char
            if (characterIntegerEntry.getValue() == size) {
                //记录
                list2.add(characterIntegerEntry.getKey());
            }
        }
        //返回值
        List<String> result = new ArrayList<>();
        //循环-分析常用char的次数
        for (Character character : list2) {
            //最大次数
            Integer max = null;
            //循环
            for (HashMap<Character, Integer> characterIntegerHashMap : list) {
                //判空
                if (max == null) {
                    //初始化
                    max = characterIntegerHashMap.get(character);
                } else {
                    //获取并选取最小的
                    max = Math.min(max, characterIntegerHashMap.get(character));
                }
            }
            //循环
            while (max > 0) {
                //记录返回值
                result.add(character + "");
                //递减
                max--;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (String commonChar : commonChars(new String[]{"cool", "lock", "cook"})) {
            System.out.println(commonChar);
        }
    }
}
