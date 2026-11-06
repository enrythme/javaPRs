package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task36 {
    // Задание 36. Проверить, существует ли дата формата год-месяц-день.
    public static void main(String[] args) {
        System.out.println(isValidDate("2024-02-29"));
    }

    public static boolean isValidDate(String value) { try { LocalDate.parse(value); return true; } catch (DateTimeException e) { return false; } }
}
