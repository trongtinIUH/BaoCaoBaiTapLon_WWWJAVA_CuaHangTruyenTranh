package iuh.fit.cuahangtruyentranh_be.repositories;

import iuh.fit.cuahangtruyentranh_be.models.Book;
import iuh.fit.cuahangtruyentranh_be.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByGenre(Genre genre);
}