import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Scanner;

public class LibraryVariant1Extended {
    private static final Scanner INPUT = new Scanner(System.in);
    private static final int MAX_LOANS = 5;
    private static final int MAX_RENEWALS = 2;

    public static void main(String[] args) {
        Library library = new Library();
        library.addPublication(new Book("B-100", "Java: основы", 2022, "Иванов", 14));
        library.addPublication(new Magazine("M-200", "Мир науки", 2024, "Редакция", 7));
        library.addPublication(new Dissertation("D-300", "Исследование алгоритмов", 2021, "Петров", 30));
        library.addReader(new Reader("R-1", "Анна Смирнова"));
        library.addReader(new Reader("R-2", "Иван Петров"));
        while (true) {
            System.out.println("1. Издания  2. Читатели  3. Выдать  4. Вернуть  5. Продлить  6. Поиск  7. Сортировка  8. Должники  9. История читателя  10. Популярные  11. Сохранить  12. Загрузить  13. Добавить читателя  14. Изменить издание  15. Удалить издание  0. Выход");
            int choice = readInt("Выбор: ");
            try {
                if (choice == 0) return;
                if (choice == 1) library.printPublications();
                else if (choice == 2) library.printReaders();
                else if (choice == 3) library.lend(readLine("Инвентарный номер: "), readLine("ID читателя: "), readLine("Место (абонемент/читальный зал): "));
                else if (choice == 4) library.returnLoan(readLine("Инвентарный номер: "), readLine("ID читателя: "));
                else if (choice == 5) library.renew(readLine("Инвентарный номер: "), readLine("ID читателя: "));
                else if (choice == 6) library.search(readLine("Подстрока названия или автор: "));
                else if (choice == 7) library.printSorted();
                else if (choice == 8) library.printDebtors();
                else if (choice == 9) library.printHistory(readLine("ID читателя: "));
                else if (choice == 10) library.printPopular();
                else if (choice == 11) library.save(readLine("Имя файла: "));
                else if (choice == 12) library.load(readLine("Имя файла: "));
                else if (choice == 13) library.addReader(new Reader(readLine("ID: "), readLine("Имя: ")));
                else if (choice == 14) library.editPublication(readLine("Инвентарный номер: "), readLine("Новое название: "), readInt("Новый год: "), readLine("Новый автор: "));
                else if (choice == 15) library.removePublication(readLine("Инвентарный номер: "));
                else System.out.println("Нет такого пункта меню");
            } catch (LibraryException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int readInt(String prompt) { while (true) { System.out.print(prompt); try { return Integer.parseInt(INPUT.nextLine().trim()); } catch (NumberFormatException e) { System.out.println("Введите целое число"); } } }
    private static String readLine(String prompt) { System.out.print(prompt); return INPUT.nextLine().trim(); }

    private abstract static class Publication {
        private final String inventoryId;
        private String title;
        private int year;
        private String author;
        private boolean available = true;
        private Publication(String inventoryId, String title, int year, String author) { this.inventoryId = inventoryId; this.title = title; this.year = year; this.author = author; }
        private String getInventoryId() { return inventoryId; }
        private String getTitle() { return title; }
        private int getYear() { return year; }
        private String getAuthor() { return author; }
        private boolean isAvailable() { return available; }
        private void setAvailable(boolean value) { available = value; }
        private void edit(String newTitle, int newYear, String newAuthor) { title = newTitle; year = newYear; author = newAuthor; }
        protected abstract int finePerDay();
        protected abstract int loanDays();
        protected abstract String type();
        @Override public String toString() { return type() + " " + inventoryId + " | " + title + " | " + author + " | " + year + " | " + (available ? "доступно" : "выдано"); }
        @Override public boolean equals(Object value) { return value instanceof Publication && inventoryId.equals(((Publication) value).inventoryId); }
        @Override public int hashCode() { return inventoryId.hashCode(); }
        private String encode() { return type() + "\t" + inventoryId + "\t" + title + "\t" + year + "\t" + author + "\t" + available; }
    }

    private static final class Book extends Publication {
        private Book(String id, String title, int year, String author, int days) { super(id, title, year, author); }
        @Override protected int finePerDay() { return 20; }
        @Override protected int loanDays() { return 14; }
        @Override protected String type() { return "BOOK"; }
    }
    private static final class Magazine extends Publication {
        private Magazine(String id, String title, int year, String author, int days) { super(id, title, year, author); }
        @Override protected int finePerDay() { return 10; }
        @Override protected int loanDays() { return 7; }
        @Override protected String type() { return "MAGAZINE"; }
    }
    private static final class Dissertation extends Publication {
        private Dissertation(String id, String title, int year, String author, int days) { super(id, title, year, author); }
        @Override protected int finePerDay() { return 50; }
        @Override protected int loanDays() { return 30; }
        @Override protected String type() { return "DISSERTATION"; }
    }

    private static final class Reader {
        private final String id;
        private final String name;
        private Loan[] history = new Loan[0];
        private Reader(String id, String name) { this.id = id; this.name = name; }
        private void addLoan(Loan loan) { history = append(history, loan); }
        private int activeCount() { int count = 0; for (Loan loan : history) if (!loan.isReturned()) count++; return count; }
        @Override public String toString() { return id + " | " + name + " | активных выдач: " + activeCount(); }
        @Override public boolean equals(Object value) { return value instanceof Reader && id.equals(((Reader) value).id); }
        @Override public int hashCode() { return id.hashCode(); }
    }

    private static final class Loan {
        private final Reader reader;
        private final Publication publication;
        private final LocalDate issued;
        private LocalDate due;
        private LocalDate returned;
        private int renewals;
        private Loan(Reader reader, Publication publication, LocalDate issued, LocalDate due) { this.reader = reader; this.publication = publication; this.issued = issued; this.due = due; }
        private boolean isReturned() { return returned != null; }
        private long fine(LocalDate today) { long days = Math.max(0, ChronoUnit.DAYS.between(due, returned == null ? today : returned)); return days * publication.finePerDay(); }
        @Override public String toString() { return reader.name + " | " + publication + " | " + issued + " - " + due + (returned == null ? "" : " | возврат " + returned) + " | штраф " + fine(LocalDate.now()); }
    }

    private static final class Library {
        private Publication[] publications = new Publication[0];
        private Reader[] readers = new Reader[0];
        private Loan[] loans = new Loan[0];
        private void addPublication(Publication value) throws LibraryException { if (findPublicationOrNull(value.getInventoryId()) != null) throw new LibraryException("Такой инвентарный номер уже существует"); publications = append(publications, value); }
        private void addReader(Reader value) throws LibraryException { if (findReaderOrNull(value.id) != null) throw new LibraryException("Такой читатель уже существует"); readers = append(readers, value); }
        private Publication findPublication(String id) throws LibraryException { Publication value = findPublicationOrNull(id); if (value == null) throw new NotFoundException("Издание не найдено"); return value; }
        private Publication findPublicationOrNull(String id) { for (Publication value : publications) if (value.getInventoryId().equalsIgnoreCase(id)) return value; return null; }
        private Reader findReader(String id) throws LibraryException { Reader value = findReaderOrNull(id); if (value == null) throw new NotFoundException("Читатель не найден"); return value; }
        private Reader findReaderOrNull(String id) { for (Reader value : readers) if (value.id.equalsIgnoreCase(id)) return value; return null; }
        private Loan activeLoan(Publication publication, Reader reader) { for (Loan loan : loans) if (loan.publication == publication && loan.reader == reader && !loan.isReturned()) return loan; return null; }
        private void lend(String publicationId, String readerId, String place) throws LibraryException { Publication publication = findPublication(publicationId); Reader reader = findReader(readerId); if (!publication.isAvailable()) throw new PublicationNotAvailableException("Издание уже выдано"); if (reader.activeCount() >= MAX_LOANS) throw new LimitExceededException("Превышен лимит изданий на читателя"); if (publication instanceof Dissertation && !place.equalsIgnoreCase("читальный зал")) throw new LibraryException("Диссертация доступна только в читальном зале"); publication.setAvailable(false); Loan loan = new Loan(reader, publication, LocalDate.now(), LocalDate.now().plusDays(publication.loanDays())); reader.addLoan(loan); loans = append(loans, loan); System.out.println("Выдано до " + loan.due); }
        private void returnLoan(String publicationId, String readerId) throws LibraryException { Publication publication = findPublication(publicationId); Reader reader = findReader(readerId); Loan loan = activeLoan(publication, reader); if (loan == null) throw new NotFoundException("Активная выдача не найдена"); loan.returned = LocalDate.now(); publication.setAvailable(true); System.out.println("Возврат принят. Штраф: " + loan.fine(LocalDate.now())); }
        private void renew(String publicationId, String readerId) throws LibraryException { Loan loan = activeLoan(findPublication(publicationId), findReader(readerId)); if (loan == null) throw new NotFoundException("Активная выдача не найдена"); if (loan.renewals >= MAX_RENEWALS) throw new LibraryException("Продление уже использовано дважды"); loan.due = loan.due.plusDays(loan.publication.loanDays()); loan.renewals++; System.out.println("Новый срок: " + loan.due); }
        private void search(String query) { for (Publication p : publications) if (p.getTitle().toLowerCase().contains(query.toLowerCase()) || p.getAuthor().toLowerCase().contains(query.toLowerCase())) System.out.println(p); }
        private void printPublications() { for (Publication p : publications) System.out.println(p); }
        private void printReaders() { for (Reader r : readers) System.out.println(r); }
        private void printSorted() { Publication[] copy = Arrays.copyOf(publications, publications.length); for (int i = 1; i < copy.length; i++) { Publication current = copy[i]; int j = i - 1; while (j >= 0 && comparePublication(copy[j], current) > 0) { copy[j + 1] = copy[j]; j--; } copy[j + 1] = current; } for (Publication p : copy) System.out.println(p); }
        private void printDebtors() { boolean found = false; for (Loan loan : loans) if (loan.fine(LocalDate.now()) > 0) { System.out.println(loan); found = true; } if (!found) System.out.println("Должников нет"); }
        private void printHistory(String readerId) throws LibraryException { Reader reader = findReader(readerId); for (Loan loan : loans) if (loan.reader == reader) System.out.println(loan); }
        private void printPopular() { int[] counts = new int[publications.length]; int[] order = new int[publications.length]; for (int i = 0; i < publications.length; i++) { order[i] = i; for (Loan loan : loans) if (loan.publication == publications[i]) counts[i]++; } for (int i = 0; i < order.length; i++) for (int j = i + 1; j < order.length; j++) if (counts[order[j]] > counts[order[i]]) { int swap = order[i]; order[i] = order[j]; order[j] = swap; } for (int i = 0; i < Math.min(5, order.length); i++) System.out.println(publications[order[i]] + " | выдач: " + counts[order[i]]); }
        private void editPublication(String id, String title, int year, String author) throws LibraryException { Publication p = findPublication(id); if (!p.isAvailable()) throw new LibraryException("Нельзя изменить выданное издание"); if (year < 0 || title.isEmpty() || author.isEmpty()) throw new LibraryException("Некорректные данные издания"); p.edit(title, year, author); }
        private void removePublication(String id) throws LibraryException { Publication p = findPublication(id); if (!p.isAvailable()) throw new LibraryException("Нельзя удалить выданное издание"); publications = remove(publications, p); }
        private void save(String filename) throws LibraryException { try (java.io.PrintWriter writer = new java.io.PrintWriter(filename)) { for (Publication p : publications) writer.println(p.encode()); for (Reader r : readers) writer.println("READER\t" + r.id + "\t" + r.name); for (Loan loan : loans) writer.println("LOAN\t" + loan.reader.id + "\t" + loan.publication.getInventoryId() + "\t" + loan.issued + "\t" + loan.due + "\t" + (loan.returned == null ? "" : loan.returned) + "\t" + loan.renewals); } catch (java.io.IOException e) { throw new LibraryException("Не удалось сохранить файл: " + e.getMessage()); } }
        private void load(String filename) throws LibraryException { try (java.util.Scanner file = new java.util.Scanner(new java.io.File(filename))) { Library loaded = new Library(); while (file.hasNextLine()) { String[] fields = file.nextLine().split("\\t", -1); if (fields[0].equals("READER")) loaded.readers = append(loaded.readers, new Reader(fields[1], fields[2])); else if (fields[0].equals("BOOK")) { Book p = new Book(fields[1], fields[2], Integer.parseInt(fields[3]), fields[4], 14); p.setAvailable(Boolean.parseBoolean(fields[5])); loaded.publications = append(loaded.publications, p); } else if (fields[0].equals("MAGAZINE")) { Magazine p = new Magazine(fields[1], fields[2], Integer.parseInt(fields[3]), fields[4], 7); p.setAvailable(Boolean.parseBoolean(fields[5])); loaded.publications = append(loaded.publications, p); } else if (fields[0].equals("DISSERTATION")) { Dissertation p = new Dissertation(fields[1], fields[2], Integer.parseInt(fields[3]), fields[4], 30); p.setAvailable(Boolean.parseBoolean(fields[5])); loaded.publications = append(loaded.publications, p); } else if (fields[0].equals("LOAN")) { Reader r = loaded.findReader(fields[1]); Publication p = loaded.findPublication(fields[2]); Loan loan = new Loan(r, p, LocalDate.parse(fields[3]), LocalDate.parse(fields[4])); loan.returned = fields[5].isEmpty() ? null : LocalDate.parse(fields[5]); loan.renewals = Integer.parseInt(fields[6]); r.addLoan(loan); loaded.loans = append(loaded.loans, loan); } } publications = loaded.publications; readers = loaded.readers; loans = loaded.loans; System.out.println("Данные загружены"); } catch (java.io.IOException | RuntimeException e) { throw new LibraryException("Не удалось загрузить файл: " + e.getMessage()); } }
    }

    private static Publication[] append(Publication[] values, Publication value) { Publication[] result = Arrays.copyOf(values, values.length + 1); result[values.length] = value; return result; }
    private static Reader[] append(Reader[] values, Reader value) { Reader[] result = Arrays.copyOf(values, values.length + 1); result[values.length] = value; return result; }
    private static Loan[] append(Loan[] values, Loan value) { Loan[] result = Arrays.copyOf(values, values.length + 1); result[values.length] = value; return result; }
    private static Publication[] remove(Publication[] values, Publication target) { Publication[] result = new Publication[values.length - 1]; int index = 0; for (Publication value : values) if (value != target) result[index++] = value; return result; }
    private static int comparePublication(Publication first, Publication second) { int byYear = Integer.compare(first.getYear(), second.getYear()); return byYear != 0 ? byYear : first.getTitle().compareToIgnoreCase(second.getTitle()); }

    private static final class LibraryException extends Exception { private LibraryException(String message) { super(message); } }
    private static final class NotFoundException extends LibraryException { private NotFoundException(String message) { super(message); } }
    private static final class LimitExceededException extends LibraryException { private LimitExceededException(String message) { super(message); } }
    private static final class PublicationNotAvailableException extends LibraryException { private PublicationNotAvailableException(String message) { super(message); } }
}
