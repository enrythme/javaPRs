package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task17 {
    // Задание 17. Определить регистр символа.
    public static void main(String[] args) {
        System.out.println(characterCase('a'));
    }

    public static String characterCase(char value) { if (Character.isUpperCase(value)) return "верхний"; if (Character.isLowerCase(value)) return "нижний"; return "не буква"; }
}
