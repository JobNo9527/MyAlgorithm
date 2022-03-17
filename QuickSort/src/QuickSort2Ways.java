import java.util.Random;

public class QuickSort2Ways {

    private QuickSort2Ways() {
    }

    public static <E extends Comparable<E>> void sort2ways(E[] arr) {
        Random rnd = new Random();
        sort2ways(arr, 0, arr.length - 1, rnd);
    }

    private static <E extends Comparable<E>> void sort2ways(E[] arr, int l, int r, Random rnd) {

        if (l >= r) return;

        int p = partition2(arr, l, r, rnd);
        sort2ways(arr, l, p - 1, rnd);
        sort2ways(arr, p + 1, r, rnd);
    }

    private static <E extends Comparable<E>> int partition2(E[] arr, int l, int r, Random rnd) {

        // 生成 [l, r] 之间的随机索引
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);

        // arr[l+1 ... i-1] <= v ; arr[j+1 ... r] >= v
        int i = l + 1, j = r;
        while (true) {

            while (i <= j && arr[i].compareTo(arr[l]) < 0) //循环终止的条件是当i处值大于等于j处值
                i++;

            while (j >= i && arr[j].compareTo(arr[l]) > 0)
                j--;

            //遍历完成了
            if (i >= j) break;

            swap(arr, i, j);
            i++;
            j--;
        }

        swap(arr, l, j);
        return j;
    }

    private static <E> void swap(E[] arr, int i, int j) {

        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
