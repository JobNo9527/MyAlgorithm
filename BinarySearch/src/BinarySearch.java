public class BinarySearch {

    private BinarySearch() {
    }

    // 递归实现，返回target对应索引
    public static <E extends Comparable<E>> int searchR(E[] data, E target) {
        return searchR(data, 0, data.length - 1, target);
    }

    private static <E extends Comparable<E>> int searchR(E[] data, int l, int r, E target) {

        if (l > r) return -1;
        int mid = l + (r - l) / 2;
        if (data[mid].compareTo(target) == 0)
            return mid;
        if (data[mid].compareTo(target) < 0)
            return searchR(data, mid + 1, r, target);
        return searchR(data, l, mid - 1, target);
    }

    // 非递归实现
    public static <E extends Comparable<E>> int search(E[] data, E target) {

        int l = 0, r = data.length - 1;

        // 在data[l,r] 的范围中查找 target
        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (data[mid].compareTo(target) == 0)
                return mid;

            if (data[mid].compareTo(target) < 0)
                l = mid + 1;
            else
                r = mid - 1;
        }

        return -1;
    }

    // 使用lower_ceil思路实现二分查找
    public static <E extends Comparable<E>> int search2(E[] data, E target) {

        int l = 0, r = data.length;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) < 0)
                l = mid + 1;
            else
                r = mid;
        }

        if (l < data.length && data[l].compareTo(target) == 0)
            return l;
        return -1;
    }


    // > target 的最小值索引
    public static <E extends Comparable<E>> int upper(E[] data, E target) {

        int l = 0, r = data.length;

        // 在data[l,r] 中寻找 比target大的最小值
        while (l < r) {

            // 下取整
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) <= 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;   //return r;也可以
    }

    /*
        0 2 2 4 4 6 6
                    没有比6 大的最小值，返回最大索引+1
     */
    // > target 返回最大值索引 用例子去理解
    // == target  返回最大索引
    public static <E extends Comparable<E>> int upper_ceil(E[] data, E target) {

        int u = upper(data, target);

        if (u - 1 >= 0 && data[u - 1].compareTo(target) == 0) {
            return u - 1;
        }
        return u;
    }

    public static <E extends Comparable<E>> int lower_ceil(E[] data, E target) {
        int l = 0, r = data.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) < 0)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    // < target 的最大值索引
    public static <E extends Comparable<E>> int lower(E[] data, E target) {
        int l = -1, r = data.length - 1;

        // 在data[l,r] 中寻找比target 小的最大值
        while (l < r) {
            //System.out.println(l + " " + r);  //找寻为什么出现死循环
            // 上取整
            int mid = l + (r - l + 1) / 2;

            if (data[mid].compareTo(target) < 0)
                l = mid;
            else
                r = mid - 1;
        }
        return l;
    }

    // < target 返回最大值索引
    // == target 返回最小索引
    public static <E extends Comparable<E>> int lower_floor(E[] data, E target) {

        int l = lower(data, target);

        if (l + 1 < data.length && data[l + 1].compareTo(target) == 0)
            return l + 1;
        return l;
    }

    // <= target的最大索引
    public static <E extends Comparable<E>> int upper_floor(E[] data, E target) {

        int l = -1, r = data.length - 1;

        while (l < r) {

            int mid = l + (r - l + 1) / 2;
            if (data[mid].compareTo(target) <= 0)
                l = mid;
            else
                r = mid - 1;
        }
        return l;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 1, 3, 3, 5, 5};

        System.out.print("lower: ");
        for (int i = 0; i <= 6; i++) {
            // > target的最小值所在索引
            System.out.print(BinarySearch.lower(arr, i) + " ");
        }

        System.out.println();

        System.out.print("lower_floor: ");
        for (int i = 0; i <= 6; i++) {
            System.out.print(BinarySearch.lower_floor(arr, i) + " ");
        }

        System.out.println();

        System.out.print("upper_floor: ");
        for (int i = 0; i <= 6; i++) {
            System.out.print(BinarySearch.upper_floor(arr, i) + " ");
        }
    }
}
