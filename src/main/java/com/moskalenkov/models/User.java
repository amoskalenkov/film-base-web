package com.moskalenkov.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String login;
    private String password;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="role_id")
    private Role role;

    public User() {
    }

    public User(final String login, final String password) {
        this.login = login;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
