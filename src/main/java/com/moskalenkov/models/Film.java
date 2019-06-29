package com.moskalenkov.models;

import java.util.List;
import java.util.Set;

public class Film extends Base{

    private String name;
    private int rating;
    private Set<Comment> comments;

    public Film() {
    }

    public Film(String name) {
        this.name = name;
    }

    public Film(int id, String name, int rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
