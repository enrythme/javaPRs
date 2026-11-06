package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task42 {
    // Задание 42. Найти общие элементы двух массивов.
    public static void main(String[] args) {
        System.out.println(Arrays.toString(commonElements(new int[]{1, 2, 3, 4}, new int[]{2, 4, 6})));
    }

    public static int[] commonElements(int[] first, int[] second) { return Arrays.stream(first).distinct().filter(value -> Arrays.stream(second).anyMatch(other -> other == value)).toArray(); }
}
