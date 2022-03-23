import java.util.Random;

public class QuickSort3Ways {

    private QuickSort3Ways() {
    }

    public static <E extends Comparable<E>> void sort3ways(E[] arr) {
        Random rnd = new Random();  //随机化标定点
        sort3ways(arr, 0, arr.length - 1, rnd);
    }

    private static <E extends Comparable<E>> void sort3ways(E[] arr, int l, int r, Random rnd) {

        // partition3
        if (l >= r) return;

        // 生成 [l, r] 之间的随机索引
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);

        // arr[l+1,lt] < v , arr[lt+1,i-1] == v , arr[gt,r] > v
        int lt = l, i = l + 1, gt = r + 1;
        while (i < gt) {

            if (arr[i].compareTo(arr[l]) < 0) {
                lt++;
                swap(arr, i, lt);
                i++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt--;
                swap(arr, i, gt);
            } else { //arr[i] == arr[l]
                i++;
            }
        }

        swap(arr, l, lt);
        // arr[l,lt-1] < v , arr[lt,gt-1] == v , arr[gt,r] > v

        // sort3ways
        sort3ways(arr, l, lt - 1, rnd);
        sort3ways(arr, gt, r, rnd);
    }

    private static <E> void swap(E[] arr, int i, int j) {

        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


}
