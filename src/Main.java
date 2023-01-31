import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> arr = new ArrayList<>(Arrays.asList(45, 56, 585, 452, 785, 45, 78, 96)).stream();
        findMinMax(
                arr,
                Comparator.naturalOrder(),
                (e, s) -> System.out.println(String.format("min: " + e + " max: " + s))
        );

        listOfEvenNumbers(85, 5, 5, 45, 544, 54, 45, 445, 54);
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> arrayList = new ArrayList<>();
        T min = null;
        T max = null;
        arrayList = stream
                .sorted(order)
                .collect(Collectors.toList());
        if (arrayList.size() != 0) {
            min = arrayList.get(0);
            max = arrayList.get(arrayList.size() - 1);
            minMaxConsumer.accept(min, max);
            if (min == null && max == null) {
                minMaxConsumer.accept(null, null);
            }
        }
    }

    public static void listOfEvenNumbers(Integer... integers) {
        ArrayList<Integer> enumeration = new ArrayList<>(List.of(integers));
        List<Integer> enumer = enumeration.stream()
                .filter(e -> (e % 2 == 0))
                .toList();
        System.out.println("Количество четных: " + enumer.size());
    }
}