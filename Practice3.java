import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Practice3 {
    private static final Random RANDOM = new Random();
    private static int previousRandom = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Задание 1. Проверить, отрицательное ли число.
        System.out.println(isNegative(-7));
        // Задание 2. Вывести длину строки.
        System.out.println("length=" + "hello".length());
        // Задание 3. Вывести последний символ строки.
        System.out.println(lastCharacter("hello"));
        // Задание 4. Проверить, чётное ли число.
        System.out.println(isEven(8));
        // Задание 5. Сравнить первые буквы двух слов.
        System.out.println(firstLettersEqual("apple", "apricot"));
        // Задание 6. Вывести первую цифру числа.
        System.out.println(firstDigit(-735));
        // Задание 7. Вывести последнюю цифру числа.
        System.out.println(lastDigit(-735));
        // Задание 8. Найти сумму первой и последней цифр.
        System.out.println(firstAndLastDigitSum(-735));
        // Задание 9. Посчитать цифры в числе.
        System.out.println(digitCount(Long.MIN_VALUE));
        // Задание 10. Сравнить первые цифры двух чисел.
        System.out.println(firstDigitsEqual(123, 987));
        // Задание 11. Вывести целые числа от 1 до 100.
        printOneToHundred();
        // Задание 12. Вывести предпоследний символ строки.
        System.out.println(penultimateCharacter("hello"));
        // Задание 13. Найти остаток от деления.
        System.out.println(remainder(17, 5));
        // Задание 14. Определить пору года по номеру месяца.
        System.out.println(season(1));
        // Задание 15. Вывести элементы массива, делящиеся на 5.
        printDivisibleByFive(new int[]{2, 5, 10, 13, 20});
        // Задание 16. Получить первые три символа строки.
        System.out.println(firstThree("abcdef"));
        // Задание 17. Определить регистр символа.
        System.out.println(characterCase('a'));
        // Задание 18. Получить первые три элемента массива.
        System.out.println(Arrays.toString(slice(new int[]{1, 2, 3, 4, 5, 6}, 0, 3)));
        // Задание 19. Найти позицию первого нуля в массиве.
        System.out.println(firstZeroIndex(new int[]{1, 2, 3, 0, 4, 5}));
        // Задание 20. Заменить дефисы в строке пробелами.
        System.out.println("123-456-789".replace('-', ' '));
        // Задание 21. Вывести строки, начинающиеся с http://.
        printHttpUrls(new String[]{"http://example.com", "https://example.com", "http://site.test"});
        // Задание 22. Найти позицию первого нуля в строке.
        System.out.println("1203405".indexOf('0'));
        // Задание 23. Получить последние три символа строки.
        System.out.println(lastThree("abcdef"));
        // Задание 24. Получить срез массива [3, 4, 5].
        System.out.println(Arrays.toString(slice(new int[]{1, 2, 3, 4, 5, 6}, 2, 5)));
        // Задание 25. Разбить строку на слова.
        System.out.println(Arrays.toString("abc def jhi".split("\\s+")));
        // Задание 26. Считать два числа и вывести их сумму.
        System.out.print("Введите два числа: ");
        if (scanner.hasNextLong()) {
            long a = scanner.nextLong();
            if (scanner.hasNextLong()) System.out.println(a + scanner.nextLong());
        }
        // Задание 27. Проверить наличие одинаковых цифр.
        System.out.println(hasRepeatedDigits(133));
        // Задание 28. Вывести все элементы двумерного массива.
        printMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        // Задание 29. Вывести строку из пятнадцати символов x.
        System.out.println("x".repeat(15));
        // Задание 30. Проверить, состоит ли строка только из цифр.
        System.out.println(isIntegerString("12345"));
        // Задание 31. Проверить, является ли строка дробным числом.
        System.out.println(isDecimalString("-12.75"));
        // Задание 32. Найти второе по величине число массива.
        System.out.println(secondLargest(new int[]{9, 3, 7, 9, 5}));
        // Задание 33. Создать диапазон между двумя числами.
        System.out.println(Arrays.toString(range(4, 8)));
        // Задание 34. Заполнить массив случайными латинскими буквами.
        System.out.println(Arrays.toString(randomLetters(10)));
        // Задание 35. Найти сумму N первых чисел Фибоначчи.
        System.out.println(fibonacciSum(10));
        // Задание 36. Проверить существование даты.
        System.out.println(isValidDate("2024-02-29"));
        // Задание 37. Перевести секунды в целое количество суток.
        System.out.println(secondsToDays(172800));
        // Задание 38. Создать строку случайных латинских букв.
        System.out.println(randomString(12));
        // Задание 39. Составить строку из первых букв слов.
        System.out.println(initials("john ronald reuel tolkien"));
        // Задание 40. Заменить числа массивами их делителей.
        System.out.println(Arrays.deepToString(divisorsForEach(new int[]{6, 10, 13})));
        // Задание 41. Отсортировать слова по алфавиту.
        System.out.println(sortWords("pear apple orange"));
        // Задание 42. Найти общие элементы двух массивов.
        System.out.println(Arrays.toString(commonElements(new int[]{1, 2, 3, 4}, new int[]{2, 4, 6})));
        // Задание 43. Получить случайное число без повтора подряд.
        System.out.println(randomNumberDifferentFromPrevious(1, 10));
        // Задание 44. Удалить числа, встречающиеся больше трёх раз.
        System.out.println(Arrays.toString(removeValuesOccurringMoreThanThreeTimes(new int[]{1, 2, 2, 2, 2, 3, 3, 3})));
        // Задание 45. Найти самое длинное слово.
        System.out.println(longestWord("Java programming practice"));
        // Задание 46. Найти даты текущего столетия с четырьмя цифрами 2.
        System.out.println(datesWithFourTwosInCurrentCentury());
        // Задание 47. Посчитать пятницы 13-го в текущем году.
        System.out.println(fridayThirteenths(Year.now().getValue()));
        // Задание 48. Проверить, можно ли переставить цифры для счастливого билета.
        System.out.println(isLuckyTicket(new int[]{1, 2, 3, 0, 3, 3}));
        // Задание 49. Выбрать случайное слово на заданную букву.
        System.out.println(randomWordStartingWith(new String[]{"apple", "apricot", "banana"}, 'a'));
        // Задание 50. Образовать множественное число английского существительного.
        System.out.println(pluralizeEnglish("city"));
        // Задание 51. Найти пары дружественных чисел в диапазоне.
        System.out.println(amicablePairs(1, 10000));
        // Задание 52. Разложить число на простые множители.
        System.out.println(primeFactorization(360));
        int[][] matrix = {{11, 12, 13, 14, 15}, {21, 22, 23, 24, 25}, {31, 32, 33, 34, 35}, {41, 42, 43, 44, 45}, {51, 52, 53, 54, 55}};
        // Задание 53. Обнулить главную диагональ матрицы.
        zeroMainDiagonal(matrix);
        printMatrix(matrix);
        // Задание 54. Выбрать правильную форму существительного после числа.
        System.out.println(nounWithNumber(1223421, "яблоко", "яблока", "яблок"));
    }

    // Задание: Проверка отрицательности числа.
    public static boolean isNegative(long number) { return number < 0; }
    // Задание: Последний символ строки.
    public static char lastCharacter(String value) { return value.charAt(value.length() - 1); }
    // Задание: Проверка чётности.
    public static boolean isEven(long number) { return number % 2 == 0; }
    // Задание: Сравнение первых букв двух слов.
    public static boolean firstLettersEqual(String first, String second) { return !first.isEmpty() && !second.isEmpty() && Character.toLowerCase(first.charAt(0)) == Character.toLowerCase(second.charAt(0)); }
    // Задание: Первая цифра числа.
    public static int firstDigit(long number) { return (int) (Long.toString(number).replace("-", "").charAt(0) - '0'); }
    // Задание: Последняя цифра числа.
    public static int lastDigit(long number) { return (int) (Math.abs(number % 10)); }
    // Задание: Сумма первой и последней цифр.
    public static int firstAndLastDigitSum(long number) { return firstDigit(number) + lastDigit(number); }
    // Задание: Количество цифр числа.
    public static int digitCount(long number) { return Long.toString(number).replace("-", "").length(); }
    // Задание: Сравнение первых цифр двух чисел.
    public static boolean firstDigitsEqual(long first, long second) { return firstDigit(first) == firstDigit(second); }
    // Задание: Вывод чисел от 1 до 100.
    public static void printOneToHundred() { for (int i = 1; i <= 100; i++) System.out.print(i + (i == 100 ? "\n" : " ")); }
    // Задание: Предпоследний символ строки.
    public static Character penultimateCharacter(String value) { return value.length() > 1 ? value.charAt(value.length() - 2) : null; }
    // Задание: Остаток от деления.
    public static long remainder(long first, long second) { return first % second; }
    // Задание: Определение поры года.
    public static String season(int month) {
        if (month < 1 || month > 12) throw new IllegalArgumentException("Месяц должен быть от 1 до 12");
        if (month == 12 || month <= 2) return "зима";
        if (month <= 5) return "весна";
        if (month <= 8) return "лето";
        return "осень";
    }
    // Задание: Вывод элементов, делящихся на 5.
    public static void printDivisibleByFive(int[] values) { for (int value : values) if (value % 5 == 0) System.out.print(value + " "); System.out.println(); }
    // Задание: Первые три символа строки.
    public static String firstThree(String value) { return value.substring(0, Math.min(3, value.length())); }
    // Задание: Определение регистра символа.
    public static String characterCase(char value) { if (Character.isUpperCase(value)) return "верхний"; if (Character.isLowerCase(value)) return "нижний"; return "не буква"; }
    // Задание: Срез массива.
    public static int[] slice(int[] values, int from, int to) { return Arrays.copyOfRange(values, from, to); }
    // Задание: Позиция первого нуля в массиве.
    public static int firstZeroIndex(int[] values) { for (int i = 0; i < values.length; i++) if (values[i] == 0) return i; return -1; }
    // Задание: Строки, начинающиеся с http://.
    public static void printHttpUrls(String[] values) { for (String value : values) if (value.startsWith("http://")) System.out.println(value); }
    // Задание: Последние три символа строки.
    public static String lastThree(String value) { return value.substring(Math.max(0, value.length() - 3)); }
    // Задание: Вывод элементов двумерного массива.
    public static void printMatrix(int[][] matrix) { for (int[] row : matrix) for (int value : row) System.out.print(value + " "); System.out.println(); }
    // Задание: Проверка одинаковых цифр в числе.
    public static boolean hasRepeatedDigits(long number) { String digits = Long.toString(number).replace("-", ""); return digits.chars().distinct().count() < digits.length(); }
    // Задание: Проверка строки на целое число из цифр.
    public static boolean isIntegerString(String value) { return value != null && value.matches("\\d+"); }
    // Задание: Проверка строки на дробное число.
    public static boolean isDecimalString(String value) { return value != null && value.matches("[+-]?\\d+[.,]\\d+"); }
    // Задание: Второе по величине число массива.
    public static int secondLargest(int[] values) { return Arrays.stream(values).distinct().boxed().sorted((a, b) -> Integer.compare(b, a)).skip(1).findFirst().orElseThrow(() -> new IllegalArgumentException("Нет второго по величине числа")); }
    // Задание: Массив целых чисел между границами.
    public static int[] range(int first, int second) { int min = Math.min(first, second), max = Math.max(first, second); int[] result = new int[max - min + 1]; for (int i = 0; i < result.length; i++) result[i] = min + i; return result; }
    // Задание: Массив случайных латинских букв.
    public static char[] randomLetters(int length) { if (length < 0) throw new IllegalArgumentException(); char[] result = new char[length]; for (int i = 0; i < length; i++) result[i] = (char) ('a' + RANDOM.nextInt(26)); return result; }
    // Задание: Сумма первых N чисел Фибоначчи.
    public static long fibonacciSum(int n) { if (n < 0) throw new IllegalArgumentException(); long sum = 0, previous = 0, current = 1; for (int i = 0; i < n; i++) { sum += previous; long next = previous + current; previous = current; current = next; } return sum; }
    // Задание: Проверка даты формата год-месяц-день.
    public static boolean isValidDate(String value) { try { LocalDate.parse(value); return true; } catch (DateTimeException e) { return false; } }
    // Задание: Количество суток в секундах.
    public static long secondsToDays(long seconds) { return seconds / 86400; }
    // Задание: Строка случайных латинских букв.
    public static String randomString(int length) { return new String(randomLetters(length)); }
    // Задание: Первые буквы слов в верхнем регистре.
    public static String initials(String value) { StringBuilder result = new StringBuilder(); for (String word : value.trim().split("\\s+")) if (!word.isEmpty()) result.append(Character.toUpperCase(word.charAt(0))); return result.toString(); }
    // Задание: Массивы делителей для чисел.
    public static int[][] divisorsForEach(int[] values) { int[][] result = new int[values.length][]; for (int i = 0; i < values.length; i++) { int count = 0; for (int d = 1; d <= Math.abs(values[i]); d++) if (values[i] != 0 && values[i] % d == 0) count++; result[i] = new int[count]; int index = 0; for (int d = 1; d <= Math.abs(values[i]); d++) if (values[i] != 0 && values[i] % d == 0) result[i][index++] = d; } return result; }
    // Задание: Сортировка слов по алфавиту.
    public static String sortWords(String text) { String[] words = text.trim().split("\\s+"); Arrays.sort(words, String.CASE_INSENSITIVE_ORDER); return String.join(" ", words); }
    // Задание: Общие элементы двух массивов.
    public static int[] commonElements(int[] first, int[] second) { return Arrays.stream(first).distinct().filter(value -> Arrays.stream(second).anyMatch(other -> other == value)).toArray(); }
    // Задание: Случайное число без повтора подряд.
    public static int randomNumberDifferentFromPrevious(int min, int max) { if (min > max) throw new IllegalArgumentException(); if (min == max) return min; int value; do value = RANDOM.nextInt(max - min + 1) + min; while (value == previousRandom); previousRandom = value; return value; }
    // Задание: Удаление значений, встречающихся больше трёх раз.
    public static int[] removeValuesOccurringMoreThanThreeTimes(int[] values) { return Arrays.stream(values).filter(value -> Arrays.stream(values).filter(other -> other == value).count() <= 3).toArray(); }
    // Задание: Самое длинное слово строки.
    public static String longestWord(String text) { return Arrays.stream(text.trim().split("\\s+")).max((a, b) -> Integer.compare(a.length(), b.length())).orElse(""); }
    // Задание: Даты с четырьмя цифрами 2 в текущем столетии.
    public static String datesWithFourTwosInCurrentCentury() { StringBuilder result = new StringBuilder(); for (LocalDate date = LocalDate.of(2001, 1, 1); date.getYear() <= 2100; date = date.plusDays(1)) { String formatted = date.format(java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy")); long count = formatted.chars().filter(c -> c == '2').count(); if (count == 4) result.append(formatted).append(System.lineSeparator()); } return result.toString().trim(); }
    // Задание: Количество пятниц 13-го за год.
    public static int fridayThirteenths(int year) { int count = 0; for (int month = 1; month <= 12; month++) if (LocalDate.of(year, month, 13).getDayOfWeek().getValue() == 5) count++; return count; }
    // Задание: Проверка возможности собрать счастливый билет из цифр.
    public static boolean isLuckyTicket(int[] digits) { if (digits.length != 6) throw new IllegalArgumentException(); int total = 0; for (int digit : digits) total += digit; if (total % 2 != 0) return false; for (int a = 0; a < 4; a++) for (int b = a + 1; b < 5; b++) for (int c = b + 1; c < 6; c++) if (digits[a] + digits[b] + digits[c] == total / 2) return true; return false; }
    // Задание: Случайное слово на заданную букву.
    public static String randomWordStartingWith(String[] words, char letter) { String[] matches = Arrays.stream(words).filter(word -> !word.isEmpty() && Character.toLowerCase(word.charAt(0)) == Character.toLowerCase(letter)).toArray(String[]::new); return matches.length == 0 ? null : matches[RANDOM.nextInt(matches.length)]; }
    // Задание: Множественное число английского существительного.
    public static String pluralizeEnglish(String noun) { String lower = noun.toLowerCase(Locale.ROOT); if (lower.endsWith("y") && noun.length() > 1 && !"aeiou".contains(lower.substring(lower.length() - 2, lower.length() - 1))) return noun.substring(0, noun.length() - 1) + "ies"; if (lower.endsWith("s") || lower.endsWith("x") || lower.endsWith("z") || lower.endsWith("ch") || lower.endsWith("sh")) return noun + "es"; return noun + "s"; }
    // Задание: Пары дружественных чисел в заданном промежутке.
    public static String amicablePairs(int min, int max) { StringBuilder result = new StringBuilder(); for (int a = Math.max(2, min); a <= max; a++) { int b = properDivisorSum(a); if (b > a && b <= max && properDivisorSum(b) == a) result.append(a).append("-").append(b).append(' '); } return result.toString().trim(); }
    private static int properDivisorSum(int number) { int sum = 1; for (int i = 2; i <= number / i; i++) if (number % i == 0) sum += i + (i != number / i ? number / i : 0); return number == 1 ? 0 : sum; }
    // Задание: Разложение числа на простые множители.
    public static String primeFactorization(int number) { if (number < 2) throw new IllegalArgumentException(); StringBuilder result = new StringBuilder(number + " = "); int remaining = number; for (int divisor = 2; divisor <= remaining / divisor; divisor++) while (remaining % divisor == 0) { result.append(divisor).append(" × "); remaining /= divisor; } result.append(remaining); return result.toString(); }
    // Задание: Обнуление главной диагонали матрицы.
    public static void zeroMainDiagonal(int[][] matrix) { for (int i = 0; i < Math.min(matrix.length, matrix[0].length); i++) matrix[i][i] = 0; }
    // Задание: Форма существительного после числа.
    public static String nounWithNumber(long number, String one, String few, String many) { long lastTwo = Math.abs(number) % 100; if (lastTwo >= 11 && lastTwo <= 14) return number + " " + many; int last = (int) (Math.abs(number) % 10); String form = last == 1 ? one : last >= 2 && last <= 4 ? few : many; return number + " " + form; }
}
