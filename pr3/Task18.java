package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task18 {
    // Задание 18. Получить первые три элемента массива.
    public static void main(String[] args) {
        System.out.println(Arrays.toString(slice(new int[]{1, 2, 3, 4, 5, 6}, 0, 3)));
    }

    public static int[] slice(int[] values, int from, int to) { return Arrays.copyOfRange(values, from, to); }
}
