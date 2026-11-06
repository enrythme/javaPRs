package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task47 {
    // Задание 47. Посчитать пятницы 13-го в текущем году.
    public static void main(String[] args) {
        System.out.println(fridayThirteenths(Year.now().getValue()));
    }

    public static int fridayThirteenths(int year) { int count = 0; for (int month = 1; month <= 12; month++) if (LocalDate.of(year, month, 13).getDayOfWeek().getValue() == 5) count++; return count; }
}
