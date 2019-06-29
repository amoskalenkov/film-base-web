package com.moskalenkov.servlets;

import com.moskalenkov.models.Film;
import com.moskalenkov.store.FilmCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class FilmViewServlets extends HttpServlet {

    private final FilmCache FILM_CACHE = FilmCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("films", this.FILM_CACHE.values());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/film/FilmView.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
        FILM_CACHE.close();
    }
}
