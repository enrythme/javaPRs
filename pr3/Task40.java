package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task40 {
    // Задание 40. Заменить каждое число массивом его делителей.
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(divisorsForEach(new int[]{6, 10, 13})));
    }

    public static int[][] divisorsForEach(int[] values) { int[][] result = new int[values.length][]; for (int i = 0; i < values.length; i++) { int count = 0; for (int d = 1; d <= Math.abs(values[i]); d++) if (values[i] != 0 && values[i] % d == 0) count++; result[i] = new int[count]; int index = 0; for (int d = 1; d <= Math.abs(values[i]); d++) if (values[i] != 0 && values[i] % d == 0) result[i][index++] = d; } return result; }
}
