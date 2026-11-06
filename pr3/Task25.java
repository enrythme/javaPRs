package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task25 {
    // Задание 25. Разбить строку на массив слов.
    public static void main(String[] args) {
        System.out.println(Arrays.toString("abc def jhi".split("\\s+")));
    }
}
