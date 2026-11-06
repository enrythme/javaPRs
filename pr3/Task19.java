package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task19 {
    // Задание 19. Найти позицию первого нуля в массиве.
    public static void main(String[] args) {
        System.out.println(firstZeroIndex(new int[]{1, 2, 3, 0, 4, 5}));
    }

    public static int firstZeroIndex(int[] values) { for (int i = 0; i < values.length; i++) if (values[i] == 0) return i; return -1; }
}
