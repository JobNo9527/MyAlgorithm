import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String[] arr = {"BCA", "CBAA", "AC", "BADFE", "ABC", "CBA"};
        MSDSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
