package services;

import entities.Album;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.AlbumRepository;

@Setter
@Service
@Transactional
public class AlbumService {

    private AlbumRepository albumRepository;

    public void create(Album album) {
        albumRepository.save(album);
    }

    public Album findById(int id) {
        return albumRepository.findById(id);
    }

    public Album findByName(String name) {
        return albumRepository.findByName(name);
    }

    public void print(Album album) {
        System.out.println(album);
    }
}
