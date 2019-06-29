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
public class CommentStorage implements CommentDAO {

    private final HibernateTemplate template;

    @Autowired
    public CommentStorage(final HibernateTemplate template) {
        this.template = template;
    }
    @Override
    public Collection<Comment> values() {
        return (List<Comment>) this.template.find("from Comment");
    }

    @Transactional
    @Override
    public int add(Comment comment) {

        return (int) this.template.save(comment);
    }

    @Transactional
    @Override
    public void edit(Comment comment) {
        this.template.update(comment);
    }

    @Transactional
    @Override
    public void delete(int id) {
        this.template.bulkUpdate("delete from Comment where id=?", id);
    }

    @Override
    public Comment get(int id) {
        return (Comment) this.template.get(Comment.class, id);
    }

    @Override
    public Comment findByName(String name) {
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
    public Collection<Comment> valuesByFilmId(int id) {
        Film film = this.template.get(Film.class, id);
        return (List<Comment>) this.template.find("from Comment as comments where comments.film=?", film );

    }
}
