package services;

import entities.Artist;
import entities.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.GenreRepository;

import java.util.Optional;


@Service
@Transactional
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public void create(Genre genre) {
        genreRepository.save(genre);
    }

    public Optional<Genre> findById(int id) {
        return Optional.ofNullable(genreRepository.findById(id));
    }

    public void print(Genre genre)
    {
        System.out.println(genre);
    }
}
