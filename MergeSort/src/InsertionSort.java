import java.util.Arrays;

/**
 * @author 将晖
 */


public class InsertionSort {

    private InsertionSort() {
    }

    //优化后的插入排序，减少了寻址次数（交换方法中知道），所以他是真正的插入排序，但没有改变时间复杂度O(n^2)，但进行了常数级别的优化
    public static <E extends Comparable<E>> void sort(E[] arr) {

        for (int i = 0; i < arr.length; i++) {

            //将 arr[i] 插入到合适的位置
            E temp = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && temp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    // 插入排序从l到r进行
    public static <E extends Comparable<E>> void sort(E[] arr,int l,int r) {

        for (int i = l; i < r; i++) {

            //将 arr[i] 插入到合适的位置
            E temp = arr[i];
            int j;
            for (j = i; j - 1 >= l && temp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    //从屁股开始插入排序
    public static <E extends Comparable<E>> void sort2(E[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {

            E temp = arr[i];
            int j;
            for (j = i; j + 1 < arr.length && temp.compareTo(arr[j + 1]) > 0; j++) {
                arr[j] = arr[j + 1];
            }
            arr[j] = temp;
        }

    }


    public static void main(String[] args) {

        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {

            System.out.println("Random Array : ");

            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);

            SortingHelper.sortTest("InsertionSort", arr);
            SortingHelper.sortTest("SelectionSort", arr2);

            System.out.println("-----------");

            System.out.println("Ordered Array : ");

            arr = ArrayGenerator.generateOrderedArray(n);
            arr2 = Arrays.copyOf(arr, arr.length);

            SortingHelper.sortTest("InsertionSort", arr);
            SortingHelper.sortTest("SelectionSort", arr2);

            System.out.println("-----------");
        }
    }
}
/*
Random Array :
InsertionSort , n = 10000 : 0.478299 s
SelectionSort , n = 10000 : 0.340065 s
-----------
Ordered Array :
InsertionSort , n = 10000 : 0.000194 s
SelectionSort , n = 10000 : 0.165713 s
-----------
Random Array :
InsertionSort , n = 100000 : 25.784325 s
SelectionSort , n = 100000 : 12.873388 s
-----------
Ordered Array :
InsertionSort , n = 100000 : 0.007524 s
SelectionSort , n = 100000 : 8.243095 s
-----------
 */
