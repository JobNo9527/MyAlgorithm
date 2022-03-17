import java.util.Arrays;

public class MergeSort {

    private MergeSort() {
    }

    // Better Merge 自顶向下的归并排序
    public static <E extends Comparable<E>> void sort(E[] arr) {

        E[] temp = Arrays.copyOf(arr, arr.length);
        sort(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, E[] temp) {

        //递归终点
        if (l >= r) return;
        //if (r - l <= 15) {
        //    //规模小的乱序数组中，使用插入排序优于归并排序（优化思路仅需了解，，在某些其他语言中，可能这么做会有增加时耗，降低性能）
        //    InsertionSort.sort(arr, l, r);
        //    return;
        //}


        int mid = l + (r - l) / 2;
        sort(arr, l, mid, temp);
        sort(arr, mid + 1, r, temp);
        if (arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l, mid, r, temp);
    }

    // 自底向上的归并排序
    public static <E extends Comparable<E>> void sortBU(E[] arr) {

        E[] temp = Arrays.copyOf(arr, arr.length);

        int n = arr.length;

        // 遍历合并的区间长度
        for (int sz = 1; sz < n; sz += sz) {

            // 遍历合并的两个区间的起始位置i
            // 合并 [i, i + sz - 1] 和 [i + sz, Math.min(i + sz + sz - 1, n - 1)]
            for (int i = 0; i + sz < n; i += sz + sz) {

                // 有时候，如果有新的已有序数组传入，最右边的索引可能会越界，
                // 1, 2, 3, 4, 5, 6, 7, 8,| 0, 9 -> 如果未加最右侧这样一个数学判断，我们要比较的是 [ 0, 7 ] 和 [ 8 , 15(8 + 8 - 1) ]
                // -> 对左右两个已有序数组进行归并，右边的数组边界会是 [ 8 , 15 ] ,而实际上是 [ 8 , 9 ]
                // 因此加个判断 ， 取 最小 的即可，i + sz + sz - 1的情况自行想象一个相同长度的有序子数组传入并进行归并思考即可
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0)
                    merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1), temp);
            }
        }
    }

    // 自底向上的归并排序，InsertionSort 的不稳定优化
    public static <E extends Comparable<E>> void sortBUInsertion(E[] arr) {

        E[] temp = Arrays.copyOf(arr, arr.length);

        int n = arr.length;

        // 不稳定优化
        // 遍历一遍，对所有arr[i,i+15]的区间，使用插入排序法
        for (int i = 0; i < n; i += 16) {
            InsertionSort.sort(arr, i, Math.min(n - 1, i + 15));
        }

        // 遍历合并的区间长度
        for (int sz = 16; sz < n; sz += sz) {

            // 遍历合并的两个区间的起始位置i
            // 合并 [i, i + sz - 1] 和 [i + sz, Math.min(i + sz + sz - 1, n - 1)]
            for (int i = 0; i + sz < n; i += sz + sz) {

                // 有时候，如果有新的已有序数组传入，最右边的索引可能会越界，
                // 1, 2, 3, 4, 5, 6, 7, 8,| 0, 9 -> 如果未加最右侧这样一个数学判断，我们要比较的是 [ 0, 7 ] 和 [ 8 , 15(8 + 8 - 1) ]
                // -> 对左右两个已有序数组进行归并，右边的数组边界会是 [ 8 , 15 ] ,而实际上是 [ 8 , 9 ]
                // 因此加个判断 ， 取 最小 的即可，i + sz + sz - 1的情况自行想象一个相同长度的有序子数组传入并进行归并思考即可
                if (arr[i + sz - 1].compareTo(arr[i + sz]) > 0)
                    merge(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1), temp);
            }
        }
    }


    //合并两个有序的区间arr[l, mid]和arr[mid + 1, r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp) {

        //E[] temp = Arrays.copyOfRange(arr, l, r + 1);//为什么r+1，是因为该方法 复制的数组是前闭后开的，而且temp最初的索引位不是了，而是0
        System.arraycopy(arr, l, temp, l, r - l + 1);   //temp也已经从l开始了

        int i = l, j = mid + 1;

        // 每轮循环为 arr[k] 赋值
        for (int k = l; k <= r; k++) {

            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {

        int n = 10000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        //Integer[] arr3 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("MergeSortBU", arr2);
        //SortingHelper.sortTest("MergeSortBUInsertion", arr3);
    }
}
/*
    刘宇波老师的观点
        JVM的一些底层的优化，使得递归的算法耗时会比迭代的算法耗时会少，很好的印证了SortWorstTest的奇怪现象
 */
