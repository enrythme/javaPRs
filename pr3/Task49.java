package pr3;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class Task49 {
    // Задание 49. Проверить, можно ли переставить шесть цифр так, чтобы получился счастливый билет.
    public static void main(String[] args) {
        System.out.println(isLuckyTicket(new int[]{1, 2, 3, 0, 3, 3}));
    }

    public static boolean isLuckyTicket(int[] digits) { if (digits.length != 6) throw new IllegalArgumentException(); int total = 0; for (int digit : digits) total += digit; if (total % 2 != 0) return false; for (int a = 0; a < 4; a++) for (int b = a + 1; b < 5; b++) for (int c = b + 1; c < 6; c++) if (digits[a] + digits[b] + digits[c] == total / 2) return true; return false; }
}
