package normal15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author ayl
 * @Date 2022-07-31
 * 面试题 16.19. 水域大小
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * [
 * [0,2,1,0],
 * [0,1,0,1],
 * [1,1,0,1],
 * [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 * 提示：
 * <p>
 * 0 < len(land) <= 1000
 * 0 < len(land[i]) <= 1000
 */
public class Code9 {

    public int fill(int x, int y, int[][] land) {
        //如果越界
        if (x < 0 || y < 0 || x >= land.length || y >= land[0].length) {
            //返回
            return 0;
        }
        //如果不是海洋
        if (land[x][y] != 0) {
            //返回
            return 0;
        }
        //填充当前海洋
        land[x][y]++;
        //填充数量
        int count = 1;
        //上下左右斜对角
        count += fill(x + 1, y, land);
        count += fill(x - 1, y, land);
        count += fill(x, y + 1, land);
        count += fill(x, y - 1, land);
        count += fill(x + 1, y + 1, land);
        count += fill(x + 1, y - 1, land);
        count += fill(x - 1, y + 1, land);
        count += fill(x - 1, y - 1, land);
        //返回
        return count;
    }

    public int[] pondSizes(int[][] land) {
        //结果
        List<Integer> countList = new ArrayList<>();
        //循环1
        for (int i = 0; i < land.length; i++) {
            //循环2
            for (int j = 0; j < land[0].length; j++) {
                //如果是海洋
                if (land[i][j] == 0) {
                    //填充
                    int count = fill(i, j, land);
                    //记录
                    countList.add(count);
                }
            }
        }
        //排序
        Collections.sort(countList);
        //转换并返回
        return countList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        new Code9().pondSizes(new int[][]{
                new int[]{0, 2, 1, 0},
                new int[]{0, 1, 0, 1},
                new int[]{1, 1, 0, 1},
                new int[]{0, 1, 0, 1}
        });
    }

}
