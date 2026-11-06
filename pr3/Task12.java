package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task12 {
    // Задание 12. Вывести предпоследний символ строки, если он есть.
    public static void main(String[] args) {
        System.out.println(penultimateCharacter("hello"));
    }

    public static Character penultimateCharacter(String value) { return value.length() > 1 ? value.charAt(value.length() - 2) : null; }
}
