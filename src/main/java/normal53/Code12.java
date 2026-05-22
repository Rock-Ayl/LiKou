package normal53;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 2211. 统计道路上的碰撞次数
 * 算术评级: 5
 * 第 285 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1581
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 在一条无限长的公路上有 n 辆汽车正在行驶。汽车按从左到右的顺序按从 0 到 n - 1 编号，每辆车都在一个 独特的 位置。
 * <p>
 * 给你一个下标从 0 开始的字符串 directions ，长度为 n 。directions[i] 可以是 'L'、'R' 或 'S' 分别表示第 i 辆车是向 左 、向 右 或者 停留 在当前位置。每辆车移动时 速度相同 。
 * <p>
 * 碰撞次数可以按下述方式计算：
 * <p>
 * 当两辆移动方向 相反 的车相撞时，碰撞次数加 2 。
 * 当一辆移动的车和一辆静止的车相撞时，碰撞次数加 1 。
 * 碰撞发生后，涉及的车辆将无法继续移动并停留在碰撞位置。除此之外，汽车不能改变它们的状态或移动方向。
 * <p>
 * 返回在这条道路上发生的 碰撞总次数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：directions = "RLRSLL"
 * 输出：5
 * 解释：
 * 将会在道路上发生的碰撞列出如下：
 * - 车 0 和车 1 会互相碰撞。由于它们按相反方向移动，碰撞数量变为 0 + 2 = 2 。
 * - 车 2 和车 3 会互相碰撞。由于 3 是静止的，碰撞数量变为 2 + 1 = 3 。
 * - 车 3 和车 4 会互相碰撞。由于 3 是静止的，碰撞数量变为 3 + 1 = 4 。
 * - 车 4 和车 5 会互相碰撞。在车 4 和车 3 碰撞之后，车 4 会待在碰撞位置，接着和车 5 碰撞。碰撞数量变为 4 + 1 = 5 。
 * 因此，将会在道路上发生的碰撞总次数是 5 。
 * 示例 2：
 * <p>
 * 输入：directions = "LLRR"
 * 输出：0
 * 解释：
 * 不存在会发生碰撞的车辆。因此，将会在道路上发生的碰撞总次数是 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= directions.length <= 105
 * directions[i] 的值为 'L'、'R' 或 'S'
 */
public class Code12 {

    //车辆
    private static class Car {

        //当前字符(方向)
        private Character letter;

        //是否停止
        private boolean stop;

        //是否使用过
        private boolean used;

        //初始化
        public Car(Character letter) {
            this.letter = letter;
            //判断是否停止
            this.stop = letter.equals('S');
            //默认没用过
            this.used = false;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("Car{letter=%s, stop=%s, used=%s}", letter, stop, used);
        }

    }

    public int countCollisions(String directions) {
        //初始化
        List<Car> carList = new ArrayList<>();
        //循环
        for (int i = 0; i < directions.length(); i++) {
            //添加车辆
            carList.add(new Car(directions.charAt(i)));
        }
        //结果
        int result = 0;
        //循环
        for (int i = 0; i < carList.size(); i++) {
            //计算本车
            result += next(carList, i);
        }
        //返回
        return result;
    }

    //递归计算车碰撞
    private int next(List<Car> carList, int index) {
        //越界
        if (index < 0 || index >= carList.size()) {
            //判空
            return 0;
        }
        //获取本次车辆
        Car car = carList.get(index);
        //如果使用过了
        if (car.used == true) {
            //过
            return 0;
        }
        //记录其使用过
        car.used = true;
        //如果是停止的
        if (car.stop == true) {
            //过
            return 0;
        }
        //获取方向
        Character letter = car.letter;
        //获取另一个方向的车
        Car otherCar;
        //判断方向
        if (letter.equals('L')) {
            //获取另一个方向的
            otherCar = get(carList, index - 1);
        } else {
            //获取另一个方向的
            otherCar = get(carList, index + 1);
        }
        //如果没有车
        if (otherCar == null) {
            //过
            return 0;
        }
        //如果另一台是不动的
        if (otherCar.stop) {
            //记录其停止
            car.stop = true;
            //相撞
            return 1;
        }
        //如果方向不同
        if (otherCar.letter.equals(car.letter) == false) {
            //记录其停止
            car.stop = true;
            otherCar.stop = true;
            //相撞
            return 2;
        }
        //先递归该车
        int count = 0;
        //判断方向
        if (letter.equals('L')) {
            //递归该车
            count = next(carList, index - 1);
        } else {
            //递归该车
            count = next(carList, index + 1);
        }
        //如果此时另一台是不动的
        if (otherCar.stop) {
            //记录其停止
            car.stop = true;
            //相撞
            return count + 1;
        }
        //默认
        return count;
    }

    //获取索引的车
    private Car get(List<Car> carList, int index) {
        //越界
        if (index < 0 || index >= carList.size()) {
            //判空
            return null;
        }
        //返回
        return carList.get(index);
    }

    public static void main(String[] args) {
        System.out.println(new Code12().countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"));
    }

}