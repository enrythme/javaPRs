package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task50 {
    private static final Random RANDOM = new Random();

    // Задание 50. Получить случайное слово массива, начинающееся на заданную букву.
    public static void main(String[] args) {
        System.out.println(randomWordStartingWith(new String[]{"apple", "apricot", "banana"}, 'a'));
    }

    public static String randomWordStartingWith(String[] words, char letter) { String[] matches = Arrays.stream(words).filter(word -> !word.isEmpty() && Character.toLowerCase(word.charAt(0)) == Character.toLowerCase(letter)).toArray(String[]::new); return matches.length == 0 ? null : matches[RANDOM.nextInt(matches.length)]; }
}
