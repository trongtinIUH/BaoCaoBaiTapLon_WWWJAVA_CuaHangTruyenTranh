package iuh.fit.cuahangtruyentranh_be.controllers;

import iuh.fit.cuahangtruyentranh_be.models.Genre;
import iuh.fit.cuahangtruyentranh_be.services.GenreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/genre")
public class GenreController {

    @Autowired
    private GenreServices genreService;

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable int id) {
        Optional<Genre> genre = genreService.getGenreById(id);
        if (genre.isPresent()) {
            return ResponseEntity.ok(genre.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
