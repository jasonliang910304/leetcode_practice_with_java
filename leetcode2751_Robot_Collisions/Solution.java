import java.util.*;

public class Solution {
    static class Robot {
        int position;
        int health;
        char direction;
        int index;

        Robot(int position, int health, char direction, int index) {
            this.position = position;
            this.health = health;
            this.direction = direction;
            this.index = index;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Robot> robots = new ArrayList<>();
        
        // 创建 Robot 列表
        for (int i = 0; i < n; i++) {
            robots.add(new Robot(positions[i], healths[i], directions.charAt(i), i));
        }
        
        // 按位置排序
        robots.sort(Comparator.comparingInt(a -> a.position));
        
        // 使用 Deque 作为栈
        Deque<Robot> stack = new ArrayDeque<>();
        
        for (Robot robot : robots) {
            if (robot.direction == 'R') {
                stack.add(robot);
            } else {
                // 处理 'L' 方向的机器人
                boolean gone = false;
                while (!stack.isEmpty() && 
                       stack.peekLast().health <= robot.health && 
                       stack.peekLast().direction == 'R') {
                    if (stack.peekLast().health == robot.health) {
                        stack.removeLast();
                        gone = true;
                        break;
                    }
                    robot.health--;
                    stack.removeLast();
                }

                // 检查最后一个 'R' 机器人
                if (!gone && !stack.isEmpty() && 
                    stack.peekLast().direction == 'R' && 
                    stack.peekLast().health > robot.health) {
                    stack.peekLast().health--;
                    gone = true;
                }

                // 如果没有被摧毁，加入栈中
                if (!gone) {
                    stack.add(robot);
                }
            }
        }

        // 根据原始索引排序
        List<Robot> survivedRobots = new ArrayList<>(stack);
        survivedRobots.sort(Comparator.comparingInt(a -> a.index));

        // 返回幸存机器人的健康值
        List<Integer> result = new ArrayList<>();
        for (Robot robot : survivedRobots) {
            result.add(robot.health);
        }
        return result;
    }
}
