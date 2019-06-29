package com.moskalenkov.servlets;

import com.moskalenkov.models.Film;
import com.moskalenkov.store.FilmCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class FilmEditServlet extends HttpServlet {

    private static final FilmCache FILM_CACHE = FilmCache.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("film", this.FILM_CACHE.get(Integer.valueOf(req.getParameter("id"))));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/film/EditFilm.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.FILM_CACHE.edit(new Film(Integer.parseInt(req.getParameter("filmId")), req.getParameter("filmName"), Integer.parseInt(req.getParameter("filmRating"))));
        //this.storages.filmStorage.edit(new Film(Integer.parseInt(req.getParameter("filmId")), req.getParameter("filmName"), Integer.parseInt(req.getParameter("filmRating"))));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/film/view"));
    }
}
