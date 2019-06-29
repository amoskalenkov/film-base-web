package com.moskalenkov.controllers;

import com.moskalenkov.models.Film;
import com.moskalenkov.store.Storages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private Storages storages;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String showFilm(ModelMap model) {
        model.addAttribute("films", storages.filmStorage.values());
        return "film/FilmView";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editFilm(String id, ModelMap model) {
        model.addAttribute("film", storages.filmStorage.get(Integer.parseInt(id)));
        model.addAttribute("comments", storages.commentStorage.valuesByFilmId(Integer.parseInt(id)));
        return "film/EditFilm";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editFilm(String filmId, String filmName, String filmRating, ModelMap model) {
        this.storages.filmStorage.edit(new Film(Integer.parseInt(filmId), filmName, Integer.parseInt(filmRating)));
        return "redirect:view";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createFilm(String filmName, String filmRating, ModelMap model) {
        Film film = new Film();
        film.setName(filmName);
        film.setRating(Integer.parseInt(filmRating));
        this.storages.filmStorage.add(film);
        return "redirect:view";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteFilm(String id, ModelMap model) {
        this.storages.filmStorage.delete(Integer.parseInt(id));
        return "redirect:view";
    }
}
