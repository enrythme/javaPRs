package pr4;

import java.util.Arrays;

public final class Library {
    private Book[] books = new Book[0];
    private Reader[] readers = new Reader[0];

    public void addBook(Book book) {
        books = Arrays.copyOf(books, books.length + 1);
        books[books.length - 1] = book;
    }

    public void addReader(Reader reader) {
        readers = Arrays.copyOf(readers, readers.length + 1);
        readers[readers.length - 1] = reader;
    }

    private Book findByTitle(String title) throws LibraryException {
        for (Book book : books) if (book.getTitle().equalsIgnoreCase(title)) return book;
        throw new LibraryException("Книга не найдена");
    }

    public void printBooks() {
        for (Book book : books) System.out.println(book);
    }

    public void printSorted() {
        Book[] copy = Arrays.copyOf(books, books.length);
        for (int i = 1; i < copy.length; i++) {
            Book current = copy[i];
            int j = i - 1;
            while (j >= 0 && copy[j].getYear() > current.getYear()) {
                copy[j + 1] = copy[j];
                j--;
            }
            copy[j + 1] = current;
        }
        for (Book book : copy) System.out.println(book);
    }

    public void search(String query) {
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) || book.getAuthor().toLowerCase().contains(query.toLowerCase())) System.out.println(book);
        }
    }

    public void lend(String title, Reader reader) throws LibraryException {
        Book book = findByTitle(title);
        book.lendTo(reader);
        reader.add(book);
        System.out.println("Книга выдана");
    }

    public void returnBook(String title, Reader reader) throws LibraryException {
        Book book = findByTitle(title);
        book.returnFrom(reader);
        reader.remove(book);
        System.out.println("Книга возвращена");
    }
}
