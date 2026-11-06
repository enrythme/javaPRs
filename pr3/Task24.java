package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task24 {
    // Задание 24. Получить из массива срез [3, 4, 5].
    public static void main(String[] args) {
        System.out.println(Arrays.toString(slice(new int[]{1, 2, 3, 4, 5, 6}, 2, 5)));
    }

    public static int[] slice(int[] values, int from, int to) { return Arrays.copyOfRange(values, from, to); }
}
