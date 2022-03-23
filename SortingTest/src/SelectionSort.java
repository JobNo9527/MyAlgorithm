public class SelectionSort {

    private SelectionSort() {
    }

    //E这个类型（泛形）实现comparable接口，这样的话可以用于比较
    public static <E extends Comparable<E>> void sort(E[] arr) {

        for (int i = 0; i < arr.length; i++) {

            //选择arr[i..n)中的最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }

            swap(arr, i, minIndex);
        }
    }

    //交换
    private static <E> void swap(E[] arr, int i, int j) {

        //泛形
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort", arr);
        }
    }
}
