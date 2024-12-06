package pe.edu.cibertec.DAWI_TALAVERANO_PINARES_JESUS_ELIAS.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmCategoryPk {
    private Integer filmId;
    private Integer categoryId;
}
