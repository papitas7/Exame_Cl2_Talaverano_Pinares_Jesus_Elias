package pe.edu.cibertec.DAWI_TALAVERANO_PINARES_JESUS_ELIAS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actorId;
    private String firstName;
    private String lastName;
    private String lastUpdate;

    @OneToMany(mappedBy = "actor")
    private List<FilmActor> filmActors;

}
