package com.moskalenkov.servlets;

import com.moskalenkov.store.FilmCache;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;

public class FilmCreateServletsTest extends Mockito {

    final FilmCache cache = FilmCache.getInstance();

    @Test
    public void creatUser() throws ServletException, IOException {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("filmName")).thenReturn("test");
        when(request.getParameter("rating")).thenReturn("0");

        assertTrue(cache.values().isEmpty());

        new FilmCreateServlets().doPost(request, response);

        verify(request, atLeast(1)).getParameter("filmName");
        verify(request, atLeast(1)).getParameter("rating");
        assertFalse(cache.values().isEmpty());



    }
}