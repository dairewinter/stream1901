import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> stream = new ArrayList<>(Arrays.asList(100, 2, 3, 5, 8, 13, 21)).stream();

        findMinMax(
                stream,
                Integer::compareTo,
                (num1, num2) -> System.out.println(String.format("min: %s, max: %s", num1, num2))
        );

        evenNumbers();
    }


    public static <T> void findMinMax(Stream<T> stream,
                                      Comparator<T> order,
                                      BiConsumer<T, T> minMaxConsumer) {
        List<T> arrayList = new ArrayList<>();
        T min = null;
        T max = null;
        arrayList = stream
                .sorted(order)
                .collect(Collectors.toList());
        if (arrayList.size() != 0) {
            min = arrayList.get(0);
            max = arrayList.get(arrayList.size() - 1);
        }
        minMaxConsumer.accept(min, max);
    }

    public static void evenNumbers(){
        Stream<Integer> numStream = Stream.of(43, 62, 11, 90, 67, 84, 57);
        List<Integer> even = numStream.filter(n -> n % 2 == 0) .collect(Collectors.toList());
        System.out.println(even);
    }

}