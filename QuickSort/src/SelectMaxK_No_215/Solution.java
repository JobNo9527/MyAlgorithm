package SelectMaxK_No_215;

import java.util.Random;

public class Solution {

    public int findKthLargest(int[] nums, int k) {

        Random rnd = new Random();
        return selectK(nums, 0, nums.length - 1, nums.length - k, rnd);
    }

    public static int selectK(int[] arr, int l, int r, int k, Random rnd) {

        int p = partition(arr, l, r, rnd);
        if (p == k) return arr[p];
        if (k < p) return selectK(arr, l, p - 1, k, rnd);
        return selectK(arr, p + 1, r, k, rnd);
    }

    private static int partition(int[] arr, int l, int r, Random rnd) {
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);

        // arr[l+1 ... i-1] <= v ; arr[i ... r] >= v
        int i = l + 1, j = r;
        while (true) {

            while (i <= j && arr[i] < arr[l])
                i++;

            while (j >= i && arr[j] > arr[l])
                j--;

            if (i >= j) break;

            swap(arr, i, j);

            i++;
            j--;
        }

        swap(arr, l, j);
        return j;

    }

    private static void swap(int[] arr, int i, int j) {

        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
