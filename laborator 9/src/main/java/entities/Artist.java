package entities;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@Setter
@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "artist")
    private List<Album> albums;


}
