package com.moskalenkov.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Storages {

    public final RoleDAO roleStorage;
    public final CommentDAO commentStorage;
    public final FilmDAO filmStorage;
    public final UserStorage userStorage;




    @Autowired
    public Storages(final RoleDAO roleStorage, final CommentDAO commentStorage, final FilmDAO filmStorage, final UserStorage userStorage) {
        this.roleStorage = roleStorage;
        this.commentStorage = commentStorage;
        this.filmStorage = filmStorage;
        this.userStorage = userStorage;
    }
}
