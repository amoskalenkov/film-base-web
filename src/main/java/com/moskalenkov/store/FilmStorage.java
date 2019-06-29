package com.moskalenkov.store;

import com.moskalenkov.models.Comment;
import com.moskalenkov.models.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Repository
public class FilmStorage implements FilmDAO {

    private final HibernateTemplate template;


    @Autowired
    public FilmStorage(final HibernateTemplate template) {
        this.template = template;
    }
    @Override
    public Collection<Film> values() {
        return (List<Film>) this.template.find("from Film");
    }

    @Transactional
    @Override
    public int add(Film film) {
        return (int) this.template.save(film);
    }

    @Transactional
    @Override
    public void edit(Film film) {
        this.template.update(film);
    }

    @Transactional
    @Override
    public void delete(int id) {
        this.template.bulkUpdate("delete from Film where id=?", id);
    }

    @Override
    public Film get(int id) {

        return (Film) this.template.get(Film.class, id);
    }

    @Override
    public Film findByName(String name) {
        return null;
    }

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void close() {

    }

    @Override
    public Collection<Film> valuesByFilmId(int id) {
        return null;
    }
}
