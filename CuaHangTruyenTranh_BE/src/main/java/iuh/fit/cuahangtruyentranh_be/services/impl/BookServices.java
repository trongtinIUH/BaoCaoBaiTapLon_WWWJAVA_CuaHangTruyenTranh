package iuh.fit.cuahangtruyentranh_be.services.impl;

import iuh.fit.cuahangtruyentranh_be.models.Book;
import iuh.fit.cuahangtruyentranh_be.models.Genre;

import java.util.List;
import java.util.Optional;

public interface BookServices {
    List<Book> getAllBooks();
    Optional<Book> getBookById(int id);
    List<Book> getBooksByGenre(Genre genre);
    Book addBook(Book book);
    Book updateBookQuantity(int id, int availableQuantity);
    void deleteBook(int id);
}