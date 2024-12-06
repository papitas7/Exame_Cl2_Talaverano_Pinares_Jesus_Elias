package pe.edu.cibertec.DAWI_TALAVERANO_PINARES_JESUS_ELIAS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.cibertec.DAWI_TALAVERANO_PINARES_JESUS_ELIAS.dto.FilmCreateDto;
import pe.edu.cibertec.DAWI_TALAVERANO_PINARES_JESUS_ELIAS.dto.FilmDetailDto;
import pe.edu.cibertec.DAWI_TALAVERANO_PINARES_JESUS_ELIAS.dto.FilmDto;
import pe.edu.cibertec.DAWI_TALAVERANO_PINARES_JESUS_ELIAS.service.MaintenanceService;


import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping("/start")
    public String start(Model model) {

        List<FilmDto> films = maintenanceService.findAllFilms();
        model.addAttribute("films", films);
        return "maintenance";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.findFilmById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance_detail";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.findFilmById(id);
        model.addAttribute("film", filmDetailDto);
        return "maintenance_edit";
    }

    @PostMapping("/edit-confirm")
    public String editConfirm(@ModelAttribute FilmDetailDto filmDetailDto, Model model) {
        maintenanceService.updateFilm(filmDetailDto);
        return "redirect:/maintenance/start";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("filmCreateDto", new FilmCreateDto("", "", 0, 0, "", 0, 0.0, 0, 0.0, "", "", new Date()));
        return "maintenance_add";
    }

    @PostMapping("/add-confirm")
    public String addConfirm(@ModelAttribute FilmCreateDto filmCreateDto, Model model) {
        Boolean success = maintenanceService.addFilm(filmCreateDto);
        if (success) {
            return "redirect:/maintenance/start";
        } else {
            model.addAttribute("error", "Error al agregar");
            return "maintenance_add";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Boolean success = maintenanceService.deleteFilmById(id);
        if (success) {
            redirectAttributes.addFlashAttribute("message", "Eliminado.");
        } else {
            redirectAttributes.addFlashAttribute("error", "Error.");
        }
        return "redirect:/maintenance/start";
    }


}
