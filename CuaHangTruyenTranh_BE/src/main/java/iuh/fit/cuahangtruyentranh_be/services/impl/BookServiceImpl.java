package iuh.fit.cuahangtruyentranh_be.services.impl;

import iuh.fit.cuahangtruyentranh_be.models.Book;
import iuh.fit.cuahangtruyentranh_be.models.Genre;
import iuh.fit.cuahangtruyentranh_be.repositories.BookRepository;
import iuh.fit.cuahangtruyentranh_be.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookServices {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> getBooksByGenre(Genre genre) {
        return bookRepository.findByGenre(genre);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBookQuantity(int id, int availableQuantity) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setAvailableQuantity(availableQuantity);
            return bookRepository.save(book);
        } else {
            throw new IllegalArgumentException("Book not found with ID: " + id);
        }
    }

    @Override
    public void deleteBook(int id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setAvailable(!book.isAvailable());
            bookRepository.save(book);
        }
    }

}