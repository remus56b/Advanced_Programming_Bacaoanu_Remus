package repositories;

import entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    @Query("SELECT a FROM Artist a WHERE a.id = ?1")
    Artist findById(int id);

    @Query("SELECT a FROM Artist a WHERE a.name LIKE %?1%")
    Artist findByName(String name);
}
