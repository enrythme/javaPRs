package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task33 {
    // Задание 33. Создать массив целых чисел от меньшего параметра до большего.
    public static void main(String[] args) {
        System.out.println(Arrays.toString(range(4, 8)));
    }

    public static int[] range(int first, int second) { int min = Math.min(first, second), max = Math.max(first, second); int[] result = new int[max - min + 1]; for (int i = 0; i < result.length; i++) result[i] = min + i; return result; }
}
