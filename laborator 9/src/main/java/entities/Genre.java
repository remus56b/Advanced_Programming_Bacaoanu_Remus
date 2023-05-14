package entities;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import org.hibernate.mapping.List;

@Getter
@Setter
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
//    @ManyToMany(mappedBy = "genres")
//    private Album albums;
}
