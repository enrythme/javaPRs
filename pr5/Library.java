package pr5;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public final class Library {
    private static final int MAX_LOANS = 5;
    private static final int MAX_RENEWALS = 2;
    private Publication[] publications = new Publication[0];
    private Reader[] readers = new Reader[0];
    private Loan[] loans = new Loan[0];

    // Задание: добавить издание с проверкой уникальности инвентарного номера.
    public void addPublication(Publication publication) throws LibraryException {
        if (findPublicationOrNull(publication.getInventoryId()) != null) throw new LibraryException("Такой инвентарный номер уже существует");
        publications = append(publications, publication);
    }

    // Задание: добавить читателя с проверкой уникальности ID.
    public void addReader(Reader reader) throws LibraryException {
        if (findReaderOrNull(reader.getId()) != null) throw new LibraryException("Такой читатель уже существует");
        readers = append(readers, reader);
    }

    public Publication findPublication(String id) throws NotFoundException {
        Publication publication = findPublicationOrNull(id);
        if (publication == null) throw new NotFoundException("Издание не найдено");
        return publication;
    }

    private Publication findPublicationOrNull(String id) {
        for (Publication publication : publications) if (publication.getInventoryId().equalsIgnoreCase(id)) return publication;
        return null;
    }

    private Reader findReader(String id) throws NotFoundException {
        Reader reader = findReaderOrNull(id);
        if (reader == null) throw new NotFoundException("Читатель не найден");
        return reader;
    }

    private Reader findReaderOrNull(String id) {
        for (Reader reader : readers) if (reader.getId().equalsIgnoreCase(id)) return reader;
        return null;
    }

    private Loan findActiveLoan(Publication publication, Reader reader) {
        for (Loan loan : loans) if (loan.getPublication() == publication && loan.getReader() == reader && !loan.isReturned()) return loan;
        return null;
    }

    // Задание: выдать издание, соблюдая лимит и правила для диссертаций.
    public void lend(String publicationId, String readerId, String place) throws LibraryException {
        Publication publication = findPublication(publicationId);
        Reader reader = findReader(readerId);
        if (!publication.isAvailable()) throw new PublicationNotAvailableException("Издание уже выдано");
        if (reader.activeCount() >= MAX_LOANS) throw new LimitExceededException("Превышен лимит изданий на читателя");
        if (publication instanceof Dissertation && !place.equalsIgnoreCase("читальный зал")) throw new LibraryException("Диссертация доступна только в читальном зале");
        publication.setAvailable(false);
        Loan loan = new Loan(reader, publication, LocalDate.now(), LocalDate.now().plusDays(publication.loanDays()));
        reader.addLoan(loan);
        loans = append(loans, loan);
        System.out.println("Выдано до " + loan.getDue());
    }

    // Задание: принять возврат и рассчитать штраф с учётом типа издания.
    public void returnLoan(String publicationId, String readerId) throws LibraryException {
        Publication publication = findPublication(publicationId);
        Reader reader = findReader(readerId);
        Loan loan = findActiveLoan(publication, reader);
        if (loan == null) throw new NotFoundException("Активная выдача не найдена");
        loan.markReturned(LocalDate.now());
        publication.setAvailable(true);
        System.out.println("Возврат принят. Штраф: " + loan.fine(LocalDate.now()));
    }

    // Задание: продлить выдачу не более двух раз.
    public void renew(String publicationId, String readerId) throws LibraryException {
        Loan loan = findActiveLoan(findPublication(publicationId), findReader(readerId));
        if (loan == null) throw new NotFoundException("Активная выдача не найдена");
        if (loan.getRenewals() >= MAX_RENEWALS) throw new LibraryException("Продление уже использовано дважды");
        loan.renew();
        System.out.println("Новый срок: " + loan.getDue());
    }

    // Задание: искать издание по подстроке названия или автору.
    public void search(String query) {
        for (Publication publication : publications) {
            if (publication.getTitle().toLowerCase().contains(query.toLowerCase()) || publication.getAuthor().toLowerCase().contains(query.toLowerCase())) System.out.println(publication);
        }
    }

    // Задание: показать каталог изданий.
    public void printPublications() { for (Publication publication : publications) System.out.println(publication); }

    public void printReaders() { for (Reader reader : readers) System.out.println(reader); }

    // Задание: сортировать по году издания и названию.
    public void printSorted() {
        Publication[] copy = Arrays.copyOf(publications, publications.length);
        for (int i = 1; i < copy.length; i++) {
            Publication current = copy[i];
            int j = i - 1;
            while (j >= 0 && compare(copy[j], current) > 0) {
                copy[j + 1] = copy[j];
                j--;
            }
            copy[j + 1] = current;
        }
        for (Publication publication : copy) System.out.println(publication);
    }

    // Задание: сформировать отчёт о должниках и суммах штрафов.
    public void printDebtors() {
        boolean found = false;
        for (Loan loan : loans) if (loan.fine(LocalDate.now()) > 0) { System.out.println(loan); found = true; }
        if (!found) System.out.println("Должников нет");
    }

    // Задание: показать историю выдач выбранного читателя.
    public void printHistory(String readerId) throws LibraryException {
        Reader reader = findReader(readerId);
        for (Loan loan : loans) if (loan.getReader() == reader) System.out.println(loan);
    }

    // Задание: показать до пяти самых популярных изданий.
    public void printPopular() {
        int[] counts = new int[publications.length];
        int[] order = new int[publications.length];
        for (int i = 0; i < publications.length; i++) {
            order[i] = i;
            for (Loan loan : loans) if (loan.getPublication() == publications[i]) counts[i]++;
        }
        for (int i = 0; i < order.length; i++) {
            for (int j = i + 1; j < order.length; j++) {
                if (counts[order[j]] > counts[order[i]]) {
                    int swap = order[i];
                    order[i] = order[j];
                    order[j] = swap;
                }
            }
        }
        for (int i = 0; i < Math.min(5, order.length); i++) System.out.println(publications[order[i]] + " | выдач: " + counts[order[i]]);
    }

    // Задание: изменить данные издания.
    public void editPublication(String id, String title, int year, String author) throws LibraryException {
        Publication publication = findPublication(id);
        if (!publication.isAvailable()) throw new LibraryException("Нельзя изменить выданное издание");
        if (year < 0 || title.isEmpty() || author.isEmpty()) throw new LibraryException("Некорректные данные издания");
        publication.edit(title, year, author);
    }

    // Задание: удалить доступное издание.
    public void removePublication(String id) throws LibraryException {
        Publication publication = findPublication(id);
        if (!publication.isAvailable()) throw new LibraryException("Нельзя удалить выданное издание");
        Publication[] result = new Publication[publications.length - 1];
        int index = 0;
        for (Publication item : publications) if (item != publication) result[index++] = item;
        publications = result;
    }

    // Задание: сохранить каталог, читателей и историю выдач в файл.
    public void save(String filename) throws LibraryException {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Publication publication : publications) writer.println(publication.encode());
            for (Reader reader : readers) writer.println("READER\t" + reader.getId() + "\t" + reader.getName());
            for (Loan loan : loans) {
                writer.println("LOAN\t" + loan.getReader().getId() + "\t" + loan.getPublication().getInventoryId() + "\t" + loan.getIssued() + "\t" + loan.getDue() + "\t" + (loan.getReturned() == null ? "" : loan.getReturned()) + "\t" + loan.getRenewals());
            }
        } catch (IOException e) {
            throw new LibraryException("Не удалось сохранить файл: " + e.getMessage());
        }
    }

    // Задание: загрузить данные из файла и восстановить связи между объектами.
    public void load(String filename) throws LibraryException {
        Library loaded = new Library();
        try (Scanner file = new Scanner(new File(filename))) {
            while (file.hasNextLine()) {
                String[] fields = file.nextLine().split("\\t", -1);
                if (fields.length == 0) continue;
                if (fields[0].equals("READER") && fields.length == 3) {
                    loaded.readers = append(loaded.readers, new Reader(fields[1], fields[2]));
                } else if (fields[0].equals("BOOK") && fields.length == 6) {
                    Book publication = new Book(fields[1], fields[2], Integer.parseInt(fields[3]), fields[4]);
                    publication.setAvailable(Boolean.parseBoolean(fields[5]));
                    loaded.publications = append(loaded.publications, publication);
                } else if (fields[0].equals("MAGAZINE") && fields.length == 6) {
                    Magazine publication = new Magazine(fields[1], fields[2], Integer.parseInt(fields[3]), fields[4]);
                    publication.setAvailable(Boolean.parseBoolean(fields[5]));
                    loaded.publications = append(loaded.publications, publication);
                } else if (fields[0].equals("DISSERTATION") && fields.length == 6) {
                    Dissertation publication = new Dissertation(fields[1], fields[2], Integer.parseInt(fields[3]), fields[4]);
                    publication.setAvailable(Boolean.parseBoolean(fields[5]));
                    loaded.publications = append(loaded.publications, publication);
                } else if (fields[0].equals("LOAN") && fields.length == 7) {
                    Reader reader = loaded.findReader(fields[1]);
                    Publication publication = loaded.findPublication(fields[2]);
                    Loan loan = new Loan(reader, publication, LocalDate.parse(fields[3]), LocalDate.parse(fields[4]));
                    loan.setReturned(fields[5].isEmpty() ? null : LocalDate.parse(fields[5]));
                    loan.setRenewals(Integer.parseInt(fields[6]));
                    reader.addLoan(loan);
                    loaded.loans = append(loaded.loans, loan);
                } else {
                    throw new LibraryException("Некорректная строка данных");
                }
            }
        } catch (IOException | RuntimeException e) {
            throw new LibraryException("Не удалось загрузить файл: " + e.getMessage());
        }
        publications = loaded.publications;
        readers = loaded.readers;
        loans = loaded.loans;
    }

    private static int compare(Publication first, Publication second) {
        int byYear = Integer.compare(first.getYear(), second.getYear());
        return byYear != 0 ? byYear : first.getTitle().compareToIgnoreCase(second.getTitle());
    }

    private static Publication[] append(Publication[] values, Publication value) {
        Publication[] result = Arrays.copyOf(values, values.length + 1);
        result[values.length] = value;
        return result;
    }

    private static Reader[] append(Reader[] values, Reader value) {
        Reader[] result = Arrays.copyOf(values, values.length + 1);
        result[values.length] = value;
        return result;
    }

    private static Loan[] append(Loan[] values, Loan value) {
        Loan[] result = Arrays.copyOf(values, values.length + 1);
        result[values.length] = value;
        return result;
    }
}
