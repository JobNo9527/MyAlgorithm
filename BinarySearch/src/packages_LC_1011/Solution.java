package packages_LC_1011;

import java.util.Arrays;

public class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int r = Arrays.stream(weights).sum(), l = Arrays.stream(weights).max().getAsInt();

        while (l < r) {

            int mid = l + (r - l) / 2;
            if (days(weights, mid) <= days) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int days(int[] weights, int k) {
        int res = 0, cur = 0;
        for (int weight : weights) {
            if (cur + weight <= k)
                cur += weight;
            else {
                res++;
                cur = weight;
            }
        }

        res++;
        return res;
    }
}
