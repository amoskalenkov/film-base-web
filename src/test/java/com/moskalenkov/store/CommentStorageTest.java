package com.moskalenkov.store;

import com.moskalenkov.models.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
@WebAppConfiguration
public class CommentStorageTest {

    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Test
    public void valuesByFilmId() {
        Collection<Comment> comments = new CommentStorage(hibernateTemplate).valuesByFilmId(13);
        System.out.println("************");
        for (Comment comment : comments){
            System.out.println(comment.getText());
        }
        System.out.println("************");
    }
}