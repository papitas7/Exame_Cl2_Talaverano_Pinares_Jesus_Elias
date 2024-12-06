package pe.edu.cibertec.DAWI_TALAVERANO_PINARES_JESUS_ELIAS.service;

import pe.edu.cibertec.DAWI_TALAVERANO_PINARES_JESUS_ELIAS.dto.FilmCreateDto;
import pe.edu.cibertec.DAWI_TALAVERANO_PINARES_JESUS_ELIAS.dto.FilmDetailDto;
import pe.edu.cibertec.DAWI_TALAVERANO_PINARES_JESUS_ELIAS.dto.FilmDto;

import java.util.List;

public interface MaintenanceService {

    List<FilmDto> findAllFilms();

    FilmDetailDto findFilmById(int id);

    Boolean updateFilm(FilmDetailDto filmDetailDto);

    Boolean addFilm(FilmCreateDto filmCreateDto);

    Boolean deleteFilmById(int id);

}
