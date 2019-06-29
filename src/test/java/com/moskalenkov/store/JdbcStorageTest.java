package com.moskalenkov.store;

import com.moskalenkov.models.Film;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class JdbcStorageTest {

    @Test
    public void testCreate() throws Exception {
        final JdbcStorage storage = new JdbcStorage();
        final int id = storage.add(new Film(6, "test", 2));
        final Film film = storage.get(id);
        assertEquals(id, film.getId());
        storage.close();
    }

    @Test
    public void testValues() throws Exception {
        final JdbcStorage storage = new JdbcStorage();
        final Collection<Film> films = storage.values();
        for(Film film : films){
            System.out.println(film.getName());
        }

    }

    @Test
    public void testFind() throws Exception {
        final JdbcStorage storage = new JdbcStorage();
        final String name = "testFind";
        final Film film = new Film(6, name, 2);
        final int id = storage.add(film);

        assertEquals(film.getName(), storage.findByName(name).getName());
        assertEquals(film.getRating(), storage.findByName(name).getRating());
        storage.close();
    }

    @Test
    public void testEdit() throws Exception {
        final JdbcStorage storage = new JdbcStorage();
        final Film film = new Film(6, "test", 2);
        final int id = storage.add(film);
        final Film filmNew = new Film(id, "testNew", 3);
        storage.edit(filmNew);

        assertNotEquals(storage.get(id).getName(), film.getName());
        assertEquals(storage.get(id).getName(), filmNew.getName());
        storage.close();
    }

    @Test (expected = IllegalStateException.class)
    public void testDelete() throws Exception {
        final JdbcStorage storage = new JdbcStorage();
        final int id = storage.add(new Film(6, "testDelete", 2));
        storage.delete(id);

        assertNull(storage.get(id));
        storage.close();
    }


}