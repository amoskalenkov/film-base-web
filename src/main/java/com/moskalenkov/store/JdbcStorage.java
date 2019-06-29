package com.moskalenkov.store;

import com.moskalenkov.models.Film;
import com.moskalenkov.service.Settings;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JdbcStorage implements Storage<Film> {

    private final Connection connection;

    public JdbcStorage() {
        final Settings settings = Settings.getInstance();
        try {
            Class.forName(settings.value("jdbc.driver_class"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            this.connection = DriverManager.getConnection(settings.value("jdbc.url"), settings.value("jdbc.username"), settings.value("jdbc.password"));
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Collection<Film> values() {
        final List<Film> films = new ArrayList<>();
        try (final Statement statement = this.connection.createStatement();
             final ResultSet rs = statement.executeQuery("select * from films")) {
            while (rs.next()) {
                films.add(new Film(rs.getInt("uid"), rs.getString("name"), rs.getInt("rating")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }

    @Override
    public int add(Film film) {
        try (final PreparedStatement statement = this.connection.prepareStatement("insert into films (name, rating) values (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, film.getName());
            statement.setInt(2, film.getRating());
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not create new film");
    }

    @Override
    public void edit(Film film) {
        try (final PreparedStatement statement = this.connection.prepareStatement("update films set name = (?), rating = (?) where uid=(?)")) {
            statement.setString(1, film.getName());
            statement.setInt(2, film.getRating());
            statement.setInt(3, film.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try(final PreparedStatement statement = this.connection.prepareStatement("delete from films where uid=(?)")){
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Film get(int id) {
        try (final PreparedStatement statement = this.connection.prepareStatement("select * from films where uid=(?)")) {
            statement.setInt(1, id);
            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    return new Film(rs.getInt("uid"), rs.getString("name"), rs.getInt("rating"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException(String.format("Film %s does not exists", id));
    }

    @Override
    public Film findByName(String name) {
        try (final PreparedStatement statement = this.connection.prepareStatement("select * from films where name=(?)")) {
            statement.setString(1, name);
            try (final ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    return new Film(rs.getInt("uid"), rs.getString("name"), rs.getInt("rating"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException(String.format("Film %s does not exists", name));
    }

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Film> valuesByFilmId(int id) {
        return null;
    }
}
