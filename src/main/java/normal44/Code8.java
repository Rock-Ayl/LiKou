package normal44;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2025-06-25
 * 1311. 获取你好友已观看的视频
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 有 n 个人，每个人都有一个  0 到 n-1 的唯一 id 。
 * <p>
 * 给你数组 watchedVideos  和 friends ，其中 watchedVideos[i]  和 friends[i] 分别表示 id = i 的人观看过的视频列表和他的好友列表。
 * <p>
 * Level 1 的视频包含所有你好友观看过的视频，level 2 的视频包含所有你好友的好友观看过的视频，以此类推。一般的，Level 为 k 的视频包含所有从你出发，最短距离为 k 的好友观看过的视频。
 * <p>
 * 给定你的 id  和一个 level 值，请你找出所有指定 level 的视频，并将它们按观看频率升序返回。如果有频率相同的视频，请将它们按字母顺序从小到大排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 1
 * 输出：["B","C"]
 * 解释：
 * 你的 id 为 0（绿色），你的朋友包括（黄色）：
 * id 为 1 -> watchedVideos = ["C"]
 * id 为 2 -> watchedVideos = ["B","C"]
 * 你朋友观看过视频的频率为：
 * B -> 1
 * C -> 2
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：watchedVideos = [["A","B"],["C"],["B","C"],["D"]], friends = [[1,2],[0,3],[0,3],[1,2]], id = 0, level = 2
 * 输出：["D"]
 * 解释：
 * 你的 id 为 0（绿色），你朋友的朋友只有一个人，他的 id 为 3（黄色）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == watchedVideos.length == friends.length
 * 2 <= n <= 100
 * 1 <= watchedVideos[i].length <= 100
 * 1 <= watchedVideos[i][j].length <= 8
 * 0 <= friends[i].length < n
 * 0 <= friends[i][j] < n
 * 0 <= id < n
 * 1 <= level < n
 * 如果 friends[i] 包含 j ，那么 friends[j] 包含 i
 */
public class Code8 {

    private static class Person {

        //用户id
        private int id;

        //该用户看的视频
        private List<String> video;

        //该用户的朋友
        private int[] friend;

        //是否使用过,默认未使用过
        private boolean used = false;

        //初始化
        public Person(int id, List<String> video, int[] friend) {
            this.id = id;
            this.video = video;
            this.friend = friend;
        }

        @Override
        public String toString() {
            return String.format("id=%s,video=%s,friend=%s", this.id, this.video.size(), this.friend.length);
        }

    }

    //视频
    private static class Video {

        //视频
        private String video;

        //数量,默认0
        private int count = 0;

        //初始化
        public Video(String video) {
            this.video = video;
        }

        //输出
        @Override
        public String toString() {
            return this.video;
        }

    }

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {

        /**
         * 构建节点
         */

        //用户缓存
        Person[] personArr = new Person[watchedVideos.size()];
        //循环
        for (int i = 0; i < watchedVideos.size(); i++) {
            //初始化用户
            Person person = new Person(i, watchedVideos.get(i), friends[i]);
            //组装至缓存
            personArr[i] = person;
        }

        /**
         * 递归
         */

        //主节点
        Person root = personArr[id];
        //记录其已经被使用过了
        root.used = true;
        //递归出结果
        return next(personArr, Arrays.asList(root), 1, level);
    }

    private List<String> next(Person[] personArr, List<Person> personList, int level, int targetLevel) {
        //初始化下一级朋友列表
        List<Person> nextPersonList = new ArrayList<>();
        //循环
        for (Person father : personList) {
            //循环2
            for (int i : father.friend) {
                //获取朋友
                Person child = personArr[i];
                //如果使用过了
                if (child.used == true) {
                    //本路过
                    continue;
                }
                //记录使用过
                child.used = true;
                //组装
                nextPersonList.add(child);
            }
        }
        //如果是目标层级
        if (level == targetLevel) {
            //统计
            Map<String, Video> videoMap = new HashMap<>();
            //循环1
            for (Person person : nextPersonList) {
                //循环2
                for (String video : person.video) {
                    //如果不存在
                    if (videoMap.containsKey(video) == false) {
                        //初始化
                        videoMap.put(video, new Video(video));
                    }
                    //+1
                    videoMap.get(video).count++;
                }
            }
            //排序、拆箱、返回
            return videoMap
                    .values()
                    .stream()
                    //排序
                    .sorted((a, b) -> a.count == b.count ? a.video.compareTo(b.video) : a.count - b.count)
                    //拆箱
                    .map(Video::toString)
                    .collect(Collectors.toList());
        }
        //递归
        return next(personArr, nextPersonList, level + 1, targetLevel);
    }

    public static void main(String[] args) {
        List<String> strings = new Code8().watchedVideosByFriends(Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C"),
                Arrays.asList("B", "C"),
                Arrays.asList("d")
        ), new int[][]{
                new int[]{1, 2},
                new int[]{0, 3},
                new int[]{0, 3},
                new int[]{1, 2}
        }, 0, 1);
        System.out.println();
    }

}
