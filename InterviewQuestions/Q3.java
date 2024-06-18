import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Sort the List in Reverse Order.

public class Q3 {
    public static void main(String[] args) {

        String arr[] = { "zean", "rahul", "vicky", "sameer", "aman" };

        System.out.println("Before Sorting : "+Arrays.toString(arr));

        // Sort in Reverse Order.
        List reverseOrder = Arrays.asList(arr).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(reverseOrder);

        // Sort in Natural Ordering.
        List ans = Arrays.stream(arr).sorted().collect(Collectors.toList());
        System.out.println(ans);
    }
}
