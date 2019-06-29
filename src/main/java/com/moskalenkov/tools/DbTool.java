package com.moskalenkov.tools;

import com.moskalenkov.models.Film;
import com.moskalenkov.store.Storages;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DbTool {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Storages storage = context.getBean(Storages.class);
        //System.out.println(storage.hibernateStorage.values());
        //storage.hibernateStorage.add(new Film("Babaduk"));
    }
}
