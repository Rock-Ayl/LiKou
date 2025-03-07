package normal32;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-06-06
 * 2456. 最流行的视频创作者
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个字符串数组 creators 和 ids ，和一个整数数组 views ，所有数组的长度都是 n 。平台上第 i 个视频者是 creator[i] ，视频分配的 id 是 ids[i] ，且播放量为 views[i] 。
 * <p>
 * 视频创作者的 流行度 是该创作者的 所有 视频的播放量的 总和 。请找出流行度 最高 创作者以及该创作者播放量 最大 的视频的 id 。
 * <p>
 * 如果存在多个创作者流行度都最高，则需要找出所有符合条件的创作者。
 * 如果某个创作者存在多个播放量最高的视频，则只需要找出字典序最小的 id 。
 * 返回一个二维字符串数组 answer ，其中 answer[i] = [creatori, idi] 表示 creatori 的流行度 最高 且其最流行的视频 id 是 idi ，可以按任何顺序返回该结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：creators = ["alice","bob","alice","chris"], ids = ["one","two","three","four"], views = [5,10,5,4]
 * 输出：[["alice","one"],["bob","two"]]
 * 解释：
 * alice 的流行度是 5 + 5 = 10 。
 * bob 的流行度是 10 。
 * chris 的流行度是 4 。
 * alice 和 bob 是流行度最高的创作者。
 * bob 播放量最高的视频 id 为 "two" 。
 * alice 播放量最高的视频 id 是 "one" 和 "three" 。由于 "one" 的字典序比 "three" 更小，所以结果中返回的 id 是 "one" 。
 * 示例 2：
 * <p>
 * 输入：creators = ["alice","alice","alice"], ids = ["a","b","c"], views = [1,2,2]
 * 输出：[["alice","b"]]
 * 解释：
 * id 为 "b" 和 "c" 的视频都满足播放量最高的条件。
 * 由于 "b" 的字典序比 "c" 更小，所以结果中返回的 id 是 "b" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == creators.length == ids.length == views.length
 * 1 <= n <= 105
 * 1 <= creators[i].length, ids[i].length <= 5
 * creators[i] 和 ids[i] 仅由小写英文字母组成
 * 0 <= views[i] <= 105
 */
public class Code14 {

    //创作者实体
    private static class Creator {

        //作者名
        private String userName;

        //播放量和
        private long viewSum = 0L;

        //视频列表
        private List<Video> videoList = new ArrayList<>();

        //初始化作者
        public Creator(String userName) {
            this.userName = userName;
        }

        //加入一个视频
        public void addVideo(String id, int view) {
            //初始化视频
            Video video = new Video(id, view);
            //加入
            this.videoList.add(video);
            //叠加播放量
            this.viewSum += view;
        }

        //返回改实体的目标结果
        public List<String> toResult() {
            //视频按照规则排序
            this.videoList.sort(Video::compareTo);
            //返回结果
            return Arrays.asList(this.userName, this.videoList.get(0).id);
        }

        //视频实体
        private static class Video {

            //视频id
            private String id;

            //播放量
            private int view;

            //初始化一个视频
            public Video(String id, int view) {
                this.id = id;
                this.view = view;
            }

            //视频比较方法
            public int compareTo(Video other) {
                //如果播放量不同
                if (this.view != other.view) {
                    //按播放量
                    return other.view - this.view;
                } else {
                    //按照id
                    return this.id.compareTo(other.id);
                }
            }

        }

    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        //初始化作者map
        Map<String, Creator> creatorMap = new HashMap<>();
        //最大视频和
        long maxViewSum = 0L;
        //循环
        for (int i = 0; i < creators.length; i++) {
            //获取作者名
            String creatorName = creators[i];
            //如果不存在作者
            if (creatorMap.containsKey(creatorName) == false) {
                //初始化作者
                creatorMap.put(creatorName, new Creator(creatorName));
            }
            //获取作者实体
            Creator creatorObject = creatorMap.get(creatorName);
            //加入视频
            creatorObject.addVideo(ids[i], views[i]);
            //刷新最大播放量
            maxViewSum = Math.max(creatorObject.viewSum, maxViewSum);
        }
        //不可改变
        final long finalMaxViewSum = maxViewSum;
        //获取结果并返回
        return creatorMap.values()
                .stream()
                //只需要播放量最多的和
                .filter(p -> p.viewSum == finalMaxViewSum)
                //实体转为结果
                .map(Creator::toResult)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<List<String>> lists = new Code14().mostPopularCreator(
                new String[]{"alice", "alice", "alice"},
                new String[]{"a", "b", "c"},
                new int[]{1, 2, 2});
        System.out.println();
    }

}
