package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task37 {
    // Задание 37. Перевести секунды в целое количество суток.
    public static void main(String[] args) {
        System.out.println(secondsToDays(172800));
    }

    public static long secondsToDays(long seconds) { return seconds / 86400; }
}
