import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// Q6. Three Max and Min Number from the List/Array.

public class Q6 {
    public static void main(String[] args) {


        // Three Max and Min Number from the Array.

        int arr[] = {4,8,2,1,9,3,23,11,66,81};

        // Three Max Numbers.
        Object max[] = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).limit(3).toArray();

        System.out.println(Arrays.toString(max));

        // Three Min Numbers.
        int min[] = Arrays.stream(arr).sorted().limit(3).toArray();
        System.out.println(Arrays.toString(min));



        // Three Max and Min Number from the List.

        List<Integer> list = new ArrayList<Integer>(Arrays.asList(4,8,2,1,9,3,23,11,66,81));

        // Three Max Numbers.
        List maxList = list.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());

        System.out.println(maxList);

        // Three Min Numbers.
        List minList = list.stream().sorted().limit(3).collect(Collectors.toList());

        System.out.println(minList);        
    }
}
