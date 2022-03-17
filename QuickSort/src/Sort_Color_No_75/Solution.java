package Sort_Color_No_75;

public class Solution {

    public void sortColors(int[] nums) {

        //arr[0...zero] == 0, arr[zero+1,two-1] == 1, arr[two...nums.length] == 2
        int zero = -1, i = 0, two = nums.length;
        while (i < two) {

            if (nums[i] == 0) {
                zero++;
                swap(nums, zero, i);
                i++;
            } else if (nums[i] == 2) {
                two--;
                swap(nums, i, two);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {

        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
