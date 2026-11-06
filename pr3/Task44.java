package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task44 {
    // Задание 44. Удалить все значения массива, встречающиеся больше трёх раз.
    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeValuesOccurringMoreThanThreeTimes(new int[]{1, 2, 2, 2, 2, 3, 3, 3})));
    }

    public static int[] removeValuesOccurringMoreThanThreeTimes(int[] values) { return Arrays.stream(values).filter(value -> Arrays.stream(values).filter(other -> other == value).count() <= 3).toArray(); }
}
