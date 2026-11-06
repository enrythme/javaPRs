import java.util.Arrays;
import java.util.Scanner;

public class LibraryVariant1Basic {
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
                else if (choice == 4) {
                    String title = readLine("Название книги: ");
                    library.lend(title, reader);
                } else if (choice == 5) { // Задание: принять книгу обратно.
                    String title = readLine("Название книги: ");
                    library.returnBook(title, reader);
                } else if (choice == 6) { // Задание: показать книги на руках у читателя.
                    reader.printBooks();
                }
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

    // Модель книги с состоянием выдачи.
    private abstract static class Book {
        private final String title;
        private final String author;
        private final int year;
        private Reader borrowedBy;

        private Book(String title, String author, int year) { this.title = title; this.author = author; this.year = year; }
        private String getTitle() { return title; }
        private String getAuthor() { return author; }
        private int getYear() { return year; }
        private boolean isAvailable() { return borrowedBy == null; }
        private void lendTo(Reader reader) throws LibraryException { if (!isAvailable()) throw new LibraryException("Книга уже выдана"); borrowedBy = reader; }
        private void returnFrom(Reader reader) throws LibraryException { if (borrowedBy != reader) throw new LibraryException("Книга не числится у этого читателя"); borrowedBy = null; }
        @Override public String toString() { return getType() + ": " + title + ", " + author + ", " + year + (isAvailable() ? ", доступна" : ", выдана"); }
        protected abstract String getType();
        @Override public boolean equals(Object object) { if (!(object instanceof Book)) return false; Book other = (Book) object; return title.equalsIgnoreCase(other.title) && author.equalsIgnoreCase(other.author) && year == other.year; }
        @Override public int hashCode() { return (title.toLowerCase() + author.toLowerCase() + year).hashCode(); }
    }

    // Вариант книги: учебник.
    private static final class Textbook extends Book {
        private final String subject;
        private Textbook(String title, String author, int year, String subject) { super(title, author, year); this.subject = subject; }
        @Override protected String getType() { return "Учебник"; }
        @Override public String toString() { return super.toString() + ", предмет: " + subject; }
    }

    // Вариант книги: роман.
    private static final class Novel extends Book {
        private final String genre;
        private Novel(String title, String author, int year, String genre) { super(title, author, year); this.genre = genre; }
        @Override protected String getType() { return "Роман"; }
        @Override public String toString() { return super.toString() + ", жанр: " + genre; }
    }

    // Читатель и список книг, которые находятся у него.
    private static final class Reader {
        private final String name;
        private Book[] borrowed = new Book[0];
        private Reader(String name) { this.name = name; }
        private void add(Book book) { borrowed = Arrays.copyOf(borrowed, borrowed.length + 1); borrowed[borrowed.length - 1] = book; }
        private void remove(Book book) { Book[] result = new Book[borrowed.length - 1]; int index = 0; for (Book item : borrowed) if (item != book) result[index++] = item; borrowed = result; }
        private void printBooks() { System.out.println(name); for (Book book : borrowed) System.out.println(book); }
        @Override public String toString() { return name; }
    }

    // Хранилище книг и операции библиотеки.
    private static final class Library {
        private Book[] books = new Book[0];
        private Reader[] readers = new Reader[0];
        private void addBook(Book book) { books = Arrays.copyOf(books, books.length + 1); books[books.length - 1] = book; }
        private void addReader(Reader reader) { readers = Arrays.copyOf(readers, readers.length + 1); readers[readers.length - 1] = reader; }
        private Book findByTitle(String title) throws LibraryException { for (Book book : books) if (book.getTitle().equalsIgnoreCase(title)) return book; throw new LibraryException("Книга не найдена"); }
        private void printBooks() { for (Book book : books) System.out.println(book); }
        private void printSorted() { Book[] copy = Arrays.copyOf(books, books.length); for (int i = 1; i < copy.length; i++) { Book current = copy[i]; int j = i - 1; while (j >= 0 && copy[j].getYear() > current.getYear()) { copy[j + 1] = copy[j]; j--; } copy[j + 1] = current; } for (Book book : copy) System.out.println(book); }
        private void search(String query) { for (Book book : books) if (book.getTitle().toLowerCase().contains(query.toLowerCase()) || book.getAuthor().toLowerCase().contains(query.toLowerCase())) System.out.println(book); }
        private void lend(String title, Reader reader) throws LibraryException { Book book = findByTitle(title); book.lendTo(reader); reader.add(book); System.out.println("Книга выдана"); }
        private void returnBook(String title, Reader reader) throws LibraryException { Book book = findByTitle(title); book.returnFrom(reader); reader.remove(book); System.out.println("Книга возвращена"); }
    }

    private static final class LibraryException extends Exception {
        private LibraryException(String message) { super(message); }
    }
}
