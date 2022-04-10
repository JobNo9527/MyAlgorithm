import java.util.Arrays;

public class LSDSort {

    private LSDSort() {
    }

    // 要求用户传入的字符串必须是等长(W)
    public static void sort(String[] arr, int W) {

        for (String s : arr)
            if (s.length() != W)
                throw new IllegalArgumentException("All Strings' length must be the same.");

        int R = 256;    // 字符取值范围(可以是整型的范围
        int[] cnt = new int[R];
        int[] index = new int[R + 1];
        String[] temp = new String[arr.length];
        for (int r = W - 1; r >= 0; r--) {
            // 基于第r位字符进行计数排序
            // 计数排序过程（非比较排序)

            // O(n)
            Arrays.fill(cnt, 0);
            for (String s : arr)
                cnt[s.charAt(r)]++;

            // O(R)
            for (int i = 0; i < R; i++)
                index[i + 1] = index[i] + cnt[i];

            // O(n)
            for (String s : arr) {
                temp[index[s.charAt(r)]] = s;
                index[s.charAt(r)]++;
            }

            // O(n)
            for (int i = 0; i < arr.length; i++)
                arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {

        String[] arr = {"BCA", "CAB", "ACB", "BAC", "ABC", "CBA"};
        LSDSort.sort(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}
