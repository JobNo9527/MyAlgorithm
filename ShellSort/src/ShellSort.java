public class ShellSort {

    private ShellSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] data) {

        int h = data.length / 2;
        // 分割
        while (h >= 1) {
            // 每个子数组混着处理，只看对应子数组的前一个元素 , 插入排序默认第一个元素就是有序
            // 对 data[start , start+h , start+2h , start+3h , ... ] 进行 插入排序  , 每一个子数组的间距是h
            for (int i = h; i < data.length; i++) {

                E t = data[i];
                int j;
                for (j = i; j - h >= 0 && t.compareTo(data[j - h]) < 0; j -= h)
                    data[j] = data[j - h];
                data[j] = t;
            }
            h /= 2;
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] data) {

        int h = 1;
        while (h < data.length) h = h * 3 + 1;
        // 1, 4, 13, 40 ...

        // 分割
        while (h >= 1) {
            // 每个子数组混着处理，只看对应子数组的前一个元素 , 插入排序默认第一个元素就是有序
            // 对 data[start , start+h , start+2h , start+3h , ... ] 进行 插入排序  , 每一个子数组的间距是h
            for (int i = h; i < data.length; i++) {

                E t = data[i];
                int j;
                for (j = i; j - h >= 0 && t.compareTo(data[j - h]) < 0; j -= h)
                    data[j] = data[j - h];
                data[j] = t;
            }
            h /= 3;
            // 1, 4, 13, 40 ...
            //  <-  <-  <-
        }
    }
}
