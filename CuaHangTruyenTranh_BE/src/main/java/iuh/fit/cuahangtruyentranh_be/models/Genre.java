package iuh.fit.cuahangtruyentranh_be.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "genres")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Genre(String name) {
        this.name = name;
    }
}
