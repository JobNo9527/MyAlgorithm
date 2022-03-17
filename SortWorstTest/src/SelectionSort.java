/**

 * @author 将晖
 */


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

        /*
        //实现类比较，比较规则根据设计者设计类时设计的，我想让他成绩从小到大排，或者是从大到小排，都可以，不受sort方法影响，但仍然对排序有用，
        //分开了实现，更加好用且灵活
        Stu[] stus = {new Stu("A", 98),
                new Stu("bobo", 100),
                new Stu("Ayue9527", 1000)};
        SelectionSort.sort(stus);
        for (Stu stu : stus)
            System.out.println(stu + " ");
        System.out.println();
         */

        //基础模版
        /*
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort", arr);
        }
         */

        int n = 10000;
        Integer[] arr1 = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortTest("SelectionSort", arr1, n);

    }
}
