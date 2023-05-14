package services;

import entities.Album;
import entities.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.ArtistRepository;

import java.util.Optional;


@Service
@Transactional
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;
    public void create(Artist artist) {
        artistRepository.save(artist);
    }

    public Optional<Artist> findById(int id) {
        return Optional.ofNullable(artistRepository.findById(id));
    }

    public Artist findByName(String name) {
        return artistRepository.findByName(name);
    }
    public void print(Artist artist)
    {
        System.out.println(artist);
    }
}
