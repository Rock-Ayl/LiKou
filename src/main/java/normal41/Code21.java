package normal41;

import java.util.*;

/**
 * @Author ayl
 * @Date 2025-04-11
 * 721. 账户合并
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 * <p>
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 * <p>
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是 按字符 ASCII 顺序排列 的邮箱地址。账户本身可以以 任意顺序 返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * 输出：[["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * 解释：
 * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 * 示例 2：
 * <p>
 * 输入：accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
 * 输出：[["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= accounts.length <= 1000
 * 2 <= accounts[i].length <= 10
 * 1 <= accounts[i][j].length <= 30
 * accounts[i][0] 由英文字母组成
 * accounts[i][j] (for j > 0) 是有效的邮箱地址
 */
public class Code21 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        /**
         * 并查集分组
         */

        //并查集数组
        int[] arr = new int[accounts.size()];
        //循环
        for (int i = 0; i < arr.length; i++) {
            //默认分组
            arr[i] = i;
        }
        //邮箱第一次出现的索引
        Map<String, Integer> firstEmailIndexMap = new HashMap<>();
        //循环1
        for (int i = 0; i < accounts.size(); i++) {
            //获取本次用户数据
            List<String> userList = accounts.get(i);
            //循环2
            for (int j = 1; j < userList.size(); j++) {
                //获取其邮箱
                String email = userList.get(j);
                //如果存在该邮箱,说明其有父级了
                if (firstEmailIndexMap.containsKey(email) == true) {
                    //绑定关联的所有关系
                    bind(arr, firstEmailIndexMap.get(email), i);
                } else {
                    //加入邮箱缓存
                    firstEmailIndexMap.put(email, i);
                }
            }
        }

        /**
         * 根据分组组装结果
         */

        //结果map
        Map<Integer, Set<String>> resultMap = new HashMap<>();
        //名称数组
        String[] nameArr = new String[arr.length];
        //循环
        for (int i = 0; i < arr.length; i++) {
            //获取当前
            List<String> userList = accounts.get(i);
            //如果是顶级
            if (arr[i] == i) {
                //初始化集合
                Set<String> emailSet = new HashSet<>();
                //循环
                for (int j = 1; j < userList.size(); j++) {
                    //记录
                    emailSet.add(userList.get(j));
                }
                //记录新的缓存缓存
                resultMap.put(i, emailSet);
                //记录名称缓存
                nameArr[i] = userList.get(0);
            }
        }
        //循环
        for (int i = 0; i < arr.length; i++) {
            //获取当前
            List<String> userList = accounts.get(i);
            //如果不是顶级
            if (arr[i] != i) {
                //顶级分组,默认当前分组
                int root = i;
                //如果不是顶级,递归到顶级
                while (arr[root] != root) {
                    //上一级
                    root = arr[root];
                }
                //获取顶级的邮箱集合
                Set<String> rootEmailSet = resultMap.get(root);
                //循环
                for (int j = 1; j < userList.size(); j++) {
                    //加入该用户的邮箱
                    rootEmailSet.add(userList.get(j));
                }
            }
        }
        //初始化结果
        List<List<String>> result = new ArrayList<>(resultMap.size());
        //循环分组
        for (Integer group : resultMap.keySet()) {
            //获取分组的所有邮箱集合
            Set<String> allEmailSet = resultMap.get(group);
            //初始化列表,置顶固定空间
            List<String> groupList = new ArrayList<>(allEmailSet.size() + 1);
            //加入所有邮箱
            groupList.addAll(allEmailSet);
            //按照要求排序
            Collections.sort(groupList);
            //最后开始位置加入名称
            groupList.add(0, nameArr[group]);
            //记录结果
            result.add(groupList);
        }
        //返回最终结果
        return result;
    }

    //并查集分组
    private int bind(int[] arr, int father, int child) {
        //顶级节点
        int root;
        //判断父节点是不是顶级
        if (arr[father] != father) {
            //递归出顶级节点
            root = bind(arr, arr[father], child);
        } else {
            //父级就是该订单
            root = father;
        }
        //子节点如果不是顶级
        if (arr[child] != child) {
            //关联其他子节点
            bind(arr, root, arr[child]);
        }
        //直接该节点
        arr[child] = root;
        //返回
        return root;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new Code21().accountsMerge(Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("Mary", "mary@mail.com")
        ));
        System.out.println();
    }

}
