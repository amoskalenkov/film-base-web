package com.moskalenkov.store;

import com.moskalenkov.models.Comment;
import com.moskalenkov.models.Film;

import java.util.Collection;

public interface Storage<T> {
    public Collection<T> values();

    public int add(final T film);

    public void edit(final T film);

    public void delete(final int id);

    public T get(final int id);

    public T findByName(final String name) ;

    public int generateId();

    public void close();

    public Collection<T> valuesByFilmId(int id);
}
