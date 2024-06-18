import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Q4. Merge to Unsorted Array into Signle Sorted Array.

public class Q4 {
    public static void main(String[] args) {

        int arr[] = { 7, 2, 1, 3, 5 };
        int brr[] = { 9, 4, 7, 5, 11, 6, 1};

        int result[] = IntStream.concat(Arrays.stream(arr), Arrays.stream(brr)).sorted().toArray();

        System.out.println(Arrays.toString(result));

    }
}
