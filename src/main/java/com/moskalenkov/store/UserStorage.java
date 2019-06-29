package com.moskalenkov.store;

import com.moskalenkov.models.Role;
import com.moskalenkov.models.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class UserStorage implements UserDAO {

    private final SessionFactory factory;

    public UserStorage() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Role.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        factory = configuration.buildSessionFactory(builder.build());
    }
    @Override
    public Collection<User> values() {
        return null;
    }

    @Override
    public int add(User film) {
        return 0;
    }

    @Override
    public void edit(User film) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public User findByName(String name) {
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
    public Collection<User> valuesByFilmId(int id) {
        return null;
    }

    public User findByAuth(final String login, final String password) {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            final Query query = session.createQuery("from User as users where users.login=:login and users.password=:password");
            query.setString("login", login);
            query.setString("password", password);
            List<User> users = query.list();
            return users.isEmpty() ? null : users.iterator().next();
        } finally {
            tx.commit();
            session.close();
        }
    }
}
