package LC75;

/*
    给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
    我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
    必须在不使用库的sort函数的情况下解决这个问题。
 */

class Solution {

    public void sortColors(int[] nums) {

        // 处理元素取值范围是 [0,R) 的计数排序
        int R = 3;

        int[] cnt = new int[R];
        // 统计nums中0，1，2出现的次数
        for (int num : nums)
            cnt[num]++;

        // [index[i],index[i+1])的值为 i
        int[] index = new int[R + 1];
        for (int i = 0; i < R; i++)
            index[i + 1] = index[i] + cnt[i];

        for (int i = 0; i + 1 < index.length; i++)
            // [index[i],index[i+1])的值为 i
            for (int j = index[i]; j < index[i + 1]; j++)
                nums[j] = i;
    }
}