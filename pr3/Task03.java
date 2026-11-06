package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task03 {
    // Задание 3. Вывести последний символ строки.
    public static void main(String[] args) {
        System.out.println(lastCharacter("hello"));
    }

    public static char lastCharacter(String value) { return value.charAt(value.length() - 1); }
}
