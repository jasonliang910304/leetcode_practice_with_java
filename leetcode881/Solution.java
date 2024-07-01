import java.util.*;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int left = 0, counter = 0;
        Arrays.sort(people);

        for (int right = people.length - 1; right >= left; right--){
            int boatRemain = limit;
            boatRemain -= people[right];
            if(boatRemain >= people[left]){
                left++;
            }
            counter++;
        }
        return counter;
    }
    public int numRescueBoats_byGPT(int[] people, int limit) {
        int left = 0, counter = 0;
        Arrays.sort(people);  // 对人员按体重排序

        for (int right = people.length - 1; right >= left; right--) {
            if (people[right] + people[left] <= limit) {  // 判断最重和最轻的人是否可以同乘一条船
                left++;  // 如果可以，则`left`指针向右移动，表示这个人已被安排上船
            }
            counter++;  // 无论是否加了`left`指向的人，`right`指向的人都必须独自或者和左侧的人一起上一艘船
        }
        return counter;  // 返回所需的救生船数
    }
}
