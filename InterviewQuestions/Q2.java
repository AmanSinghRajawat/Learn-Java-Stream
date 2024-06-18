import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// Print the Fequency of each character in String.

public class Q2 {
    public static void main(String[] args) {
        
        String str = "amansinghrajawat";

      Map<Character, Long> frequency =
            str.chars()
               .mapToObj(c -> (char)c)
               .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(frequency);

    }
}
