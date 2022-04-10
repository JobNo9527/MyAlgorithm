import java.util.Collections;
import java.util.LinkedList;

/*
    （非比较排序）桶排序
 */
public class BucketSort {

    private BucketSort() {
    }

    /**
     * @param arr 用户传入的数组
     * @param B   多少个桶（超参数：256）
     */
    public static void sort(Integer[] arr, int B) {

        if (B <= 1)
            throw new IllegalArgumentException("B must be > 1");

        Integer[] temp = new Integer[arr.length];
        sort(arr, 0, arr.length - 1, B, temp);
    }

    private static void sort(Integer[] arr, int left, int right, int B, Integer[] temp) {

        if (left >= right) return;

        int maxV = Integer.MIN_VALUE, minV = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            maxV = Math.max(maxV, arr[i]);
            minV = Math.min(minV, arr[i]);
        }

        // [left,right]这个区间元素一样（递归去理解）
        if (maxV == minV) return;

        // 每个桶的范围
        int d = (maxV - minV + 1) / B + ((maxV - minV + 1) % B > 0 ? 1 : 0);    // 上取整

        int[] cnt = new int[B]; // 桶
        int[] index = new int[B + 1];

        // O(n)
        for (int i = left; i <= right; i++)
            cnt[(arr[i] - minV) / d]++;


        // O(R)
        for (int i = 0; i < B; i++)
            index[i + 1] = index[i] + cnt[i];

        // O(n)
        for (int i = left; i <= right; i++) {
            int p = (arr[i] - minV) / d;
            temp[left + index[p]] = arr[i];
            index[p]++;
        }

        // O(n)
        for (int i = left; i <= right; i++)
            arr[i] = temp[i];

        // 递归下去
        sort(arr, left, left + index[0] - 1, B, temp);  // 0号桶（放的是'空'），偏移值是left
        for (int i = 0; i < B - 1; i++)
            sort(arr, left + index[i], left + index[i + 1] - 1, B, temp);
    }


    /**
     * @param arr 用户传入的数组
     * @param c   用户传入的桶的最大范围
     */
    public static void sort2(Integer[] arr, int c) {

        if (c <= 0)
            throw new IllegalArgumentException("c must be > 0");

        int B = arr.length / c + (arr.length % c > 0 ? 1 : 0);

        LinkedList<Integer>[] buckets = new LinkedList[B];
        for (int i = 0; i < B; i++)
            buckets[i] = new LinkedList<>();

        int maxV = Integer.MIN_VALUE, minV = Integer.MAX_VALUE;
        for (int e : arr) {
            maxV = Math.max(maxV, e);
            minV = Math.min(minV, e);
        }

        // 将arr中所有数分别放入对应的桶中（桶内元素没排序）
        for (int e : arr)
            buckets[(e - minV) / c].add(e);

        for (int i = 0; i < B; i++)
            Collections.sort(buckets[i]);

        int index = 0;
        for (int i = 0; i < B; i++)
            for (int e : buckets[i])
                arr[index++] = e;   // arr[index] = e -> index ++ -> arr[index] = e -> index ++ -> ...
    }
}