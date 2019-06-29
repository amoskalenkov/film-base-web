package com.moskalenkov.servlets;

import com.moskalenkov.store.FilmCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class FilmDeleteServlet extends HttpServlet {

    private static final FilmCache FILM_CACHE = FilmCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FILM_CACHE.delete(Integer.valueOf(req.getParameter("id")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/film/view"));
    }
}