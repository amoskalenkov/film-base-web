package com.moskalenkov.store;

import com.moskalenkov.models.Film;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class HibernateStorage implements Storage<Film> {
    private final SessionFactory factory;

    public HibernateStorage() {
//        Configuration configuration = new Configuration();
//        configuration.configure("hibernate.cfg.xml");
//        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//        factory = configuration.buildSessionFactory(ssrb.build());
        factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public Collection<Film> values() {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return session.createQuery("from Film").list();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public int add(final Film user) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(user);
            return user.getId();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public void edit(Film film) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(film);
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public void delete(int id) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(get(id));
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public Film get(int id) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return (Film) session.get(Film.class, id);
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public Film findByName(String login) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            final Query query = session.createQuery("from Film as film where film.name=:login");
            query.setString("login", login);
            return (Film) query.iterate().next();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void close() {
        this.factory.close();
    }

    @Override
    public Collection<Film> valuesByFilmId(int id) {
        return null;
    }
}