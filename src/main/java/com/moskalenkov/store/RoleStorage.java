package com.moskalenkov.store;

import com.moskalenkov.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Repository
public class RoleStorage implements RoleDAO {

    private final HibernateTemplate template;

    @Autowired
    public RoleStorage(final HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public Collection<Role> values() {

        return (List<Role>) this.template.find("from Role");
    }

    @Transactional
    @Override
    public int add(Role user) {
        return (int) this.template.save(user);
    }

    @Override
    public void edit(Role user) {
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Role get(int id) {
        return null;
    }

    @Override
    public Role findByName(String login) {
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
    public Collection<Role> valuesByFilmId(int id) {
        return null;
    }
}
