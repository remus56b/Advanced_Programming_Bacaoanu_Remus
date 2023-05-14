package repositories;

import entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
    @Query( "SELECT a FROM Album a WHERE a.id = ?1")
    Album findById(int id);

    @Query("SELECT a FROM Album a WHERE a.title LIKE %?1%")
    Album findByName(String title);

}
