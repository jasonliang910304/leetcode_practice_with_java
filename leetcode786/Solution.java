import java.util.*;

class Solution_binary_search {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double left = 0.0, right = 1.0, mid;
        int[] result = new int[2]; // 用來存儲答案的分子和分母

        while (right - left > 1e-9) { // 確保二分搜索在足夠的精確度後結束
            mid = left + (right - left) / 2;
            int count = 0, num = 0, den = 1;
            double maxFraction = 0.0; // 用來記錄迄今為止的最大分數

            for (int i = 0, j = 1; i < n - 1; i++) {
                while (j < n && arr[i] > mid * arr[j]) {
                    j++;
                }
                count += n - j; // 計算小於等於mid的分數數量

                // 更新最接近mid但不超過mid的最大分數
                if (j < n && arr[i] * 1.0 / arr[j] > maxFraction) {
                    maxFraction = arr[i] * 1.0 / arr[j];
                    num = arr[i];
                    den = arr[j];
                }
            }

            if (count == k) { // 找到第k個最小元素
                result[0] = num;
                result[1] = den;
                break;
            } else if (count < k) {
                left = mid; // 要增加mid
            } else {
                right = mid; // 要減少mid
            }
        }

        return result;
    }
}

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> Double.compare(arr[a[0]] * 1.0 / arr[a[1]], arr[b[0]] * 1.0 / arr[b[1]])
        );

        for(int i = 0; i < n - 1; i++){
            heap.add(new int[]{i, n - 1});
        }

        for(int i = 1; i < k; i++){
            int[] frac = heap.poll();
            int numIdx = frac[0];
            int denIdx = frac[1];
            if(denIdx - 1 > numIdx){
                heap.add(new int[] {numIdx, denIdx - 1});
            }
        }

        int[] result = heap.poll();
        return new int[] {arr[result[0]], arr[result[1]]};
    }
}
