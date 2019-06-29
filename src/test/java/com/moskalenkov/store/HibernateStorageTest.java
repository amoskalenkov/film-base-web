package com.moskalenkov.store;

import com.moskalenkov.models.Comment;
import com.moskalenkov.models.Film;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class HibernateStorageTest {
    @Test
    public void testCreate() throws Exception {
        final HibernateStorage storage = new HibernateStorage();
        final int id = storage.add(new Film(-1, "hibenate", 0));
        final Film user = storage.get(id);
        assertEquals(id, user.getId());
        assertEquals(id, storage.findByName("hibenate").getId());
        storage.delete(id);
        assertNull(storage.get(id));
        storage.close();
    }

    @Test
    public void testCreateUser() throws Exception {
        final HibernateStorage storage = new HibernateStorage();
        Film film = new Film();
        film.setName("Gladiator2000");
        film.setRating(10);
        final int id = storage.add(film);
        film = storage.get(id);
        Comment message = new Comment();
        message.setFilm(film);
        message.setText("very good");
        HashSet<Comment> messages = new HashSet<Comment>();
        messages.add(message);
        film.setComments(messages);
        storage.edit(film);
        assertEquals(1, storage.get(id).getComments().size());
        storage.delete(id);
        storage.close();
    }

}