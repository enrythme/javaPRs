package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task21 {
    // Задание 21. Вывести строки, которые начинаются на http://.
    public static void main(String[] args) {
        printHttpUrls(new String[]{"http://example.com", "https://example.com", "http://site.test"});
    }

    public static void printHttpUrls(String[] values) { for (String value : values) if (value.startsWith("http://")) System.out.println(value); }
}
