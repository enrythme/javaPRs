package pr5;

import java.util.Scanner;

public final class Main {
    private static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        Library library = new Library();
        try {
            library.addPublication(new Book("B-100", "Java: основы", 2022, "Иванов"));
            library.addPublication(new Magazine("M-200", "Мир науки", 2024, "Редакция"));
            library.addPublication(new Dissertation("D-300", "Исследование алгоритмов", 2021, "Петров"));
            library.addReader(new Reader("R-1", "Анна Смирнова"));
            library.addReader(new Reader("R-2", "Иван Петров"));
        } catch (LibraryException e) {
            System.out.println(e.getMessage());
        }

        while (true) {
            System.out.println("1. Издания  2. Читатели  3. Выдать  4. Вернуть  5. Продлить  6. Поиск  7. Сортировка  8. Должники  9. История  10. Популярные  11. Сохранить  12. Загрузить  13. Добавить читателя  14. Изменить издание  15. Удалить издание  16. Добавить издание  17. Найти по номеру  0. Выход");
            int choice = readInt("Выбор: ");
            try {
                if (choice == 0) return;
                // Задание: показать каталог изданий.
                if (choice == 1) library.printPublications();
                // Задание: показать читателей.
                else if (choice == 2) library.printReaders();
                // Задание: выдать издание читателю.
                else if (choice == 3) library.lend(readLine("Инвентарный номер: "), readLine("ID читателя: "), readLine("Место (абонемент/читальный зал): "));
                // Задание: принять издание и рассчитать штраф.
                else if (choice == 4) library.returnLoan(readLine("Инвентарный номер: "), readLine("ID читателя: "));
                // Задание: продлить срок выдачи.
                else if (choice == 5) library.renew(readLine("Инвентарный номер: "), readLine("ID читателя: "));
                // Задание: искать издание по названию или автору.
                else if (choice == 6) library.search(readLine("Подстрока названия или автор: "));
                // Задание: сортировать каталог.
                else if (choice == 7) library.printSorted();
                // Задание: вывести должников.
                else if (choice == 8) library.printDebtors();
                // Задание: показать историю выдач читателя.
                else if (choice == 9) library.printHistory(readLine("ID читателя: "));
                // Задание: показать популярные издания.
                else if (choice == 10) library.printPopular();
                // Задание: сохранить данные.
                else if (choice == 11) library.save(readLine("Имя файла: "));
                // Задание: загрузить данные.
                else if (choice == 12) library.load(readLine("Имя файла: "));
                // Задание: добавить читателя.
                else if (choice == 13) library.addReader(new Reader(readLine("ID: "), readLine("Имя: ")));
                // Задание: изменить издание.
                else if (choice == 14) library.editPublication(readLine("Инвентарный номер: "), readLine("Новое название: "), readInt("Новый год: "), readLine("Новый автор: "));
                // Задание: удалить издание.
                else if (choice == 15) library.removePublication(readLine("Инвентарный номер: "));
                // Задание: добавить книгу, журнал или диссертацию.
                else if (choice == 16) addPublication(library);
                // Задание: найти издание по инвентарному номеру.
                else if (choice == 17) System.out.println(library.findPublication(readLine("Инвентарный номер: ")));
                else System.out.println("Нет такого пункта меню");
            } catch (LibraryException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void addPublication(Library library) throws LibraryException {
        String id = readLine("Инвентарный номер: ");
        String title = readLine("Название: ");
        int year = readInt("Год: ");
        String author = readLine("Автор: ");
        System.out.println("1. Книга  2. Журнал  3. Диссертация");
        int type = readInt("Тип: ");
        if (type == 1) library.addPublication(new Book(id, title, year, author));
        else if (type == 2) library.addPublication(new Magazine(id, title, year, author));
        else if (type == 3) library.addPublication(new Dissertation(id, title, year, author));
        else System.out.println("Неизвестный тип издания");
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
