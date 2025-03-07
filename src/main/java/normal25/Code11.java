package normal25;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2023-10-23
 * 355. 设计推特
 * 中等
 * 371
 * 相关企业
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近 10 条推文。
 * <p>
 * 实现 Twitter 类：
 * <p>
 * Twitter() 初始化简易版推特对象
 * void postTweet(int userId, int tweetId) 根据给定的 tweetId 和 userId 创建一条新推文。每次调用此函数都会使用一个不同的 tweetId 。
 * List<Integer> getNewsFeed(int userId) 检索当前用户新闻推送中最近  10 条推文的 ID 。新闻推送中的每一项都必须是由用户关注的人或者是用户自己发布的推文。推文必须 按照时间顺序由最近到最远排序 。
 * void follow(int followerId, int followeeId) ID 为 followerId 的用户开始关注 ID 为 followeeId 的用户。
 * void unfollow(int followerId, int followeeId) ID 为 followerId 的用户不再关注 ID 为 followeeId 的用户。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
 * [[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
 * 输出
 * [null, null, [5], null, null, [6, 5], null, [5]]
 * <p>
 * 解释
 * Twitter twitter = new Twitter();
 * twitter.postTweet(1, 5); // 用户 1 发送了一条新推文 (用户 id = 1, 推文 id = 5)
 * twitter.getNewsFeed(1);  // 用户 1 的获取推文应当返回一个列表，其中包含一个 id 为 5 的推文
 * twitter.follow(1, 2);    // 用户 1 关注了用户 2
 * twitter.postTweet(2, 6); // 用户 2 发送了一个新推文 (推文 id = 6)
 * twitter.getNewsFeed(1);  // 用户 1 的获取推文应当返回一个列表，其中包含两个推文，id 分别为 -> [6, 5] 。推文 id 6 应当在推文 id 5 之前，因为它是在 5 之后发送的
 * twitter.unfollow(1, 2);  // 用户 1 取消关注了用户 2
 * twitter.getNewsFeed(1);  // 用户 1 获取推文应当返回一个列表，其中包含一个 id 为 5 的推文。因为用户 1 已经不再关注用户 2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= userId, followerId, followeeId <= 500
 * 0 <= tweetId <= 104
 * 所有推特的 ID 都互不相同
 * postTweet、getNewsFeed、follow 和 unfollow 方法最多调用 3 * 104 次
 */
public class Code11 {

    //关注缓存
    private Map<Integer, Set<Integer>> followMap;
    //用户发送推文map
    private Map<Integer, Set<Integer>> feedMap;
    //用户发送推文排序map
    private Map<Integer, Integer> feedSortMap;
    //推文排序
    private Integer feedSortNumber = 1;

    public Code11() {
        //初始化
        this.followMap = new HashMap<>();
        this.feedMap = new HashMap<>();
        this.feedSortMap = new HashMap<>();
    }

    //发送推文
    public void postTweet(int userId, int tweetId) {
        //记录推文排序
        this.feedSortMap.put(tweetId, this.feedSortNumber++);
        //初始化用户推文列表
        initFeedMap(userId);
        //记录用户发送了该推文
        this.feedMap.get(userId).add(tweetId);

    }

    //获取可见推文
    public List<Integer> getNewsFeed(int userId) {
        //初始化结果
        List<Integer> resultList = new ArrayList<>();
        //加入自己的推文
        resultList.addAll(this.feedMap.getOrDefault(userId, new HashSet<>()));
        //获取用户关注的用户
        Set<Integer> followUserList = this.followMap.getOrDefault(userId, new HashSet<>());
        //循环关注
        for (Integer followUser : followUserList) {
            //加入关注的推文
            resultList.addAll(this.feedMap.getOrDefault(followUser, new HashSet<>()));
        }
        //排序、并返回近10个
        return resultList.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //按照排序排序
                return feedSortMap.get(o2) - feedSortMap.get(o1);
            }
        }).limit(10).collect(Collectors.toList());
    }

    //关注
    public void follow(int followerId, int followeeId) {
        //尝试初始化
        initFollowMap(followerId);
        //直接关注
        this.followMap.get(followerId).add(followeeId);
    }

    //取消关注
    public void unfollow(int followerId, int followeeId) {
        //尝试初始化
        initFollowMap(followerId);
        //取消关注
        this.followMap.get(followerId).remove(followeeId);
    }

    //初始化关注缓存
    private void initFollowMap(int followerId) {
        //如果存在
        if (this.followMap.containsKey(followerId)) {
            //过
            return;
        }
        //初始化
        this.followMap.put(followerId, new HashSet<>());
    }

    //初始化关注缓存
    private void initFeedMap(int userId) {
        //如果存在
        if (this.feedMap.containsKey(userId)) {
            //过
            return;
        }
        //初始化
        this.feedMap.put(userId, new HashSet<>());
    }

    public static void main(String[] args) {
        Code11 code = new Code11();
        code.postTweet(1, 5);
        code.postTweet(1, 3);
        code.postTweet(1, 101);
        code.postTweet(1, 13);
        code.postTweet(1, 10);
        code.postTweet(1, 2);
        code.postTweet(1, 94);
        code.postTweet(1, 505);
        code.postTweet(1, 333);
        code.postTweet(1, 22);
        code.postTweet(1, 11);
        List<Integer> newsFeed = code.getNewsFeed(1);
        System.out.println();
    }

}
