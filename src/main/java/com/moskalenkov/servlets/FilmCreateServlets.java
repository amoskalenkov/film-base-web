package com.moskalenkov.servlets;

import com.moskalenkov.models.Film;
import com.moskalenkov.store.FilmCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class FilmCreateServlets extends HttpServlet {

    final AtomicInteger ids = new AtomicInteger();

    private final FilmCache FILM_CACHE = FilmCache.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.FILM_CACHE.add(new Film(FILM_CACHE.generateId(), req.getParameter("filmName"), Integer.parseInt(req.getParameter("filmRating"))));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/film/view"));
    }
}
