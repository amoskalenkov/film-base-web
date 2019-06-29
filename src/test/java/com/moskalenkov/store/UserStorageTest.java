package com.moskalenkov.store;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserStorageTest {

    @Test
    public void findByAuth() {
        new UserStorage().findByAuth("root", "root");
    }
}