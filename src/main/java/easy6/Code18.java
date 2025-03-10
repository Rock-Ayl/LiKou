package easy6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created By Rock-Ayl on 2021-02-16
 * 811. 子域名访问计数
 * 一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。作为顶级域名，常用的有"com"，下一级则有"leetcode.com"，最低的一级为"discuss.leetcode.com"。当我们访问域名"discuss.leetcode.com"时，也同时访问了其父域名"leetcode.com"以及顶级域名 "com"。
 * <p>
 * 给定一个带访问次数和域名的组合，要求分别计算每个域名被访问的次数。其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com"。
 * <p>
 * 接下来会给出一组访问次数和域名组合的列表cpdomains 。要求解析出所有域名的访问次数，输出格式和输入格式相同，不限定先后顺序。
 * <p>
 * 示例 1:
 * 输入:
 * ["9001 discuss.leetcode.com"]
 * 输出:
 * ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
 * 说明:
 * 例子中仅包含一个网站域名："discuss.leetcode.com"。按照前文假设，子域名"leetcode.com"和"com"都会被访问，所以它们都被访问了9001次。
 * 示例 2
 * 输入:
 * ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 * 输出:
 * ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 * 说明:
 * 按照假设，会访问"google.mail.com" 900次，"yahoo.com" 50次，"intel.mail.com" 1次，"wiki.org" 5次。
 * 而对于父域名，会访问"mail.com" 900+1 = 901次，"com" 900 + 50 + 1 = 951次，和 "org" 5 次。
 * 注意事项：
 * <p>
 * cpdomains 的长度小于 100。
 * 每个域名的长度小于100。
 * 每个域名地址包含一个或两个"."符号。
 * 输入中任意一个域名的访问次数都小于10000。
 */
public class Code18 {

    public static List<String> subdomainVisits(String[] cpdomains) {
        //缓存
        Map<String, Integer> map = new HashMap<>();
        //判空
        if (cpdomains.length > 0) {
            //循环
            for (String cpdomain : cpdomains) {
                //拆分左右
                String[] arr = cpdomain.split(" ");
                //判断
                if (arr.length == 2) {
                    //次数
                    int num = Integer.parseInt(arr[0]);
                    //整个域名
                    String domain = arr[1];
                    //拆分为各个子域名
                    String[] domains = domain.split("\\.");
                    //当前域名
                    String thisDomain = null;
                    //倒叙循环
                    for (int i = domains.length - 1; i >= 0; i--) {
                        //判空
                        if (thisDomain == null) {
                            //com
                            thisDomain = domains[i];
                        } else {
                            //子域名
                            thisDomain = domains[i] + "." + thisDomain;
                        }
                        //大小
                        int size;
                        //如果缓存中已经存在该域名
                        if (map.containsKey(thisDomain)) {
                            //获取
                            size = map.get(thisDomain) + num;
                        } else {
                            size = num;
                        }
                        //记录
                        map.put(thisDomain, size);
                    }
                }
            }
        }
        //初始化返回值
        List<String> result = new ArrayList<>();
        //判空
        if (map.size() > 0) {
            //循环
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                //组装
                result.add(entry.getValue() + " " + entry.getKey());
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
    }
}
