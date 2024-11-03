package iuh.fit.cuahangtruyentranh_be.repositories;

import iuh.fit.cuahangtruyentranh_be.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}