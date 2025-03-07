package normal12;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2022-02-26
 * 1023. 驼峰式匹配
 * 如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
 * <p>
 * 给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
 * 输出：[true,false,true,true,false]
 * 示例：
 * "FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
 * "FootBall" 可以这样生成："F" + "oot" + "B" + "all".
 * "FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".
 * 示例 2：
 * <p>
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
 * 输出：[true,false,true,false,false]
 * 解释：
 * "FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
 * "FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
 * 示例 3：
 * <p>
 * 输出：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
 * 输入：[false,true,false,false,false]
 * 解释：
 * "FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= queries.length <= 100
 * 1 <= queries[i].length <= 100
 * 1 <= pattern.length <= 100
 * 所有字符串都仅由大写和小写英文字母组成。
 */
public class Code8 {

    //拆分
    public List<String> splitPattern(String pattern) {
        //初始化
        List<String> partList = new ArrayList<>();
        //初始化
        StringBuilder str = new StringBuilder();
        //循环
        for (int i = 0; i < pattern.length(); i++) {
            //当前
            char c = pattern.charAt(i);
            //如果是小写
            if (c > 96) {
                //直接组装
                str.append(c);
            } else {
                //如果有长度,并且开头第一个大是写
                if (str.length() > 0 && str.charAt(0) < 97) {
                    //记录
                    partList.add(str.toString());
                }
                //初始化
                str = new StringBuilder();
                str.append(c);
            }
        }
        //最后结尾
        partList.add(str.toString());
        //返回
        return partList;
    }

    //对比
    public boolean comp(List<String> wordList, List<String> partList) {
        //如果长度不对应
        if (wordList.size() != partList.size()) {
            //不行
            return false;
        }
        //循环
        for (int i = 0; i < wordList.size(); i++) {
            //对比二者
            String query = wordList.get(i);
            String part = partList.get(i);
            //快慢指针
            int left = 0, right = 0;
            //对比
            while (left < query.length() && right < part.length()) {
                //二者
                char a = query.charAt(left);
                char b = part.charAt(right);
                //对比,如果是
                if (a == b) {
                    //寻找下一个
                    right++;
                }
                //无论如何都走
                left++;
            }
            //如果没有全查询到
            if (right != part.length()) {
                //不是
                return false;
            }
        }
        //默认是
        return true;
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        //初始化结果
        List<Boolean> result = new ArrayList<>(queries.length);
        //拆分
        List<String> partList = splitPattern(pattern);
        //循环
        for (int i = 0; i < queries.length; i++) {
            //搜索并记录
            result.add(comp(splitPattern(queries[i]), partList));
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code8().camelMatch(new String[]{"uAxaqlzahfialcezsLfj", "cAqlzyahaslccezssLfj"}, "AqlzahalcezsLfj");
    }

}
