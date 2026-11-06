package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task32 {
    // Задание 32. Найти второе по величине число массива.
    public static void main(String[] args) {
        System.out.println(secondLargest(new int[]{9, 3, 7, 9, 5}));
    }

    public static int secondLargest(int[] values) { return Arrays.stream(values).distinct().boxed().sorted((a, b) -> Integer.compare(b, a)).skip(1).findFirst().orElseThrow(() -> new IllegalArgumentException("Нет второго по величине числа")); }
}
