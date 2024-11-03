package iuh.fit.cuahangtruyentranh_be.services;

import iuh.fit.cuahangtruyentranh_be.models.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreServices {
    List<Genre> getAllGenres();
    Optional<Genre> getGenreById(int id);
}