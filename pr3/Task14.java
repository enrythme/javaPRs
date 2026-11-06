package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task14 {
    // Задание 14. Определить пору года по номеру месяца.
    public static void main(String[] args) {
        System.out.println(season(1));
    }

    public static String season(int month) {
        if (month < 1 || month > 12) throw new IllegalArgumentException("Месяц должен быть от 1 до 12");
        if (month == 12 || month <= 2) return "зима";
        if (month <= 5) return "весна";
        if (month <= 8) return "лето";
        return "осень";
    }
}
