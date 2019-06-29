package com.moskalenkov.store;

import com.moskalenkov.models.Film;

import java.util.Collection;

public class FilmCache implements Storage<Film>{

    private static final  FilmCache INSTANCE = new FilmCache();

    private final Storage storage = new HibernateStorage();

    public static FilmCache getInstance(){return INSTANCE;}

    @Override
    public Collection<Film> values() {
        return this.storage.values();
    }

    @Override
    public int add(final Film film) {
        return this.storage.add(film);
    }

    @Override
    public void edit(final Film film) {
        this.storage.edit(film);
    }

    @Override
    public void delete(final int id) {
        this.storage.delete(id);
    }

    @Override
    public Film get (final int id){
        return (Film) this.storage.get(id);
    }

    @Override
    public Film findByName(final String name) {
        return (Film) this.storage.findByName(name);
    }

    @Override
    public int generateId() {
        return this.storage.generateId();
    }

    @Override
    public void close() {
        this.storage.close();
    }

    @Override
    public Collection<Film> valuesByFilmId(int id) {
        return null;
    }
}
