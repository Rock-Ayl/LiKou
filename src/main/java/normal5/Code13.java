package normal5;

import java.util.*;

/**
 * @Author ayl
 * @Date 2021-07-29
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 * <p>
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 * <p>
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class Code13 {

    /**
     * 官方写法
     *
     * @param strs
     * @return
     */
    public List<List<String>> star(String[] strs) {
        //map
        Map<String, List<String>> map = new HashMap<>();
        //循环
        for (String str : strs) {
            //组
            char[] array = str.toCharArray();
            //排序
            Arrays.sort(array);
            //key
            String key = new String(array);
            //获取或默认
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            //组装
            list.add(str);
            //放入
            map.put(key, list);
        }
        //转化为List
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        //结果
        List<List<String>> result = new ArrayList<>();
        //如果只有一个
        if (strs.length > 1) {
            //缓存
            Map<String, List<String>> map = new HashMap<>(strs.length);
            //循环
            for (String str : strs) {
                //转化为char
                char[] x = str.toCharArray();
                //排个序
                Arrays.sort(x);
                //新的
                StringBuffer key = new StringBuffer();
                //循环
                for (char c : x) {
                    //组装
                    key.append(c);
                }
                //结果集
                List<String> list;
                //记录
                if (map.containsKey(key.toString())) {
                    //获取已有
                    list = map.get(key.toString());
                } else {
                    //初始化
                    list = new ArrayList<>();
                }
                list.add(str);
                //记录
                map.put(key.toString(), list);
            }
            //循环
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                //组装至结果
                result.add(entry.getValue());
            }
        } else if (strs.length == 1) {
            //初始化一个的结果
            List<String> list = new ArrayList<>(1);
            list.add(strs[0]);
            result.add(list);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

}
