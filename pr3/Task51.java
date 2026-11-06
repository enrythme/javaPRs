package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task51 {
    // Задание 51. Образовать множественное число английского существительного.
    public static void main(String[] args) {
        System.out.println(pluralizeEnglish("city"));
    }

    public static String pluralizeEnglish(String noun) { String lower = noun.toLowerCase(Locale.ROOT); if (lower.endsWith("y") && noun.length() > 1 && !"aeiou".contains(lower.substring(lower.length() - 2, lower.length() - 1))) return noun.substring(0, noun.length() - 1) + "ies"; if (lower.endsWith("s") || lower.endsWith("x") || lower.endsWith("z") || lower.endsWith("ch") || lower.endsWith("sh")) return noun + "es"; return noun + "s"; }
}
