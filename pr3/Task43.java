package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task43 {
    private static final Random RANDOM = new Random();
    private static int previousRandom = Integer.MIN_VALUE;

    // Задание 43. Вернуть случайное число, которое не совпадает с предыдущим.
    public static void main(String[] args) {
        System.out.println(randomNumberDifferentFromPrevious(1, 10));
    }

    public static int randomNumberDifferentFromPrevious(int min, int max) { if (min > max) throw new IllegalArgumentException(); if (min == max) return min; int value; do value = RANDOM.nextInt(max - min + 1) + min; while (value == previousRandom); previousRandom = value; return value; }
}
