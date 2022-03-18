package BinarySearch_No_704;

public class Solution {

    public int search(int[] nums, int target) {

        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int l, int r, int target) {

        if (l > r) return -1;

        int mid = l + (r - l) / 2;

        if (nums[mid] == target)
            return mid;

        if (nums[mid] > target)
            return search(nums, l, mid - 1, target);

        return search(nums, mid + 1, r, target);
    }

    public int search1(int[] data, int target) {

        int l = 0, r = data.length;
        while (l < r) {

            int mid = l + (r - l) / 2;

            if (data[mid] == target)
                return mid;

            if (data[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return -1;
    }
}
