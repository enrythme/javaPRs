package pr4;

import java.util.Scanner;

public final class Main {
    private static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Textbook("Java для начинающих", "Иванов", 2022, "Программирование"));
        library.addBook(new Novel("Мастер и Маргарита", "Булгаков", 1967, "Роман"));
        library.addBook(new Textbook("Алгоритмы", "Петров", 2020, "Информатика"));
        Reader reader = new Reader("Анна Смирнова");
        library.addReader(reader);
        while (true) {
            System.out.println("1. Все книги  2. Поиск  3. Сортировка по году  4. Выдать  5. Вернуть  6. Книги читателя  0. Выход");
            int choice = readInt("Выбор: ");
            try {
                if (choice == 0) return;
                // Задание: показать все книги.
                if (choice == 1) library.printBooks();
                // Задание: найти книги по автору или названию.
                else if (choice == 2) library.search(readLine("Автор или название: "));
                // Задание: отсортировать книги по году издания.
                else if (choice == 3) library.printSorted();
                // Задание: выдать книгу читателю.
                else if (choice == 4) library.lend(readLine("Название книги: "), reader);
                // Задание: принять книгу обратно.
                else if (choice == 5) library.returnBook(readLine("Название книги: "), reader);
                // Задание: показать книги на руках у читателя.
                else if (choice == 6) reader.printBooks();
                else System.out.println("Нет такого пункта меню");
            } catch (LibraryException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try { return Integer.parseInt(INPUT.nextLine().trim()); }
            catch (NumberFormatException e) { System.out.println("Введите целое число"); }
        }
    }

    private static String readLine(String prompt) { System.out.print(prompt); return INPUT.nextLine().trim(); }
}
