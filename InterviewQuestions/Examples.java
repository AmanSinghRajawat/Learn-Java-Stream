import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Examples{
    public static void main(String[] args) {


        int arr[] = {1,2,3,4,5,6};

        // Q. Seprate the Odd and Even numbers.

        List<Integer> list = Arrays.asList(1,2,5,4,5,3);

        List<Integer> odd = list.stream().filter(n -> n%2 != 0).collect(Collectors.toList());
        
        List<Integer> even = list.stream().filter(n -> n%2 == 0).collect(Collectors.toList());
                
        Map<Boolean, List<Integer>> map = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(n -> n%2==0));

List<List<Integer>> list1 = new ArrayList<>();
List<List<Integer>> list2 = new ArrayList<>();

for(boolean key : map.keySet()){
    if(key) list1.add(map.get(key));
    else list2.add(map.get(key));
}


System.out.println(list1+" : "+list2);
        System.out.println(odd+" : "+even);
        System.out.println(map);

    }
}