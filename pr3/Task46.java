package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task46 {
    // Задание 46. Найти даты текущего столетия с четырьмя цифрами 2.
    public static void main(String[] args) {
        System.out.println(datesWithFourTwosInCurrentCentury());
    }

    public static String datesWithFourTwosInCurrentCentury() { StringBuilder result = new StringBuilder(); for (LocalDate date = LocalDate.of(2001, 1, 1); date.getYear() <= 2100; date = date.plusDays(1)) { String formatted = date.format(java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy")); long count = formatted.chars().filter(c -> c == '2').count(); if (count == 4) result.append(formatted).append(System.lineSeparator()); } return result.toString().trim(); }
}
