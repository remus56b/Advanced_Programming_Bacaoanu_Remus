package repositories;

import entities.Artist;
import entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    @Query("SELECT a FROM Genre a WHERE a.id = ?1")
    Genre findById(int id);

    @Query("SELECT a FROM Genre a WHERE a.name LIKE %?1%")
    Genre findByName(String name);
}
