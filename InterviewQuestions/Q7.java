import java.util.Arrays;
import java.util.Comparator;

// Q7. Sort an Integer Array in Reverse Order.

public class Q7 {
    public static void main(String[] args) {

        // Sort an Integer Array in Reverse Order.

        Integer arr[] = { 33, 4, 22, 5, 22, 1, 4, 3 };

        Object result[] = Arrays.stream(arr).sorted(Comparator.reverseOrder()).toArray();

        System.out.println(Arrays.toString(result));

        // Sort an int Array in Reverse Order.
        int brr[] = { 33, 4, 22, 5, 22, 1, 4, 3 };

        Object result2[] = Arrays.stream(brr).boxed().sorted(Comparator.reverseOrder()).toArray();

        System.out.println(Arrays.toString(result2));
    }
}
