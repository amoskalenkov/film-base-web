package com.moskalenkov.store;

import com.moskalenkov.models.Film;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MemoryStorage implements Storage<Film>{

    private final AtomicInteger ids = new AtomicInteger();

    private final ConcurrentHashMap<Integer, Film> films = new ConcurrentHashMap<Integer, Film>();


    @Override
    public Collection<Film> values() {
        return this.films.values();
    }

    @Override
    public int add(Film film) {
        this.films.put(film.getId(), film);
        return film.getId();
    }

    @Override
    public void edit(Film film) {
        this.films.replace(film.getId(), film);
    }

    @Override
    public void delete(int id) {
        this.films.remove(id);
    }

    @Override
    public Film get(int id) {
        return this.films.get(id);
    }

    @Override
    public Film findByName(String name) {
        for (final Film film : films.values()) {
            if (film.getName().equals(name)) {
                return film;
            }
        }
        throw new IllegalStateException(String.format("Name %s not found", name));
    }

    @Override
    public int generateId() {
        return this.ids.incrementAndGet();
    }

    @Override
    public void close() {

    }

    @Override
    public Collection<Film> valuesByFilmId(int id) {
        return null;
    }
}
