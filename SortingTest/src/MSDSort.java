/*
    MSD：
        可处理不等长字符串排序
 */
public class MSDSort {

    private MSDSort() {
    }

    public static void sort(String[] arr) {

        String[] temp = new String[arr.length];
        sort(arr, 0, arr.length - 1, 0, temp);
    }

    // 根据 r 位置的字符，处理 arr [left,right]
    private static void sort(String[] arr, int left, int right, int r, String[] temp) {

        if (left >= right) return;

        int R = 256;    // 字符取值范围(可以是整型的范围
        int[] cnt = new int[R + 1];   // 多一个'空'
        int[] index = new int[R + 2];

        // O(n)
        for (int i = left; i <= right; i++)
            cnt[r >= arr[i].length() ? 0 : (arr[i].charAt(r) + 1)]++;


        // O(R)
        for (int i = 0; i < R + 1; i++)
            index[i + 1] = index[i] + cnt[i];

        // O(n)
        for (int i = left; i <= right; i++) {
            int p = r >= arr[i].length() ? 0 : (arr[i].charAt(r) + 1);
            temp[left + index[p]] = arr[i];
            index[p]++;
        }

        // O(n)
        for (int i = left; i <= right; i++)
            arr[i] = temp[i];

        // 递归下去
        for (int i = 0; i < R; i++)
            sort(arr, left + index[i], left + index[i + 1] - 1, r + 1, temp);
    }
}