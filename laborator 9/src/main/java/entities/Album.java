package entities;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.ToString;

@Getter
@ToString
@Setter
@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "releaseYear")
    private String releaseYear;
    @Column(name = "title")
    private String title;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "artist_id")
//    private Artist artist;

    @Column(name = "artist")
    private String artist;
    @Column(name = "genre")
    private String genre;
}
